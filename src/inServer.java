import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class inServer extends IOException {

    ServerSocket ssocket = new ServerSocket(4001);
    Socket s = ssocket.accept();
    DataInputStream in = new DataInputStream(s.getInputStream());
    DataOutputStream out = new DataOutputStream(s.getOutputStream());

    public Socket connects(){
        return s;

    }
    public ServerSocket connectss(){
        return ssocket;
    }

    public inServer() throws IOException {
    }


    public static void main(String[] args) throws IOException {
        MServer marco1 = new MServer();
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inServer func = new inServer();
        System.out.println("Connection Established");
        Scanner scanner = new Scanner(System.in);






        while(true) {
            func.connects();
            func.connectss();


            String msg = scanner.nextLine();
            func.out.writeUTF("[User0]" + msg);

            String entrance = func.in.readUTF();
            System.out.println(entrance);

        }
    }
}



class MServer extends JFrame{
        public MServer() {
            setBounds(300, 400, 300, 400);
            LServer SE = new LServer();
            add(SE);
            setVisible(true);
            }
        }



        class LServer extends JPanel {
            public LServer() {

                JLabel text = new JLabel("User0");
                add(text);
                Scamp1 = new JTextField(20);
                add(Scamp1);
                Scamp2 = new JTextField(20);
                add(Scamp2);
                Scamp3 = new JTextField(20);
                add(Scamp3);
                Sboton = new JButton("Calc");
                FServer calc = new FServer();
                Sboton.addActionListener(calc);
                add(Sboton);
            }
            private class FServer implements ActionListener{


                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    int n1 = Integer.parseInt( LServer.Scamp1.getText());
                    int n2 = Integer.parseInt( LServer.Scamp2.getText());
                    int n3 = Integer.parseInt( LServer.Scamp3.getText());
                    Calc = (n1*n2/100)+(n3*0.15);

                    try {
                        inClient fuc = new inClient();
                        fuc.out.writeUTF(String.valueOf(Calc));
                        System.out.println(Calc);
                    } catch (IOException e) {
                        System.out.println(":c");
                        e.printStackTrace();
                    }
                }
            }
            public double Calc;
            public static JTextField Scamp1;
            public static JTextField Scamp2;
            public static JTextField Scamp3;
            public static JButton Sboton;
        }
