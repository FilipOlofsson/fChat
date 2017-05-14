package Server;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ClientHandler {

    static List<Client> clientList = new LinkedList<>();

    public static void addClient(Socket socket) throws InterruptedException {
        try {
            Client newClient = new Client(socket);
            newClient.start();
            clientList.add(newClient);
        } catch (IOException e) {
            addClient(socket);
        }

    }

    public static Client findClient(int ID) {
        for(Client i : clientList) {
            if(i.ID == ID) {
                return i;
            }
        }
        return null;
    }

}
