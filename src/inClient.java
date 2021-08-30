import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class inClient extends IOException {

    public Socket s = new Socket("LocalHost",4001);
    public DataOutputStream out = new DataOutputStream(s.getOutputStream());;
    public   DataInputStream in = new DataInputStream(s.getInputStream());;

    public Socket connect(){
        return s;
    }

    public inClient() throws IOException {

    }

    public static void main(String[] args) throws IOException {
        Mclient marco = new Mclient();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inClient func = new inClient();
        String Name =JOptionPane.showInputDialog("Introduzca el IP de usuario");
        System.out.println("Connection Established");
        Scanner scanner = new Scanner(System.in);



        while(true){
            func.connect();
            String msg = scanner.nextLine();
            func.out.writeUTF("["+Name+"]"+msg);


            String entrance = func.in.readUTF();
            System.out.println(entrance);


        }

    }

   }

class Mclient extends JFrame{
    public Mclient(){
        setBounds(300,400,300,400);
        Lclient CL = new Lclient();
        add(CL);
        setVisible(true);

    }
}
 class Lclient extends JPanel{

    public static   JTextField Ccamp1;
    public static JTextField Ccamp2;
    public static JTextField Ccamp3;
    public static JButton Cboton;

    public Lclient(){
        JLabel text = new JLabel("Introduzca los valores en orden de: Producto, Porcentaje y Peso");
        add(text);
        Ccamp1 = new JTextField(10);
        add(Ccamp1);
        Ccamp2 = new JTextField(10);
        add(Ccamp2);
        Ccamp3 = new JTextField(10);
        add(Ccamp3);
        Cboton = new JButton("Calc");
       FClient cacl = new FClient();
        Cboton.addActionListener(cacl);
        add(Cboton);

    }
     class FClient implements ActionListener{




         @Override
         public void actionPerformed(ActionEvent actionEvent) {

             int n1 = Integer.parseInt( Lclient.Ccamp1.getText());
             int n2 = Integer.parseInt( Lclient.Ccamp2.getText());
             int n3 = Integer.parseInt( Lclient.Ccamp3.getText());
             Double calc = (n1*n2/100)+(n3*0.15);

             try {
                 inClient fuc = new inClient();
                 fuc.out.writeUTF(String.valueOf(calc));
                 System.out.println(calc);
             } catch (IOException e) {
                 System.out.println(":c");
                 e.printStackTrace();
             }




         }
     }


    }
