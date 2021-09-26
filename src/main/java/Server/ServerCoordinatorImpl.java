package Server;

import com.example.KeyValueStoreImpl;
import com.example.grpc.Server;
import com.example.grpc.ServerRPCGrpc;

import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.stub.StreamObserver;

public class ServerCoordinatorImpl extends ServerRPCGrpc.ServerRPCImplBase {
  private static Logger LOGGER;
  private String req;
  private String operation;
  private int key;
  private String value;

  /**
   * Log setup method initializes the logging setup in the class.
   */
  public static void logSetup(String serverName) {
    LOGGER = Logger.getLogger(serverName);
    LOGGER.setLevel(Level.ALL);
  }

  @Override
  public void prepare(Server.RequestServer request,
                      StreamObserver<Server.ResponseServer> responseObserver) {
    req = request.getRequestMessage();
    operation = request.getOperation();
    key = (int) request.getKey();
    value = request.getValue();

//    try {
//      Thread.sleep(10000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }

    Server.ResponseServer responseServer = Server.ResponseServer.newBuilder()
            .setResponseMessage("OK 200").build();
    responseObserver.onNext(responseServer);
    responseObserver.onCompleted();
    LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
            + " OK 200 -" + LOGGER.getName());
  }

  @Override
  public void commit(Server.RequestServer request,
                     StreamObserver<Server.ResponseServer> responseObserver) {
    KeyValueStoreImpl.dictionaryUpdate(operation, key, value);
    Server.ResponseServer responseServer = Server.ResponseServer.newBuilder()
            .setResponseMessage("OK 200").build();
    responseObserver.onNext(responseServer);
    responseObserver.onCompleted();
    LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
            + " Committed data to dictionary " + LOGGER.getName());
  }

  @Override
  public void abort(Server.RequestServer request,
                    StreamObserver<Server.ResponseServer> responseObserver) {
    Server.ResponseServer responseServer = Server.ResponseServer.newBuilder()
            .setResponseMessage("Abort").build();
    responseObserver.onNext(responseServer);
    responseObserver.onCompleted();
    LOGGER.log(Level.WARNING, "Thread ID: " + Thread.currentThread().getId()
            + " Aborting the dictionary operation " + LOGGER.getName());
  }

}
