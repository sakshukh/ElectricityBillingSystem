package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {

    JTextField userNameField;
    JPasswordField passwordField;
    Choice loginAsChoice;
    JButton login, cancel, signup;

    Login() {
        super("Login");
        //getContentPane().setBackground(Color.BLACK);

        JLabel username = new JLabel("UserName");
        username.setBounds(300, 60, 100, 20);
        add(username);

        userNameField = new JTextField();
        userNameField.setBounds(400, 60, 150, 20);
        add(userNameField);

        JLabel password = new JLabel("Password");
        password.setBounds(300, 100, 100, 20);
        add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(400, 100, 150, 20);
        add(passwordField);

        JLabel loggin = new JLabel("Log In As");
        loggin.setBounds(300, 140, 100, 20);
        add(loggin);

        loginAsChoice = new Choice();
        loginAsChoice.add("Admin");
        loginAsChoice.add("Customer");
        loginAsChoice.setBounds(400, 140, 150, 20);
        add(loginAsChoice);


        login = new JButton("Login");
        login.setBounds(320, 180, 100, 20);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 180, 100, 20);
        cancel.addActionListener(this);
        add(cancel);

        signup = new JButton("Signup");
        signup.setBounds(380, 220, 100, 20);
        signup.addActionListener(this);
        add(signup);

        ImageIcon profileIcon = new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image profileImage = profileIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon profile = new ImageIcon(profileImage);
        JLabel profileLabel = new JLabel(profile);
        profileLabel.setBounds(10, 10, 250, 250);
        add(profileLabel);


        setSize(640, 300);
        setLocation(300, 200);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login) {
            String username = userNameField.getText();
            String password = passwordField.getText();
            System.out.println("pass"+ password);
            String loggedInAs = loginAsChoice.getSelectedItem();

            try {
                Database d = new Database();
                String query = "select * from signup where user_name = '"+username+"' and password = '"+password+"' and user_type = '"+loggedInAs+"' ";
                ResultSet resultSet = d.statement.executeQuery(query);

                if(resultSet.next()) {
                   setVisible(false);
                   new Home();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password!!");
                }
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == signup) {
            setVisible(false);
            new Signup();
        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }
}
