package swing.Utilisateur;

import javax.swing.*;

public class MenuUtilisateur extends javax.swing.JFrame {
    private JButton AjouterUtilisateur;
    private JButton ModifierUtilisateur;
    private JButton SupprimerUtilisateur;
    private JButton listerUtilisateur;

    public MenuUtilisateur() {
        initComponents();
    }
    public void initComponents(){
        setTitle("Menu Utilisateur");
        setSize(500, 500);
        AjouterUtilisateur = new JButton();
        ModifierUtilisateur = new JButton();
        SupprimerUtilisateur = new JButton();
        listerUtilisateur = new JButton();

        AjouterUtilisateur.setText("Ajouter Utilisateur");
        ModifierUtilisateur.setText("Modifier Utilisateur");
        SupprimerUtilisateur.setText("Supprimer Utilisateur");
        listerUtilisateur.setText("Lister Utilisateur");

        AjouterUtilisateur.setBounds(100, 100, 200, 30);
        ModifierUtilisateur.setBounds(100, 150, 200, 30);
        SupprimerUtilisateur.setBounds(100, 200, 200, 30);
        listerUtilisateur.setBounds(100, 250, 200, 30);

        this.add(AjouterUtilisateur);
        this.add(ModifierUtilisateur);
        this.add(SupprimerUtilisateur);
        this.add(listerUtilisateur);

        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        AjouterUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterUtilisateur aj = new AjouterUtilisateur();
                aj.setVisible(true);
            }
        });

        ModifierUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierUtilisateur mu = new modifierUtilisateur();
                mu.setVisible(true);
            }
        });

        SupprimerUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerUtilisateur su = new SupprimerUtilisateur();
                su.setVisible(true);
            }
        });

        listerUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListUtilisateur lu = new ListUtilisateur();
                lu.setVisible(true);
            }
        });

    }

    public static void main(String[] args) {
        MenuUtilisateur mu = new MenuUtilisateur();
        mu.setVisible(true);
    }
}
