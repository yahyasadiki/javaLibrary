package swing.Utilisateur;
import Class.*;
import swing.mainTest;

import javax.swing.*;

public class AjouterUtilisateur extends javax.swing.JFrame{
    //similar to ajouterlivre
    private JButton Ajouter;
    private JButton Annuler;
    private JTextField Nom;
    private JTextField Prenom;
    private JSpinner age;

    public AjouterUtilisateur(){
        initComponents();
    }

    public void initComponents(){
        this.setTitle("Ajouter un utilisateur");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.add(new JLabel("Ajouter un utilisateur")).setBounds(100, 0, 200, 30);
        this.add(new JLabel("Nom")).setBounds(50, 50, 50, 30);
        Nom = new JTextField();
        Nom.setBounds(100, 50, 200, 30);
        this.add(Nom);

        this.add(new JLabel("Prenom")).setBounds(50, 100, 50, 30);
        Prenom = new JTextField();
        Prenom.setBounds(100, 100, 200, 30);
        this.add(Prenom);

       this.add(new JLabel("Age")).setBounds(50, 150, 50, 30);
        age = new JSpinner();
        age.setValue(0);
        age.setBounds(100, 150, 200, 30);
        this.add(age);

        Ajouter = new JButton("Ajouter");
        Ajouter.setBounds(100, 200, 100, 30);
        Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterActionPerformed(evt);
            }
        });
        this.add(Ajouter);

        Annuler = new JButton("Annuler");
        Annuler.setBounds(200, 200, 100, 30);
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        this.add(Annuler);

        this.setLayout(null);
        this.setVisible(true);
    }

    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {
        String nom = Nom.getText();
        String prenom = Prenom.getText();
        int age = Integer.parseInt(String.valueOf(this.age.getValue()));

        utilisateur u = new utilisateur(nom + prenom, age, "Adherent");
        u.afficherutilisateur();
        swing.mainTest.b1.ajouterEmprunteur(u);
        if (mainTest.b1.getEmprunteurs().contains(u)){
            JOptionPane.showMessageDialog(null, "Utilisateur ajouté avec succès");
        }
        this.dispose();
    }

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }
    public static void main(String[] args) {
        new AjouterUtilisateur();
    }
}
