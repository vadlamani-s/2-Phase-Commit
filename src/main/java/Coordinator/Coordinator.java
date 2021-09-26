package Coordinator;

import com.example.grpc.CoordinatorGrpc;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import io.grpc.ServerBuilder;

public class Coordinator extends CoordinatorGrpc.CoordinatorImplBase {

  private static Logger LOGGER;


  /**
   * Log setup method initializes the logging setup in the class.
   */
  public static void logSetup() {
    LOGGER = Logger.getLogger(Coordinator.class.getName());
    SimpleFormatter simpleFormatter = new SimpleFormatter();
    FileHandler fileHandler;
    try {
      fileHandler = new FileHandler("Coordinator.log");
      fileHandler.setFormatter(simpleFormatter);

      LOGGER.addHandler(fileHandler);
    } catch (IOException e) {
      e.printStackTrace();
    }
    LOGGER.setLevel(Level.ALL);
  }


  public static void main(String[] args) throws IOException, InterruptedException {
    try {
      logSetup();

      // Server object initialization
      io.grpc.Server coordinator = ServerBuilder.forPort(50010)
              .addService(new CoordinatorImpl())
              .executor(Executors.newFixedThreadPool(16)).build();

      coordinator.start();
      LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId()
              + " Coordinator has been started on port: " + coordinator.getPort());

      CoordinatorImpl.logSetup();

      // Await termination
      coordinator.awaitTermination();
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, e.getMessage());
    }
  }


}
