import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class delete_employees extends JFrame implements ActionListener {
    JLabel l1, l2;
    JButton b1, b2;
    JTextField tf;
    JTable table;
    JScrollPane sp;
    Database d;

    delete_employees(){
        super("Delete employees");
        l1 = new JLabel("Delete any employees");
        l1.setBounds(300,20,300,30);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        add(l1);

        table = new JTable();
        sp = new JScrollPane(table);
        sp.setBounds(50,70,850,300);
        add(sp);

        l2 = new JLabel("Employees ID");
        l2.setBounds(220,420,100,30);
        l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(l2);

        tf = new JTextField();
        tf.setBounds(360,420,200,30);
        add(tf);

        b1 = new JButton("Delete employees");
        b1.setBounds(250,500,150,35);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(480,500 ,100, 35);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        // load database data to JTable
        loadData();
        setLayout(null);
    }
    public void loadData(){
        d= new Database();
        try {
            ResultSet rs = d.stm.executeQuery("select * from restaurant");
            DefaultTableModel model = new DefaultTableModel();
            // column names
            model.addColumn("Username");
            model.addColumn("Age");
            model.addColumn("Gender");
            model.addColumn("Name");
            model.addColumn("Password");
            model.addColumn("Aadhar");

            while(rs.next()){
                model.addRow(new Object[]{
                        rs.getString("username"),
                        rs.getString("age"),
                        rs.getString("gender"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("aadhar")

                });
            }
            table.setModel(model);
        } catch (SQLException e) {}
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            String id = tf.getText();
            String query = "Delete from restaurant where username = ?";
            try {
                PreparedStatement ps = d.con.prepareStatement(query);
                ps.setString(1, id);
                int x = ps.executeUpdate();
                if(x>0){
                    JOptionPane.showMessageDialog(null, "Employee deleted successfully");
                    loadData(); // table refresh
                }
                else{
                    JOptionPane.showMessageDialog(null, "Employees not found");
                }
            } catch (SQLException ex) {}
        }
        else{
            admin_login a= new admin_login();
            a.setVisible(true);
            a.setSize(500,250);
            dispose();
        }
    }
    public static void main(String[] args) {
        delete_employees d = new delete_employees();
        d.setVisible(true);
        d.setSize(950,600);
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
