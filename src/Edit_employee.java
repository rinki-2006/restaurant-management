import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Edit_employee extends JFrame implements ItemListener, ActionListener {
    Font f, f1;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField t2, t3, t4, t5, t6;
    JButton b1, b2;
    JComboBox<String> cb;
    Edit_employee(){
        super("Edit employee");
        f = new Font("Arial", Font.BOLD, 15);
        f1 = new Font("Arial", Font.BOLD, 20);
        l1 = new JLabel("Update Employee");
        l1.setFont(f1);
        l1.setHorizontalAlignment(JLabel.CENTER);

        l2 = new JLabel("Username");
        l2.setFont(f);
        l3 = new JLabel("Name");
        l3.setFont(f);
        l4 = new JLabel("Age");
        l4.setFont(f);
        l5 = new JLabel("Gender");
        l5.setFont(f);
        l6 = new JLabel("Password");
        l6.setFont(f);
        l7 = new JLabel("Aadhar");
        l7.setFont(f);

        cb = new JComboBox<>();
        cb.setBounds(450,50,200,30);
        t2 = new JTextField(25);
        t3 = new JTextField(25);
        t4 = new JTextField(25);
        t5 = new JTextField(25);
        t6 = new JTextField(25);

        b1 = new JButton("Edit Data");
        b1.setFont(f);
        b1.setForeground(Color.white);
        b1.setBackground(Color.BLACK);
        b2 = new JButton("Back");
        b2.setFont(f);
        b2.setForeground(Color.white);
        b2.setBackground(Color.RED);

        ImageIcon i = new ImageIcon("C:\\Users\\HP\\Downloads\\edit_employee.png");
        Image i1 = i.getImage().getScaledInstance(200,500,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i1);
        l8 = new JLabel(i2);

        Panel p = new Panel();
        p.setLayout(new GridLayout(7, 2, 40,20));
        p.add(l2);
        p.add(cb);
        p.add(l3);
        p.add(t2);
        p.add(l4);
        p.add(t3);
        p.add(l5);
        p.add(t4);
        p.add(l6);
        p.add(t5);
        p.add(l7);
        p.add(t6);
        p.add(b1);
        p.add(b2);

        setLayout(new BorderLayout(10,10));
        add(l1, BorderLayout.NORTH);
        add(p, BorderLayout.EAST);
        add(l8, BorderLayout.WEST);
        cb.addItemListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);

        try{
            Database d =new Database();
            String q = "Select username from restaurant";
            Statement stm = d.con.createStatement();
            ResultSet rs = stm.executeQuery(q);
            while(rs.next()){
                cb.addItem(rs.getString("username"));
            }
        } catch (SQLException e) {}
    }
    public void itemStateChanged(ItemEvent e){
        try{
            Database d =new Database();
            String username = cb.getSelectedItem().toString();
            Statement stm = d.con.createStatement();
            String q2 = "Select * from restaurant where username = '"+ username + "'";
            ResultSet rs = stm.executeQuery(q2);
            if(rs.next()){
                t2.setText(rs.getString("name"));
                t3.setText(String.valueOf(rs.getInt("age")));
                t4.setText(rs.getString("gender"));
                t5.setText(rs.getString("password"));
                t6.setText(rs.getString("aadhar"));
            }
        } catch (Exception ex) {}
}
public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            Database d = new Database();
            try{
                String username = cb.getSelectedItem().toString();
                String name = t2.getText();
                int age = Integer.parseInt(t3.getText());
                String gender = t4.getText();
                String password = t5.getText();
                String aadhar = t6.getText();

                String query =
                        "update restaurant set " +
                                "name='" + name + "', " +
                                "age=" + age + ", " +
                                "gender='" + gender + "', " +
                                "password='" + password + "', " +
                                "aadhar='" + aadhar + "' " +
                                "where username='" + username + "'";

                d.stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee updated successfully");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else{
            admin_login a = new admin_login();
            a.setSize(500,250);
            a.setVisible(true);
            dispose();
        }
}
    public static void main(String[] args) {
        Edit_employee e = new Edit_employee();
        e.setVisible(true);
        e.setSize(700,500);
        e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
