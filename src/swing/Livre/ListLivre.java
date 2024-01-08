package swing.Livre;

import Class.livre;
import swing.mainTest;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListLivre extends JFrame {
    private JLabel TitreJFrame;
    private JTable listLivre;
    private JComboBox empruntstatus;

    public ListLivre() {
        initComponents();
    }

    public void initComponents() {
        setTitle("Liste des livres");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 500);
        afficherLivre();
    }

    public void afficherLivre() {
        ArrayList<livre> livres = mainTest.b1.getLivres();

        if (livres != null) {  // Check if livres is not null before proceeding
            String[] columnNames = {"Titre", "Auteur", "Année de publication", "Genre", "Nombre d'emprunts"};
            Object[][] data = new Object[livres.size()][5];

            for (int i = 0; i < livres.size(); i++) {
                data[i][0] = livres.get(i).titre();
                data[i][1] = livres.get(i).auteur();
                data[i][2] = livres.get(i).anneeDePublication();
                data[i][3] = livres.get(i).genre();
                data[i][4] = livres.get(i).getnbrEmprunts();
            }

            listLivre = new JTable(data, columnNames);
            listLivre.setPreferredScrollableViewportSize(new Dimension(500, 70));
            listLivre.setFillsViewportHeight(true);
            JScrollPane scrollPane = new JScrollPane(listLivre);
            add(scrollPane);
            this.setVisible(true);
        } else {
            // Handle the case where livres is null (e.g., show an error message)
            JOptionPane.showMessageDialog(this, "Aucun livre n'est disponible.");
        }
    }

    public static void main(String[] args) {
        ListLivre listLivre = new ListLivre();
    }
}
