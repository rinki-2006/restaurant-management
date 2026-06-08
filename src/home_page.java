import javax.swing.*;
import java.awt.*;

public class home_page extends JFrame {
    JMenu Menuitem, manageorder, bill, about;
    JMenuItem add, delete, create, update, cancel;
    JMenuBar mb;
    JLabel l1;
    home_page(){
        super("Restaurant Management Home Page");
        add = new JMenuItem("Add Item");
        delete = new JMenuItem("Delete Item");
        create = new JMenuItem("Create Item");
        update = new JMenuItem("Update Item");
        cancel = new JMenuItem("Cancel Item");

        Menuitem =new JMenu("Menu Item");
        Menuitem.add(add);
        Menuitem.add(delete);


        manageorder = new JMenu("Manage Order");
        manageorder.add(create);
        manageorder.add(update);
        manageorder.add(cancel);

        bill = new JMenu("Bill");
        about = new JMenu("About");

        mb = new JMenuBar();
        mb.add(Menuitem);
        mb.add(manageorder);
        mb.add(bill);
        mb.add(about);
        mb.setBackground(Color.BLACK);
        mb.setForeground(Color.yellow);

        setJMenuBar(mb);

        ImageIcon i = new ImageIcon("C:\\Users\\HP\\Downloads\\home_page.jpg");
        Image i1 = i.getImage().getScaledInstance(900,900,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i1);
        l1 = new JLabel(i2);
        add(l1);
        setLayout(new FlowLayout());

    }
    public static void main(String[] args) {
        home_page h = new home_page();
        h.setVisible(true);
        h.setSize(900,900);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
