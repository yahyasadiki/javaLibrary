package swing.Utilisateur;

import swing.mainTest;
import Class.utilisateur;
import javax.swing.*;
import java.util.ArrayList;

public class SupprimerUtilisateur extends javax.swing.JFrame {
    private JButton Supprimer;
    private JButton Annuler;
    private JComboBox nom;

    public SupprimerUtilisateur() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Modifier un utilisateur");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        JLabel label = new JLabel("Nom de l'utilisateur :");
        label.setBounds(50, 50, 300, 30);

        ArrayList<utilisateur> emprunteurs = mainTest.b1.getEmprunteurs();
        String[] nomEmprunteurs = new String[emprunteurs.size()];
        for (int i = 0; i < emprunteurs.size(); i++) {
            nomEmprunteurs[i] = emprunteurs.get(i).getnom();
        }
        nom = new JComboBox(nomEmprunteurs);
        nom.setBounds(50, 80, 300, 30);

        Supprimer = new JButton("Supprimer");
        Supprimer.setBounds(50, 120, 100, 30);

        Annuler = new JButton("Annuler");
        Annuler.setBounds(250, 120, 100, 30);

        this.add(label);
        this.add(nom);
        this.add(Supprimer);
        this.add(Annuler);

        this.setVisible(true);

        Supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utilisateur user = mainTest.b1.getEmprunteurs().get(nom.getSelectedIndex());
                mainTest.b1.getEmprunteurs().remove(user);
                nom.removeItemAt(nom.getSelectedIndex());
            }
        });

        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SupprimerUtilisateur fen = new SupprimerUtilisateur();
    }
}