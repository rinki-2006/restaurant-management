import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class indexpage extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4;
    JButton b1, b2;
    JPanel p1, p2, p3;
    Font f, f1;
    indexpage(){
        super("Index page");
        f = new Font("Arial", Font.BOLD, 15);
        f1 = new Font("Arial", Font.BOLD, 20);

        l1= new JLabel("Restaurant Management");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);
        l2 = new JLabel("Admin Login");
        l2.setFont(f);
        l3 = new JLabel("Employee login");
        l3.setFont(f);

        b1 = new JButton("Login");
        b1.setFont(f);
        b1.setForeground(Color.white);
        b1.setBackground(Color.BLACK);
        b2 = new JButton("login");
        b2.setFont(f);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.RED);

        ImageIcon i = new ImageIcon("C:\\Users\\HP\\Downloads\\login.png");
        Image i1 = i.getImage().getScaledInstance(130,100,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(i1);
        l4 = new JLabel(icon);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.add(l4);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(2,2,10,10));
        p3.add(l2);
        p3.add(b1);
        p3.add(l3);
        p3.add(b2);

      setLayout(new BorderLayout(10,10));
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.WEST);
        add(p3, BorderLayout.CENTER);

        b1.addActionListener(this);
        b2.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            System.out.println("admin login");
        }
        else{
           employee_login emp = new employee_login();
           emp.setSize(500,250);
           emp.setVisible(true);

           dispose();
        }
    }

    public static void main(String[] args) {
        indexpage i = new indexpage();
        i.setSize(500,500);
        i.setVisible(true);
        i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
