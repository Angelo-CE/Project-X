package Server0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Server extends Thread{

    public void _switch(boolean nameflag){
        if(nameflag)
            nameflag = false;
        else if(!nameflag){
            nameflag = true;
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket sserver = new ServerSocket(4001);
            System.out.println("Esperando Conexion");
            Socket s = sserver.accept();
            Scanner scanner = new Scanner(System.in);

            DataInputStream dIn = new DataInputStream(s.getInputStream());
            DataOutputStream dOut = new DataOutputStream(s.getOutputStream());
            //boolean flag = true;
            boolean flag = true;

            boolean flag1 = true;
            while (flag1) {
                String user = dIn.readUTF();
                System.out.println("User1: " + user);
                if (user.equals("exit")) {
                    System.out.println("Exit !!!");
                    dIn.close();
                    dOut.close();
                    sserver.close();
                    s.close();
                    //System.exit(0);
                }
                System.out.println("Enter message: ");
                String Sms = scanner.next();
                dOut.writeUTF(Sms);
                //System.out.println("User0: " + Sms);
                if (user.equals("exit")) {
                    System.out.println("Exit !!!");
                    dIn.close();
                    dOut.close();
                    sserver.close();
                    s.close();
                    System.exit(0);
                    }
                }
            
        } catch (UnknownHostException e) {
            boolean flag1 = false;
            //Cath Block
            //Cath Block

        } catch (IOException e) {
            boolean flag = false;
            //Catch Block
            //boolean flag = false;
        }


    }


}
