import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class add_employee extends JFrame implements ActionListener {
    private static final String url = "jdbc:postgresql://localhost:5432/mydb";
    private static final String username = "postgres";
    private static final String password = "Rinki12";
    JLabel l1,l2,l3,l4,l5,l6,l7, l8;
    JButton b1, b2;
    JTextField t1, t2, t3, t4, t5, t6;

    add_employee(){
        super("Add Employee");
        Font f = new Font("Arial", Font.BOLD, 15);
        Font f1 = new Font("Arial", Font.BOLD, 20);
        l1 = new JLabel("New Employee Details");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);


        l2 = new JLabel("Username");
        l3 = new JLabel("Age");
        l4 = new JLabel("Gender");
        l5 = new JLabel("Name");
        l6 = new JLabel("Password");
        l7 = new JLabel("Aadhar");

        t1 = new JTextField(15);
        t2 = new JTextField(15);
        t3 = new JTextField(15);
        t4 = new JTextField(15);
        t5 = new JTextField(15);
        t6 = new JTextField(15);

        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");


        ImageIcon i = new ImageIcon("C:\\Users\\HP\\Downloads\\add_employee.png");
        Image i2 = i.getImage().getScaledInstance(700,350,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        l8 = new JLabel(i3);
        l8.setLayout(null);

        l8.setFont(f);

        l1.setBounds(200,10,300,40);
        l2.setBounds(50,50,100,30);
        t1.setBounds(150,50,150,30);

        l3.setBounds(50,100,100,30);
        t2.setBounds(150,100,150,30);

        l4.setBounds(50,150,100,30);
        t3.setBounds(150,150,150,30);

        l5.setBounds(380,50,100,30);
        t4.setBounds(480,50,150,30);

        l6.setBounds(380,100,100,30);
        t5.setBounds(480,100,150,30);

        l7.setBounds(380,150,100,30);
        t6.setBounds(480,150,150,30);

        b1.setBounds(200,220,120,35);
        b2.setBounds(380,220,120,35);
        l8.add(l1);
        l8.add(l2);
        l8.add(t1);
        l8.add(l3);
        l8.add(t2);
        l8.add(l4);
        l8.add(t3);
        l8.add(l5);
        l8.add(t4);
        l8.add(l6);
        l8.add(t5);
        l8.add(l7);
        l8.add(t6);
        l8.add(b1);
        l8.add(b2);

        setLayout(new BorderLayout(20,20));
        add(l8, BorderLayout.CENTER);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            try{
                Database d = new Database();
                String query = "Insert Into restaurant(username, age, gender, name, password, aadhar) Values(?, ?, ?, ?, ?, ?)";

                PreparedStatement ps = d.con.prepareStatement(query);
                ps.setString(1, t1.getText());
                ps.setInt(2, Integer.parseInt(t2.getText()));
                ps.setString(3, t3.getText());
                ps.setString(4, t4.getText());
                ps.setString(5, t5.getText());
                ps.setString(6, t6.getText());

                int result = ps.executeUpdate();
                if(result>0){
                    JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                    ps.close();
                    d.con.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }
        }
    }
    public static void main(String[] args) {
        add_employee e = new add_employee();
        e.setVisible(true);
        e.setSize(700,400);
        e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
