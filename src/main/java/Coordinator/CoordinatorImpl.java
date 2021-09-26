package Coordinator;

import com.example.grpc.CoordinatorGrpc;
import com.example.grpc.CoordinatorOuterClass;
import com.example.grpc.Server;
import com.example.grpc.ServerRPCGrpc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class CoordinatorImpl extends CoordinatorGrpc.CoordinatorImplBase {

  private static Logger LOGGER;
  private static final Map<ServerRPCGrpc.ServerRPCBlockingStub, Boolean> serverCheckDict = new HashMap<>();
  private static final Map<ServerRPCGrpc.ServerRPCBlockingStub, Boolean> commitCheckDict = new HashMap<>();

  /**
   * Log setup method initializes the logging setup in the class.
   */
  public static void logSetup() {
    LOGGER = Logger.getLogger("Coordinator");
    LOGGER.setLevel(Level.ALL);
  }

  @Override
  public void initialization(CoordinatorOuterClass.RequestCoordinator request,
                             StreamObserver<CoordinatorOuterClass.ResponseCoordinator> responseObserver) {

    String req = request.getRequestMessage();
    String serverName = req.split(" ")[0];
    String portNo = req.split(" ")[1];

    String target = "localhost:" + portNo;

    LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId() + " Server: "
            + serverName);

    final ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
            .usePlaintext().build();
    ServerRPCGrpc.ServerRPCBlockingStub stubServer = ServerRPCGrpc.newBlockingStub(channel);

    // Dictionary updated with default false for all the studs
    serverCheckDict.put(stubServer, false);
    commitCheckDict.put(stubServer, false);

    CoordinatorOuterClass.ResponseCoordinator responseCoordinator = CoordinatorOuterClass
            .ResponseCoordinator.newBuilder()
            .setResponseMessage("Server: " + serverName + " Initialised").build();

    // method sends the response to the Server
    responseObserver.onNext(responseCoordinator);

    // called after a method has sent the response
    responseObserver.onCompleted();
  }

  @Override
  public void initPrepare(CoordinatorOuterClass.RequestCoordinator request,
                          StreamObserver<CoordinatorOuterClass.ResponseCoordinator> responseObserver) {
    boolean committed = false;
    boolean aborted = false;

    String req = request.getRequestMessage();
    String operation = request.getOperation();
    int key = (int) request.getKey();
    String value = request.getValue();
    LOGGER.log(Level.INFO, req);

    Server.RequestServer serverRequest = Server.RequestServer.newBuilder().setRequestMessage(req)
            .setOperation(operation).setKey(key).setValue(value).build();

    for (ServerRPCGrpc.ServerRPCBlockingStub stub : serverCheckDict.keySet()) {
      try {
        Server.ResponseServer responseServer = stub.withDeadlineAfter(5, TimeUnit.SECONDS)
                .prepare(serverRequest);
        if (responseServer.getResponseMessage().equals("OK 200")) {
          serverCheckDict.put(stub, !serverCheckDict.get(stub));
        }
      } catch (Exception ignored) {
      }
    }

    LOGGER.log(Level.INFO, "2PC protocol initiated");

//    // sending response to the server which initiated the 2PC
//    responseObserver.onNext(responseCoordinator);

    if (allServerOkCheck(serverCheckDict)) {
      LOGGER.log(Level.INFO, "Prepare phase successful");
      committed = initCommit();
    } else {
      LOGGER.log(Level.WARNING, "Prepare phase unsuccessful !!! Aborting");
      aborted = initAbort();
    }

    if (committed) {
      CoordinatorOuterClass.ResponseCoordinator responseCoordinator = CoordinatorOuterClass
              .ResponseCoordinator.newBuilder()
              .setResponseMessage("2PC successful").build();
      responseObserver.onNext(responseCoordinator);
    }
    if (aborted) {
      CoordinatorOuterClass.ResponseCoordinator responseCoordinator = CoordinatorOuterClass
              .ResponseCoordinator.newBuilder()
              .setResponseMessage("2PC failed").build();
      responseObserver.onNext(responseCoordinator);
    }
    responseObserver.onCompleted();
  }

  private boolean allServerOkCheck(Map<ServerRPCGrpc.ServerRPCBlockingStub, Boolean> dictionary) {
    for (boolean check : dictionary.values()) {
      if (!check) {
        return false;
      }
    }
    return true;
  }

  private void cleanUp() {
    serverCheckDict.replaceAll((s, v) -> false);
    commitCheckDict.replaceAll((s, v) -> false);
    LOGGER.log(Level.INFO, "Clean up successful");

  }

  public boolean initCommit() {
    Server.RequestServer serverRequest = Server.RequestServer.newBuilder().setRequestMessage("Commit")
            .build();
    for (ServerRPCGrpc.ServerRPCBlockingStub stub : commitCheckDict.keySet()) {
      Server.ResponseServer responseServer = stub.commit(serverRequest);
      if (responseServer.getResponseMessage().equals("OK 200")) {
        commitCheckDict.put(stub, !commitCheckDict.get(stub));
      }
    }
    LOGGER.log(Level.INFO, "Commit phase successful");
    boolean check = allServerOkCheck(commitCheckDict);
    cleanUp();
    return true;
  }

  public boolean initAbort() {
    Server.RequestServer serverRequest = Server.RequestServer.newBuilder().setRequestMessage("Abort")
            .build();
    for (ServerRPCGrpc.ServerRPCBlockingStub stub : commitCheckDict.keySet()) {
      Server.ResponseServer responseServer = stub.abort(serverRequest);
      if (responseServer.getResponseMessage().equals("Abort")) {
        commitCheckDict.put(stub, !commitCheckDict.get(stub));
      }
    }
    LOGGER.log(Level.INFO, "2PC aborted successful");
    boolean check = allServerOkCheck(commitCheckDict);
    cleanUp();
    return true;
  }
}
