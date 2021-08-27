import javax.swing.*;


public class inClient {
    public static void main(String[] args) {
        Mclient marco = new Mclient();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    public Lclient(){
        JLabel text = new JLabel("User1");
        add(text);
        Ccamp1 = new JTextField(20);
        add(Ccamp1);
        Ccamp2 = new JTextField(20);
        add(Ccamp2);
        Ccamp3 = new JTextField(20);
        add(Ccamp3);
        Cboton = new JButton("Calc");
        add(Cboton);



    }

    private JTextField Ccamp1;
    private JTextField Ccamp2;
    private JTextField Ccamp3;
    private JButton Cboton;
}