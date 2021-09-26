package Server;

import com.example.KeyValueStoreImpl;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import io.grpc.*;

/**
 * The Server class is responsible for starting the server at a particular port.
 */
public class Server {

  private static Logger LOGGER;

  /**
   * Log setup method initializes the logging setup in the class.
   */
  public static void logSetup(String serverName) {
    LOGGER = Logger.getLogger(serverName);
    SimpleFormatter simpleFormatter = new SimpleFormatter();
    FileHandler fileHandler;
    try {
      fileHandler = new FileHandler(serverName + ".log");
      fileHandler.setFormatter(simpleFormatter);

      LOGGER.addHandler(fileHandler);
    } catch (IOException e) {
      e.printStackTrace();
    }
    LOGGER.setLevel(Level.ALL);
  }

  /**
   * The entry point for starting a server.
   *
   * @param args the input arguments
   * @throws IOException          the io exception
   * @throws InterruptedException the interrupted exception
   */
  public static void main(String[] args) throws IOException, InterruptedException {

    try {
      if (args[0].equals("")) {
        throw new IllegalArgumentException("enter the server port");
      }

      String portNumber = args[0].split("\\|")[0];
      String serverName = args[0].split("\\|")[1];

      // Log initialization
      logSetup(serverName);

      // Server object initialization
      io.grpc.Server server = ServerBuilder.forPort(Integer.parseInt(portNumber))
              .addService(new KeyValueStoreImpl()).addService(new ServerCoordinatorImpl())
              .executor(Executors.newFixedThreadPool(16)).build();

      server.start();
      LOGGER.log(Level.INFO, "Thread ID: " + Thread.currentThread().getId() +
              "Server has been started on port: " + server.getPort() + "-" + serverName);

      // Initialising the service logs
      KeyValueStoreImpl.logSetup(serverName, portNumber);
      ServerCoordinatorImpl.logSetup(serverName);


      String initResponse = KeyValueStoreImpl.coordinatorInitiation();
      LOGGER.log(Level.INFO, initResponse);

      // Await termination
      server.awaitTermination();
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, e.getMessage());
    }
  }
}
