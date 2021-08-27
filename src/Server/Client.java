/*
package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
   // public static void main(String[] args) throws Exception {

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Username:   and Port:  ");
        String[] setupValues = bReader.readLine().split(" ");
        ServerThread sThread = new ServerThread(setupValues[1]);
        sThread.start();
        new Client().updateListenToClients(bReader,setupValues[0],sThread);
    }
    public void updateListenToClients(BufferedReader bReader, String username,  ServerThread sThread) throws Exception{
        System.out.println(" Enter (   )  Host: port#");
        System.out.println("Clients to Receive mesagges from (s to skip)");
        String input = bReader.readLine();
        String[] inputValues = input.split(" ");
        if (!input.equalsIgnoreCase("s")) for (int i = 0; i < inputValues.length; i++){
            String[] address = inputValues[i].split(":");
            Socket socket = null;
            try{
                socket = new Socket(address[0],Integer.parseInt(address[1]));
                new ClientThread(socket).start();
            }catch (Exception e){
                if(socket != null) socket.close();
                else System.out.println("Invalid input. Skip to next");
            }
        }
        communicate(bReader, username, sThread);
    }
    public void communicate (BufferedReader bReader, String username,ServerThread sThread ) throws Exception {
        boolean flag = true;
        while (flag){
            String message = bReader.readLine();
            if (message.equals("e")){
               flag = false;
               break;
            } else if (message.equals("c")){
                updateListenToClients(bReader, username, sThread);
            } else {
                StringWriter stringWriter = new StringWriter();
                Scanner scanner = new Scanner((Readable) stringWriter);
            }


        }
    }
}

*/