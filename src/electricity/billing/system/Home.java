package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {
    Home () {
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/img/ebs.png"));
        Image img1 = img.getImage().getScaledInstance(1430, 730, Image.SCALE_DEFAULT);
        ImageIcon imgIcon = new ImageIcon(img1);
        JLabel home = new JLabel(imgIcon);
        add(home);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // menu tab
        JMenu menu = createMenu("Menu");
        menuBar.add(menu);

        JMenuItem newCustomer = createMenuItem("New Customer", "newcustomer.png");
        menu.add(newCustomer);

        JMenuItem customerDetails = createMenuItem("Customer Details", "customerDetails.png");
        menu.add(customerDetails);

        JMenuItem depositDetails = createMenuItem("Deposit Details", "depositDetails.png");
        menu.add(depositDetails);

        JMenuItem calculateBills = createMenuItem("Calculate Bills", "calculateBills.png");
        menu.add(calculateBills);

        // user information tab
        JMenu info = createMenu("Info");
        menuBar.add(info);

        info.add(createMenuItem("Update Information", "refresh.png"));

        JMenuItem viewInfo = createMenuItem("View Information", "information.png");
        info.add(viewInfo);

        // user tab
        JMenu user = createMenu("User");
        menuBar.add(user);

        JMenuItem payBill = createMenuItem("Pay Bill", "pay.png");
        user.add(payBill);

        JMenuItem billDetails= createMenuItem("Bill Details", "detail.png");
        user.add(billDetails);

        // bill tab
        JMenu bill = createMenu("Bill");
        menuBar.add(bill);

        JMenuItem genBill = createMenuItem("Generate Bill", "bill.png");
        bill.add(genBill);

        // utility tab
        JMenu utility = createMenu("Utility");
        menuBar.add(utility);

        JMenuItem notepad = createMenuItem("Notepad", "notepad.png");
        utility.add(notepad);

        JMenuItem calculator = createMenuItem("Calculator", "calculator.png");
        calculator.setBackground(Color.CYAN);
        utility.add(calculator);

        // exit tab
        JMenu exit = createMenu("Exit");
        menuBar.add(exit);

        JMenuItem exitItem = createMenuItem("Exit", "exit.png");
        exit.add(exitItem);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new FlowLayout());
        setVisible(true);
    }

    private JMenu createMenu(String name) {
        JMenu menu = new JMenu(name);
        menu.setFont(new Font("serif", Font.BOLD, 17));
        return menu;
    }

    private JMenuItem createMenuItem(String menuItemTitle, String iconPath) {
        JMenuItem menuItem = new JMenuItem(menuItemTitle);
        menuItem.setFont(new Font("monospaced", Font.PLAIN, 15));
        ImageIcon menuItemImgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/img/" + iconPath));
        Image menuItemImg = menuItemImgIcon.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
        menuItem.setIcon(new ImageIcon(menuItemImg));
        return menuItem;
    }

    public static void main(String[] args) {
        new Home();
    }
}
