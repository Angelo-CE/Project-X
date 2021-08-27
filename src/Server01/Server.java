package Server01;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)  throws IOException {
        int port  = Integer.parseInt(JOptionPane.showInputDialog("Introduzca su puerto"));
        String IP = JOptionPane.showInputDialog("Introduzca tu IP de servidor");
        ServerSocket ssocket = new ServerSocket(8001);
        Socket s =  ssocket.accept();
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        out.writeUTF("I am fine, thank you");
        DataInputStream in = new DataInputStream(s.getInputStream());
        System.out.println(in.readUTF());
        boolean flag;
        while (true){
            flag = true;
            try {
                while(flag){
                    String mn4 = in.readUTF();
                    System.out.println(mn4);
                    flag = false;
                }
            } catch (Exception e) {
                flag = false;
                e.printStackTrace();
                s.close();
            }
        }
    }
}
