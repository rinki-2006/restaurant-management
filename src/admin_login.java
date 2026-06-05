import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin_login extends JFrame implements ActionListener {
    JLabel l1, l2;
    JButton b1, b2, b3, b4;
    JPanel p1,p2;
    admin_login(){
        super("Admin section");
        Font f = new Font("Arial", Font.BOLD, 15);
        Font f1 = new Font("Arial", Font.BOLD, 20);
        l1 = new JLabel("Admin Section");
        l1.setHorizontalAlignment(JLabel.CENTER);
        p1 = new JPanel();
        p1.setFont(f1);
        p1.add(l1);

        b1 = new JButton("Add Employee");
        b2 = new JButton("Edit Employee");
        b3 = new JButton("Delete Employee");
        b4 = new JButton("Logout");
        p2 = new JPanel();
        p2.setLayout(new GridLayout(4, 1, 10,10));
        p2.setFont(f);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);

        ImageIcon i = new ImageIcon("C:\\Users\\HP\\Downloads\\adminlogin.png");
        Image i1 = i.getImage().getScaledInstance(130,100, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i1);
        l2 = new JLabel(i2);

        setLayout(new BorderLayout(10,10));
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.WEST);
        add(l2, BorderLayout.CENTER);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            add_employee ae = new add_employee();
            ae.setSize(700,400);
            ae.setVisible(true);
            dispose();
        }
        else{
            Edit_employee e1 = new Edit_employee();
            e1.setSize(700, 500);
            e1.setVisible(true);
            dispose();
        }
    }
    public static void main(String[] args) {
        admin_login a = new admin_login();
        a.setSize(500,250);
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
