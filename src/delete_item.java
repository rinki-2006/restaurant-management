import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class delete_item extends JFrame implements ActionListener {
    JLabel l1;
    JTextField tf;
    JButton b1, b2;
    JTable t1;
    Database d;
    Font f1, f2;
    JScrollPane sp;

    delete_item(){
        super("Delete item ");
        f1 = new Font("Times New Roman", Font.BOLD, 15);
        f2 = new Font("Times New Roman", Font.BOLD, 25);
        l1 = new JLabel("Delete any item");
        l1.setBounds(300,20,300,30);
        l1.setFont(f2);
        add(l1);

        t1 = new JTable();
        sp = new JScrollPane(t1);
        sp.setBounds(50,70,850,300);
        add(sp);

        tf = new JTextField(20);
        tf.setBounds(360,420,200,30);
        add(tf);

        b1 = new JButton("Delete item");
        b1.setForeground(Color.RED);
        b1.setBackground(Color.BLACK);
        b1.setBounds(250,500,150,35);
        b1.setFont(f1);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setForeground(Color.YELLOW);
        b2.setBackground(Color.BLACK);
        b2.setBounds(480,500 ,100, 35);
        b1.setFont(f1);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        loadData();
        setLayout(null);


    }
    public void loadData(){
        d = new Database();
        try{
            String query = "Select * From add_item";
            ResultSet rs = d.stm.executeQuery(query);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("item_id");
            model.addColumn("item_source");
            model.addColumn("item_name");
            model.addColumn("employees_username");
            model.addColumn("employees_name");
            model.addColumn("price");

            while(rs.next()){
                model.addRow(new Object[]{
                        rs.getString("item_id"),
                        rs.getString("item_source"),
                        rs.getString("item_name"),
                        rs.getString("employees_username"),
                        rs.getString("employees_name"),
                        rs.getDouble("price")
                });

            }
            t1.setModel(model);
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            int id = Integer.parseInt(tf.getText());
            String query = "Delete from add_item where item_id = ?";
            try{
                PreparedStatement ps = d.con.prepareStatement(query);
                ps.setInt(1, id);
                int x = ps.executeUpdate();
                if(x>0){
                    JOptionPane.showMessageDialog(null, "Delete successfully");
                    loadData();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not deleted");
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        else{
            home_page h = new home_page();
            h.setVisible(true);
            h.setSize(950,600);
            dispose();
        }
    }
    public static void main(String[] args) {
    delete_item d = new delete_item();
    d.setVisible(true);
    d.setSize(950,600);
    d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
