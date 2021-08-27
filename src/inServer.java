import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class inServer {
    public static void main(String[] args) {
        MServer marco1 = new MServer();
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                sendtext calc = new sendtext();
                Sboton.addActionListener(calc);
                add(Sboton);
            }
            private class sendtext implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println(Scamp1.getText());
                }
            }

            private JTextField Scamp1;
            private JTextField Scamp2;
            private JTextField Scamp3;
            private JButton Sboton;
        }
