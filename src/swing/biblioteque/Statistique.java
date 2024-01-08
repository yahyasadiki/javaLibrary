package swing.biblioteque;

import javax.swing.*;
import java.awt.*;

public class Statistique extends javax.swing.JFrame{
    //a frame with multiple tabs
    public Statistique(){
        initComponents();
    }

    public static void main(String[] args) {
        new Statistique();
    }

    public void initComponents() {
        this.setTitle("Statistique");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 2));
        p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        p1.add(new JLabel("Statistique Des Livres"));
        p1.add(new JLabel("Statistique Des Utilisateurs"));

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 2));

        this.add(p1, BorderLayout.NORTH);
    }
}
