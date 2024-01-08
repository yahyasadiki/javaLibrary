package swing;

import swing.Emprunts.MenuEmprunts;
import swing.Livre.MenuLivre;
import swing.Utilisateur.MenuUtilisateur;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    private JButton livre;
    private JButton utilisateur;
    private JButton emprunt;


    public Menu() {
        initComponents();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        } catch (Exception e) {
            e.printStackTrace();
        }
        Menu menu = new Menu();
        menu.setVisible(true);

    }

    public void initComponents() {
        setTitle("Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);

        livre = new JButton("Livre");
        utilisateur = new JButton("Utilisateur");
        emprunt = new JButton("Emprunt");

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 1));
        p1.add(livre);
        p1.add(utilisateur);
        p1.add(emprunt);
        p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(p1, BorderLayout.CENTER);

        livre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLivre ml = new MenuLivre();
                ml.setVisible(true);
            }
        });

        emprunt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEmprunts me = new MenuEmprunts();
                me.setVisible(true);
            }
        });

        utilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUtilisateur mu = new MenuUtilisateur();
                mu.setVisible(true);
            }
        });


    }
}
