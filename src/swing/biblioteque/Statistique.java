package swing.biblioteque;

import Class.emprunts;
import Class.livre;
import Class.utilisateur;
import swing.mainTest;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
        p2.setLayout(new GridLayout(5, 2));
        p2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ArrayList<livre> livres = new ArrayList<>();
        ArrayList<utilisateur> utilisateurs = new ArrayList<>();
        ArrayList<emprunts> emprunts = new ArrayList<>();

        livres = mainTest.b1.getLivres();
        utilisateurs = mainTest.b1.getEmprunteurs();
        emprunts = mainTest.b1.getEmprunts();

        p2.add(new JLabel("Nombre Total Des Livres"));
        p2.add(new JLabel(String.valueOf(livres.size())));

        p2.add(new JLabel("Nombre Total Des Utilisateurs"));
        p2.add(new JLabel(String.valueOf(utilisateurs.size())));

        p2.add(new JLabel("Nombre Total Des Livres Empruntés"));
        p2.add(new JLabel(String.valueOf(emprunts.size())));

        p2.add(new JLabel("Le livre le plus emprunté"));
        p2.add(new JLabel(String.valueOf(mainTest.b1.getLivreMaxEmprunts().titre())));

        p2.add(new JLabel("L'utilisateur qui a emprunté le plus de livres"));
        p2.add(new JLabel(String.valueOf(mainTest.b1.getEmprunteurMaxEmprunts().getnom())));

        this.add(p2, BorderLayout.CENTER);

        this.add(p1, BorderLayout.NORTH);
    }
}
