package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) throws Exception {

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
    }
}

