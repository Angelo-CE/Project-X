package Server0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Client {
    private Scanner scanner;

    public String getUsername() {
        System.out.print("Enter your username: ");
        return scanner.nextLine(); }


    public static void main(String[] args) {
        try {

            Socket sClient = new Socket("LocalHost", 4001);
            System.out.println("Connected");
            Scanner scanner = new Scanner(System.in);

            DataInputStream dIn = new DataInputStream(sClient.getInputStream());
            DataOutputStream dOut = new DataOutputStream(sClient.getOutputStream());


            //System.out.println("Enter Name user: ");
            //String n = scanner.nextLine();

            while (true) {
                System.out.println("Enter message: ");
                String Cms = scanner.nextLine();
                dOut.writeUTF(Cms);


                if (Cms.equals("exit")) {
                    System.out.println("Exit !!!");
                    dIn.close();
                    dOut.close();
                    sClient.close();
                    scanner.close();
                    //System.exit(0);
                }
                String Sms = dIn.readUTF();
                System.out.println("User0: "+ Sms);
                if (Sms.equals("exit")) {
                    System.out.println("Exit !!!");
                    dIn.close();
                    dOut.close();
                    scanner.close();
                    sClient.close();
                    System.exit(0);
                }
            }
        } catch (UnknownHostException e) {
            //Cath Block
            //Cath Block
        } catch (IOException e) {
            //Catch Block
        }
    }
}