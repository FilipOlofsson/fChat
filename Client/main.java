package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class main {

    static DataInputStream dataInputStream;
    static DataOutputStream dataOutputStream;

    public static void main(String args[]) throws InterruptedException {
        try {
            Socket socket = new Socket("localhost", 59159);
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());
            Klass klass = new Klass();
            klass.start();
            System.out.println("Listening...");
            while(true) {
                dataOutputStream.writeUTF(new Scanner(System.in).nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Thread.sleep(5000);
            main(null);
        }

    }
}
class Klass extends Thread {
    public void run() {
        while(true) {
            try {
                System.out.println(main.dataInputStream.readUTF());
            } catch (IOException e) {
                System.exit(-1);
            }
        }
    }
}