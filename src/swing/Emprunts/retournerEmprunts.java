package swing.Emprunts;

import Class.emprunts;
import swing.mainTest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class retournerEmprunts extends javax.swing.JFrame {
    private JTable empruntsJList;
    private JButton Annuler;
    private JButton retour;

    public retournerEmprunts() {
        initComponents();
    }

    public static void main(String[] args) {
        retournerEmprunts retournerEmprunts = new retournerEmprunts();
    }

    public void initComponents() {
        this.setTitle("Retourner un emprunt");
        this.setSize(400, 200);

        ArrayList<emprunts> empruntslist = mainTest.b1.getEmprunts();

        DefaultTableModel model = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nom utilisateur", "Nom livre", "Date d'emprunt", "Date de retour"}
        );
        empruntsJList = new JTable(model);

        Annuler = new JButton("Retourner");
        retour = new JButton("Retour");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        p1.add(new JLabel("Retourner un emprunt en sélectionnant un emprunt dans la liste ci-dessous"));

        p2.add(new JScrollPane(empruntsJList));
        for (emprunts e : mainTest.b1.getEmpruntsEnCours()) {
            model.addRow(new Object[]{e.getId(), e.getUtilisateur().getnom(), e.getNomLivre(), e.getDateEmprunt(), e.getDateRetourPrevue()});
        }

        p3.add(Annuler);
        p3.add(retour);

        retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int selectedRow = empruntsJList.getSelectedRow();
                emprunts e = mainTest.b1.getEmprunts().get(selectedRow);
                System.out.println(e.toString());
                mainTest.b1.supprimerEmprunt(e);
                mainTest.empruntsHistorique.add(e);
            }
        });

        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });
        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.CENTER);
        this.add(p3, BorderLayout.SOUTH);
        this.setVisible(true);
    }
}
