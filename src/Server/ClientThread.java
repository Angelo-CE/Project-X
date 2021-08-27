/*
package Server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread extends Thread{
    private BufferedReader bReader;
    public ClientThread(Socket socket) throws IOException{
        bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }
    public void run(){
        DataInputStream dIn = new DataInputStream(sClient.getInputStream());
        DataOutputStream dOut = new DataOutputStream(sClient.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        boolean flag=true;
        while (flag){
            try{

                String msg = scanner.nextLine();

            }catch (Exception e){
                flag = false;
                interrupt();
            }
        }
    }
}
*/