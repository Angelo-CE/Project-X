import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
* Clase inServer, esta ejecuta el Sockect principal.
* Contiene el metodo Main
*
 */

public class inServer extends IOException {
    // Se crea el puerto del Socket servidor
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
        String Name =JOptionPane.showInputDialog("Introduzca el IP de usuario");
        inServer func = new inServer();
        System.out.println("Connection Established");
        Scanner scanner = new Scanner(System.in);

        while(true) {
            func.connectss();
            func.connects();
            String msg = scanner.nextLine();
            func.out.writeUTF("["+Name+"]" + msg);
            String entrance = func.in.readUTF();
            System.out.println(entrance);

        }
    }
}

    /*
    * Clase Mserver, Esta contiene la configuracion de la interface
    * Ademas de Construirla
    * Ningun Parametro
     */
class MServer extends JFrame{
        public MServer() {
            setBounds(600, 600, 600, 600);
            LServer SE = new LServer();
            add(SE);
            setVisible(true);
            }
        }

        /*
        *  Clase Lserver, Esta contiene los campos de Texto y el boton
        * Ademas su constructor
        *
         */

        class LServer extends JPanel {
            public double Calc;
            public static JTextField Scamp1;
            public static JTextField Scamp2;
            public static JTextField Scamp3;
            public static JButton Sboton;
            public LServer() {

                JLabel text = new JLabel("Introduzca los valores en orden de: Producto, Porcentaje y Peso");
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
            /*
            * Clase Fserver, esta es un Accionador, contiene el metodo
            * que hace el calculo (No funciona, solo en consola)
             */
            private class FServer implements ActionListener{

                /*
                * Metodo actionPerformed, recoje lo escrito en el campo de texto
                * lo convierte de String a en entero, realiza el calculo y despues lo vuelve
                *  a convertir en String para realizar el print.
                * Dato: No se muestra en interface
                 */

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
        }
