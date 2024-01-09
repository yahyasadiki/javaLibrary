package swing.Emprunts;

import Class.emprunts;
import Class.livre;
import Class.utilisateur;
import swing.mainTest;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class AjouterEmprunt extends javax.swing.JFrame {
    private JComboBox nomLivre;
    private JComboBox dateRetourParSemaine;
    private JComboBox nomEmprunteur;
    private JButton btnAjouter;
    private JButton btnAnnuler;

    public AjouterEmprunt() {
        initComponents();
    }

    public static void main(String[] args) {
        AjouterEmprunt ajouter = new AjouterEmprunt();
    }

    public void initComponents() {
        this.setTitle("Ajouter Emprunt");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        nomLivre = new JComboBox();
        for (livre livre : mainTest.b1.getLivres()) {
            nomLivre.addItem(livre.titre());
        }
        nomEmprunteur = new JComboBox();
        for (utilisateur emprunteur : mainTest.b1.getEmprunteurs()) {
            nomEmprunteur.addItem(emprunteur.getnom());
        }
        dateRetourParSemaine = new JComboBox();
        for (int i = 1; i <= 7; i++) {
            dateRetourParSemaine.addItem(i);
        }
        btnAjouter = new JButton("Ajouter");
        btnAnnuler = new JButton("Annuler");

        JPanel p1 = new JPanel();
        p1.add(new JLabel("Ajourter un emprunt"));
        p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(p1, "North");


        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 2));
        p2.add(new JLabel("Nom du livre"));
        p2.add(nomLivre);
        p2.add(new JLabel("Nom de l'emprunteur"));
        p2.add(nomEmprunteur);
        p2.add(new JLabel("Date de retour par semaine"));
        p2.add(dateRetourParSemaine);
        p2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(p2, "Center");

        JPanel p3 = new JPanel();
        p3.add(btnAjouter);
        p3.add(btnAnnuler);
        p3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(p3, "South");

        this.setVisible(true);

        btnAnnuler.addActionListener(e -> {
            this.dispose();
        });

        btnAjouter.addActionListener(e -> {
            String nomLivre = (String) this.nomLivre.getSelectedItem();


            livre livre = mainTest.b1.getLivres().stream().filter(l -> l.titre().equals(nomLivre)).findFirst().orElse(null);
            String nomEmprunteur = (String) this.nomEmprunteur.getSelectedItem();

            utilisateur emprunteur = mainTest.b1.getAdherents().stream().filter(u -> u.getnom().equals(nomEmprunteur)).findFirst().orElse(null);
            int dateRetourParSemaine = (int) this.dateRetourParSemaine.getSelectedItem();
            Date dateRetour = new Date();
            dateRetour.setDate(dateRetour.getDate() + dateRetourParSemaine * 7);

            emprunts e1 = new emprunts(emprunteur, livre,new Date(), dateRetour);
            mainTest.b1.ajouterEmprunt(e1);
            JOptionPane.showMessageDialog(this, "Emprunt ajouté avec succès"+ e1 + "date de retour: " + dateRetour);
            System.out.println(e1);
            this.dispose();
        });

    }
}
