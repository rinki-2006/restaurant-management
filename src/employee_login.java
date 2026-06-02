import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class employee_login extends JFrame implements ActionListener {
    JLabel l1,l2, l3;
    JButton b1, b2;
    JTextField tf, tf1;
    JPanel p1;
    employee_login(){
        Font f = new Font("Arial", Font.BOLD, 20);
        Font f1 = new Font("Arial", Font.BOLD, 15);
        l1 = new JLabel("Login Account");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f);
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 20, 20));
        p1.add(l1);

        l2 = new JLabel("Username : ");
        l2.setHorizontalAlignment(JLabel.RIGHT);
        l2.setFont(f1);
        l3 = new JLabel("Password : ");
        l3.setHorizontalAlignment(JLabel.RIGHT);
        l3.setFont(f1);

        tf = new JTextField(15);
        tf1 = new JTextField(15);
        b1 = new JButton("Login");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setFont(f1);
        b2 = new JButton("Back");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.RED);
        b2.setFont(f1);

        ImageIcon i = new ImageIcon("C:\\Users\\HP\\Downloads\\emplyee.png");
        Image i1 = i.getImage().getScaledInstance(500,250,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel background = new JLabel(i2);
        background.setLayout(new GridLayout(3,2,10,10));

        background.add(l2);
        background.add(tf);
        background.add(l3);
        background.add(tf1);
        background.add(b1);
        background.add(b2);

        setLayout(new BorderLayout(10,10));
        add(p1, BorderLayout.NORTH);
        add(background, BorderLayout.CENTER);

        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){

        indexpage index = new indexpage();
        index.setSize(500,500);
        index.setVisible(true);
    }
    public static void main(String[] args) {
        employee_login e = new employee_login();
        e.setSize(500,250);
        e.setVisible(true);
        e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
