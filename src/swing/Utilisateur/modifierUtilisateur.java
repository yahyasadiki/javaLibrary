package swing.Utilisateur;

import swing.mainTest;
import Class.utilisateur;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class modifierUtilisateur extends javax.swing.JFrame {
    private JButton Modifier;
    private JButton Annuler;
    private JComboBox nom;

    public modifierUtilisateur() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Modifier un utilisateur");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.add(new JLabel("Modifier un utilisateur"));
        this.add(p1, BorderLayout.NORTH);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2, 2));
        p2.add(new JLabel("Nom de l'utilisateur :"));
        JComboBox nom = new JComboBox();
        for (utilisateur user : mainTest.b1.getEmprunteurs()) {
            nom.addItem(user.getnom());
        }
        p2.add(nom);
        this.add(p2, BorderLayout.CENTER);

        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        Modifier = new JButton("Modifier");
        Annuler = new JButton("Annuler");
        p3.add(Modifier);
        p3.add(Annuler);
        this.add(p3, BorderLayout.SOUTH);


        this.setVisible(true);

        Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utilisateur user = mainTest.b1.getEmprunteurs().get(nom.getSelectedIndex());
                modifierUtilisateur2 modifierutilisateur2 = new modifierUtilisateur2(user);
                dispose();
            }
        });

        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        modifierUtilisateur modifierutilisateur = new modifierUtilisateur();
    }
}