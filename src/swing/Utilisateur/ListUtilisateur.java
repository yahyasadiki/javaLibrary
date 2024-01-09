package swing.Utilisateur;

import Class.utilisateur;
import swing.mainTest;

import javax.swing.*;
import java.util.ArrayList;

public class ListUtilisateur extends javax.swing.JFrame{
    private JTable listutilisateur;

    public ListUtilisateur(){
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Liste des utilisateurs");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        String[] entetes = {"ID", "Nom", "age", "role", "nombre d'emprunts"};
        ArrayList<utilisateur> utilisateurs = mainTest.b1.getEmprunteurs();
        Object[][] donnees = new Object[utilisateurs.size()][5];

        for (int i = 0; i < mainTest.b1.getEmprunteurs().size(); i++) {
            donnees[i][0] = i;
            donnees[i][1] = mainTest.b1.getEmprunteurs().get(i).getnom();
            donnees[i][2] = mainTest.b1.getEmprunteurs().get(i).age();
            donnees[i][3] = mainTest.b1.getEmprunteurs().get(i).role();
            donnees[i][4] = mainTest.b1.getEmprunteurs().get(i).getNbrEmpruntsParutilisateur();
        }

        listutilisateur = new JTable(donnees, entetes);
        listutilisateur.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 70));
        listutilisateur.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(listutilisateur);
        add(scrollPane);
        this.setVisible(true);
    }


    public void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public static void main(String[] args) {
        ListUtilisateur listutilisateur = new ListUtilisateur();
    }
}

