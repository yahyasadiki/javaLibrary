package swing.Emprunts;

import Class.emprunts;
import swing.mainTest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class prolongerEmprunt extends javax.swing.JFrame {
    private JTable empruntsJList;
    private JButton Annuler;
    private JButton prolonger;
    private JComboBox<Integer> duréeProlongation;

    public prolongerEmprunt() {
        initComponents();
    }

    public static void main(String[] args) {
        prolongerEmprunt prolongerEmprunt = new prolongerEmprunt();
    }

    public void initComponents() {
        this.setTitle("Prolonger un emprunt");
        this.setSize(400, 200);

        ArrayList<emprunts> empruntslist = mainTest.b1.getEmprunts();

        DefaultTableModel model = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nom utilisateur", "Nom livre", "Date d'emprunt", "Date de retour"}
        );
        empruntsJList = new JTable(model);
        duréeProlongation = new JComboBox<Integer>();
        for (int i = 1; i < 8; i++) {
            duréeProlongation.addItem(i);
        }

        prolonger = new JButton("Prolonger un emprunt");
        Annuler = new JButton("Retour");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        p1.add(new JLabel("Prolonger un emprunt en sélectionnant un emprunt dans la liste ci-dessous"));

        p2.add(new JLabel("Durée de prolongation par jour"));
        p2.add(duréeProlongation);
        p2.add(new JScrollPane(empruntsJList));
        for (emprunts e : mainTest.b1.getEmpruntsEnCours()) {
            model.addRow(new Object[]{e.getId(), e.getUtilisateur().getnom(), e.getNomLivre(), e.getDateEmprunt(), e.getDateRetourPrevue()});
        }

        p3.add(prolonger);
        p3.add(Annuler);

        this.setSize(600, 300);

        prolonger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int selectedRow = empruntsJList.getSelectedRow();
                emprunts e = mainTest.b1.getEmprunts().get(selectedRow);
                Date date = new Date();
                e.setDateRetourPrevue(new Date(date.getTime() + duréeProlongation.getSelectedIndex() * 86400000L));
                mainTest.b1.getEmprunts().set(selectedRow, e);
                JOptionPane.showMessageDialog(null, "Emprunt prolongé par " + duréeProlongation.getSelectedIndex() + " jours");
                dispose();
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
    }
}
