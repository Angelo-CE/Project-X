package Server;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8000);
            System.out.println("Wait for connection : ");
            Socket s = ss.accept();
            Scanner scanner = new Scanner(System.in);

            DataInputStream _In = new DataInputStream(s.getInputStream());
            DataOutputStream _Out = new DataOutputStream(s.getOutputStream());
            while(true){
                String cmsg =   _In.readUTF();
                System.out.println("Client : "+ cmsg);
                if(cmsg.equals("Exit")){
                    System.out.println("Quit !! ");
                    _In.close();
                    _Out.close();
                    scanner.close();
                    s.close();
                    ss.close();
                    System.exit(0);
                }
            }


        }
    }
}
