package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class Signup extends JFrame implements ActionListener {

    Choice createAccountAsChoice;
    JTextField userNameText, passwordText, nameText, meterNoText, empolyerIdText;
    JButton signUpButton, logInButton;

    Signup() {
        super("Sign Up");
        //getContentPane().setBackground(Color.BLACK);
        JLabel createAccountAsLabel = new JLabel("Create Account As");
        createAccountAsLabel.setBounds(30, 40,125, 20);
        add(createAccountAsLabel);

        createAccountAsChoice = new Choice();
        createAccountAsChoice.add("Admin");
        createAccountAsChoice.add("Customer");
        createAccountAsChoice.setBounds(165, 40, 150, 20);
        add(createAccountAsChoice);

        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(30, 80, 125,20);
        meterNo.setVisible(false);
        add(meterNo);

        meterNoText = new JTextField();
        meterNoText.setBounds(165, 80, 150, 20);
        meterNoText.setVisible(false);
        add(meterNoText);

        JLabel employerId = new JLabel("Employer Id");
        employerId.setBounds(30, 80, 125,20);
        employerId.setVisible(true);
        add(employerId);

        empolyerIdText = new JTextField();
        empolyerIdText.setBounds(165, 80, 150, 20);
        empolyerIdText.setVisible(true);
        add(empolyerIdText);

        JLabel username = new JLabel("Username");
        username.setBounds(30, 120, 125, 20);
        add(username);

        userNameText = new JTextField();
        userNameText.setBounds(165, 120, 150, 20);
        add(userNameText);

        JLabel name = new JLabel("Name");
        name.setBounds(30, 160, 125, 20);
        add(name);

        nameText = new JTextField();
        nameText.setBounds(165, 160, 150, 20);
        add(nameText);

        JLabel password = new JLabel("Password");
        password.setBounds(30, 200, 125, 20);
        add(password);

        passwordText = new JTextField();
        passwordText.setBounds(165, 200, 150, 20);
        add(passwordText);

        createAccountAsChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = createAccountAsChoice.getSelectedItem();
                if(user.equals("Admin")) {
                    meterNo.setVisible(false);
                    meterNoText.setVisible(false);
                    employerId.setVisible(true);
                    empolyerIdText.setVisible(true);
                }else{
                    meterNo.setVisible(true);
                    meterNoText.setVisible(true);
                    employerId.setVisible(false);
                    empolyerIdText.setVisible(false);
                }
            }
        });

        ImageIcon signUpIcon = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image signUpImg = signUpIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon signUpImgIcon = new ImageIcon(signUpImg);
        JLabel signUpImgLabel = new JLabel(signUpImgIcon);
        signUpImgLabel.setBounds(340, 20, 250, 250);
        add(signUpImgLabel);

        signUpButton = new JButton("Create");
        signUpButton.setBounds(60, 240, 100, 20);
        signUpButton.setBackground(new Color(163, 120, 203));
        signUpButton.addActionListener(this);
        add(signUpButton);

        logInButton = new JButton("Back");
        logInButton.setBackground(Color.BLACK);
        logInButton.setBounds(200, 240, 100, 20);
        logInButton.addActionListener(this);

        add(logInButton);

        setSize(600, 380);
        setLocation(500, 250);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Signup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == signUpButton) {
            String loginChoice = createAccountAsChoice.getSelectedItem();
            String username = userNameText.getText();
            String name = nameText.getText();
            String password = passwordText.getText();

           // if(loginChoice.equals("Admin")) {
                String empId = empolyerIdText.getText();
           // }else {
                String meterNo = meterNoText.getText();
           // }

            try {
                Database d = new Database();

                String query = "insert into signup value( '" + meterNo + "', '" + username + "', '" + name + "', '" + password + "', '" + loginChoice + "' )";
                d.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "account created successfully");
                setVisible(false);
                new Login();
            }catch(SQLException exception) {
                exception.printStackTrace();
            }

        } else if (e.getSource() == logInButton) {
            setVisible(false);
            new Login();
        }
    }
}
