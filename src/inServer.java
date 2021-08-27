import javax.swing.*;

public class inServer {
    public static void main(String[] args) {
        MServer marco1 = new MServer();
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}



class MServer extends JFrame{
        public MServer() {
            setBounds(300, 400, 300, 400);
            Lclient CL = new Lclient();
            add(CL);
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
                add(Sboton);

            }

            private JTextField Scamp1;
            private JTextField Scamp2;
            private JTextField Scamp3;
            private JButton Sboton;
        }
