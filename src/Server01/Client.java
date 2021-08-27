package Server01;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        String IP =JOptionPane.showInputDialog("Introduzca el IP de usuario");
        Socket s= new Socket("LocalHost",8001);
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        out.writeUTF("Esperando Conexion");
        DataInputStream in = new DataInputStream(s.getInputStream());
        boolean flag = true;

        while(true) {
            int nm1 = Integer.parseInt(JOptionPane.showInputDialog("Valor de Producto: "));
            int nm2 = Integer.parseInt(JOptionPane.showInputDialog("Porcentaje : "));
            int nm3 = Integer.parseInt(JOptionPane.showInputDialog(" Peso del Producto: "));
            flag = true;

            /*
            if (nm1 == Integer.parseInt(null)){
                s.close();
            } else if(nm2 == Integer.parseInt(null)){
                s.close();

            }else if (nm3 == Integer.parseInt(null)){
                s.close();
            }*/

            try {
                while (flag) {

                    double nm4;
                    nm4 = (nm1 * nm2 / 100) + (nm3 * 0.15);
                    out.writeUTF(String.valueOf(nm4));
                    System.out.println(nm4);
                    flag = false;
                    //double result = JOptionPane.showInputDialog(,num4);


                }

            } catch (Exception e) {
                flag = false;
                e.printStackTrace();
                s.close();
            }


        }

    }
}
