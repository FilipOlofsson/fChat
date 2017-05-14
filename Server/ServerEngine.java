package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerEngine {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(59159);
        while(true) {
            try {
                ClientHandler.addClient(serverSocket.accept());
                System.out.println("One Client Added.");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
