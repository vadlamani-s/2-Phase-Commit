package com.example;

import com.example.grpc.CoordinatorGrpc;
import com.example.grpc.CoordinatorOuterClass;
import com.example.grpc.Keyvalue;
import com.example.grpc.keyValueStoreGrpc;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

/**
 * The KeyValueStoreImpl has all the implementations of the server class. The class method's are
 * responsible for getting the response from the client, processing and responding back..
 */
public class KeyValueStoreImpl extends keyValueStoreGrpc.keyValueStoreImplBase {

  private static final Map<Integer, String> dictionary = new HashMap<>();
  private static Logger LOGGER;
  private static String serverName;
  private static String portNumber;
  private static CoordinatorGrpc.CoordinatorBlockingStub stubCoordinator;

  /**
   * Log setup method initializes the logging setup in the class.
   */
  public static void logSetup(String sName, String portNo) {
    serverName = sName;
    portNumber = portNo;
    LOGGER = Logger.getLogger(serverName);
    LOGGER.setLevel(Level.ALL);
  }

  // Registers server with the Coordinator
  public static String coordinatorInitiation() {
    final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:50010")
            .usePlaintext().build();
    stubCoordinator = CoordinatorGrpc.newBlockingStub(channel);

    CoordinatorOuterClass.RequestCoordinator request;
    CoordinatorOuterClass.ResponseCoordinator response;

    request = CoordinatorOuterClass.RequestCoordinator.newBuilder()
            .setRequestMessage(serverName + " " + portNumber).build();

    // Coordinator Initialisation
    response = stubCoordinator.initialization(request);
    return response.getResponseMessage();
  }

  // Method for updating dictionary in each server after 2PC
  public static void dictionaryUpdate(String operation, int key, String... varArgs) {
    if (operation.equals("put")) {
      dictionary.put(key, varArgs[0]);
    }
    if (operation.equals("delete")) {
      dictionary.remove(key);
    }
  }

  @Override
  public void dictionaryOperation(Keyvalue.RequestOperation request,
                                  StreamObserver<Keyvalue.ResponseOperation> responseObserver) {
    int key = -1;
    String value;
    Keyvalue.ResponseOperation clientResponse = null;

    // Operation received from client
    String operation = request.getOperation();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    try {
      switch (operation.toLowerCase()) {
        case "put":
          key = (int) request.getKey();
          value = request.getValue();
          if (dictionary.containsKey(key)) {
            throw new IllegalArgumentException("Key already exists");
          }
          // Initiating the 2PC protocol
          CoordinatorOuterClass.RequestCoordinator coordinatorRequest = CoordinatorOuterClass
                  .RequestCoordinator.newBuilder().setRequestMessage("Starting the 2PC protocol")
                  .setOperation("put").setKey(key).setValue(value).build();

          CoordinatorOuterClass.ResponseCoordinator coordinatorResponse = stubCoordinator
                  .initPrepare(coordinatorRequest);
          LOGGER.log(Level.INFO, coordinatorResponse.getResponseMessage());

          Thread.sleep(6000);

          if (coordinatorResponse.getResponseMessage().contains("successful")) {
            clientResponse = Keyvalue.ResponseOperation.newBuilder()
                    .setResponse("Key and Value added to the dictionary").build();
            LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                    + " Key and Value inserted in Dictionary");
          }
          if (coordinatorResponse.getResponseMessage().contains("failed")) {
            clientResponse = Keyvalue.ResponseOperation.newBuilder()
                    .setResponse("Key and Value not added to the dictionary").build();
            LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                    + " Key and Value not inserted in Dictionary");
          }
          break;
        case "get":
          key = (int) request.getKey();
          if (!(dictionary.containsKey(key))) {
            throw new IllegalArgumentException("Key is not present");
          }
          value = dictionary.get((key));
          clientResponse = Keyvalue.ResponseOperation.newBuilder()
                  .setResponse("Value: " + value).build();
          LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                  + " Value returned by Dictionary");
          break;
        case "delete":
          key = (int) request.getKey();
          if (!(dictionary.containsKey(key))) {
            throw new IllegalArgumentException("Key is not present");
          }

          // Initiating the 2PC protocol
          coordinatorRequest = CoordinatorOuterClass
                  .RequestCoordinator.newBuilder().setRequestMessage("Starting the 2PC protocol")
                  .setOperation("delete").setKey(key).build();

          coordinatorResponse = stubCoordinator
                  .initPrepare(coordinatorRequest);
          LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId() + " "
                  + coordinatorResponse.getResponseMessage());

          if (coordinatorResponse.getResponseMessage().contains("successful")) {
            clientResponse = Keyvalue.ResponseOperation.newBuilder()
                    .setResponse("Key and Value deleted from the dictionary").build();
            LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                    + " Key and Value deleted from Dictionary");
          }
          if (coordinatorResponse.getResponseMessage().contains("failed")) {
            clientResponse = Keyvalue.ResponseOperation.newBuilder()
                    .setResponse("Key and Value failed to delete from dictionary").build();
            LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
                    + " Key and Value not deleted from Dictionary");
          }
          break;

        default:
          throw new IllegalArgumentException("Incorrect operation provided");
      }
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Thread ID: " + Thread.currentThread().getId() + " "
              + e.getMessage());
      switch (operation.toLowerCase()) {
        case "put":
          clientResponse = Keyvalue.ResponseOperation.newBuilder()
                  .setResponse("Received unsolicited clientResponse acknowledging unknown PUT with "
                          + "an " + "invalid Key : " + key).build();
          break;
        case "get":
          clientResponse = Keyvalue.ResponseOperation.newBuilder()
                  .setResponse("Received unsolicited clientResponse acknowledging unknown GET with "
                          + "an " + "invalid key : " + key).build();
          break;
        case "delete":
          clientResponse = Keyvalue.ResponseOperation.newBuilder()
                  .setResponse("Received unsolicited clientResponse acknowledging unknown DELETE "
                          + "with an " + "invalid key : " + key).build();
          break;
        default:
          clientResponse = Keyvalue.ResponseOperation.newBuilder()
                  .setResponse(e.getMessage()).build();
          break;
      }
    }

    // method sends the clientResponse to the Client
    responseObserver.onNext(clientResponse);

    // called after a method has sent the clientResponse
    responseObserver.onCompleted();
  }

}
