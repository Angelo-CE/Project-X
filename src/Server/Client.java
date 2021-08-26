package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) throws Exception {

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Username:   and Port:  ");
        String[] setupValues = bReader.readLine().split(" ");
        ServerThread sThread = new ServerThread(setupValues[1]);

    }
}
