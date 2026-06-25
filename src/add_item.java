import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class add_item extends JFrame implements ActionListener, ItemListener {
    Font f1, f2;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JButton b1, b2;
    JTextField t1, t2, t3, t4;
    JComboBox<String> cb, cb1;
    Database d;
    add_item(){
        f1 = new Font("Times New Roman", Font.BOLD, 20);
        f2 = new Font("Times New Roman", Font.BOLD, 15);

        l1 = new JLabel("Add Item");
        l1.setFont(f1);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l2 = new JLabel("Item ID");
        l2.setFont(f2);
        l3 = new JLabel("Item source");
        l3.setFont(f2);
        l4 = new JLabel("Item Name");
        l4.setFont(f2);
        l5 = new JLabel("Employee Username");
        l5.setFont(f2);
        l6 = new JLabel("Employees Name");
        l6.setFont(f2);
        l7 = new JLabel("Price");
        l7.setFont(f2);

        t1 = new JTextField(25);
        t2 = new JTextField(25);
        t3 = new JTextField(25);
        t4 = new JTextField(25);

        cb = new JComboBox<>();
        cb1 = new JComboBox<>();

        b1 = new JButton("Add Item");
        b1.setFont(f2);
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.yellow);
        b2 = new JButton("Cancel");
        b2.setFont(f2);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.RED);

        ImageIcon i = new ImageIcon("C:\\Users\\HP\\Downloads\\add_image.png");
        Image i1 = i.getImage().getScaledInstance(400,600, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i1);
        l8 = new JLabel(i2);

        Panel p = new Panel();
        p.setLayout(new GridLayout(7, 2, 40,20));
        p.add(l2);
        p.add(t1);
        p.add(l3);
        p.add(cb);
        p.add(l4);
        p.add(t2);
        p.add(l5);
        p.add(cb1);
        p.add(l6);
        p.add(t3);
        p.add(l7);
        p.add(t4);
        p.add(b1);
        p.add(b2);

        setLayout(new BorderLayout(10,10));
        add(l1, BorderLayout.NORTH);
        add(p, BorderLayout.EAST);
        add(l8, BorderLayout.WEST);

        b1.addActionListener(this);

        b2.addActionListener(this);
        cb1.addItemListener(this);
try {
    d = new Database();
    String query = "Select * From add_item";
    ResultSet rs = d.stm.executeQuery(query);
    while(rs.next()){
        cb.addItem(rs.getString("item_source"));
        cb1.addItem(rs.getString("employees_username"));
    }
} catch (SQLException e) {
    System.out.println(e);
}
    }
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
            try {
                String username = cb1.getSelectedItem().toString();
                String query = "Select employees_name from add_item Where employees_username = '" + username + "'";
                ResultSet rs = d.stm.executeQuery(query);
                if (rs.next()) {
                    t3.setText(rs.getString("employees_name"));
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b2){
            home_page h = new home_page();
            h.setVisible(true);
            h.setSize(900,900);
            dispose();
        }
        else{
            try{
                String item_id = t1.getText();
                String item_source = cb.getSelectedItem().toString();
                String item_name = t2.getText();
                String emp_username = cb1.getSelectedItem().toString();
                String emp_name = t3.getText();
                Double price = Double.parseDouble(t4.getText());

                String query = "INSERT INTO add_item(item_id, item_source, item_name, employees_username ,employees_name, Price)" +
                        "Values(" + item_id + ", '" + item_source + "','" + item_name + "', '" +emp_username + "' , '" + emp_name + "', " + price + ")";
                d.stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Item Added Succesfull");

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }


    }
    public static void main(String[] args) {
    add_item a = new add_item();
    a.setSize(950,600);
    a.setVisible(true);
    a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
