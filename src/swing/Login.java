package swing;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private JLabel jLabel1;
    private JTextField username;
    private JTextField password;
    private JButton login;
    private JButton cancel;

    public Login() {
        initComponents();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Login().setVisible(true);
    }

    private void initComponents() {
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);

        username = new JTextField();
        password = new JTextField();
        jLabel1 = new JLabel("Login Form");

        JPanel p1 = new JPanel();
        p1.add(jLabel1);
        this.add(p1, BorderLayout.NORTH);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2, 2));
        p2.add(new JLabel("Username"));
        p2.add(username);
        p2.add(new JLabel("Password"));
        p2.add(password);
        p2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(p2, BorderLayout.CENTER);

        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        login = new JButton("Login");
        cancel = new JButton("Cancel");
        p3.add(login);

        login.addActionListener(e -> {
            String user = username.getText();
            String pass = password.getText();
            if (user.equals("admin") && pass.equals("admin")) {
                JOptionPane.showMessageDialog(null, "Login success");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Login failed");
            }
        });

        cancel.addActionListener(e -> {
            System.exit(0);
        });

        p3.add(cancel);
        this.add(p3, BorderLayout.SOUTH);


    }

}
