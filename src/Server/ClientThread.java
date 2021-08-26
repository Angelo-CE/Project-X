package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread{
    private BufferedReader bReader;
    public ClientThread(Socket socket) throws IOException{
        bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
}
