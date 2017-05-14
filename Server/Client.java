package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.InputMismatchException;

public class Client extends Thread {

    public int ID;

    Socket socket;

    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    public Client(Socket socket) throws IOException {
        this.socket = socket;
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        while(true) {
            try {
                String[] whole = dataInputStream.readUTF().split("@");
                if(whole[0].charAt(0) == 'n') {
                    this.ID = Integer.parseInt(whole[1]);
                    send("Your ID has been set to "+whole[1]);
                } else {
                    try {
                        ClientHandler.findClient(Integer.parseInt(whole[0])).send(whole[1]);
                        System.out.println("Sent "+whole[1]+" to ID "+whole[0]);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void send(String Message) throws IOException {
        dataOutputStream.writeUTF(Message);
    }

}
