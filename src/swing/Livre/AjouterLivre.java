package swing.Livre;

import Class.livre;
import swing.mainTest;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static swing.mainTest.livres;

public class AjouterLivre extends JFrame {
    private JTextField titre;
    private JTextField auteur;
    private JSpinner anneeDePublication;
    private JComboBox genre;
    private JLabel nbrEmprunts;

    public AjouterLivre() {
        initComponents();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AjouterLivre().setVisible(true);
    }

    public void initComponents() {
        setTitle("Ajouter un livre");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);

        titre = new JTextField();
        auteur = new JTextField();
        anneeDePublication = new JSpinner();
        genre = new JComboBox();
        genre.addItem("Roman");
        genre.addItem("Science-fiction");
        genre.addItem("Policier");
        genre.addItem("BD");
        genre.addItem("Manga");
        nbrEmprunts = new JLabel();

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 2));
        p1.add(new JLabel("Titre"));
        p1.add(titre);
        p1.add(new JLabel("Auteur"));
        p1.add(auteur);
        p1.add(new JLabel("Année de publication"));
        anneeDePublication.setModel(new SpinnerNumberModel(2020, 0, 2023, 1));
        p1.add(anneeDePublication);
        p1.add(new JLabel("Genre"));
        p1.add(genre);
        p1.add(new JLabel("Nombre d'emprunts"));
        p1.add(nbrEmprunts);
        p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(p1, BorderLayout.CENTER);

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton ajouter = new JButton("Ajouter");
        JButton annuler = new JButton("Annuler");
        p2.add(ajouter);
        p2.add(annuler);
        this.add(p2, BorderLayout.SOUTH);

        ajouter.addActionListener(e -> {
            String titre = this.titre.getText();
            String auteur = this.auteur.getText();
            int anneeDePublication = (int) this.anneeDePublication.getValue();
            String genre = this.genre.getSelectedItem().toString();
            livre l = new livre(titre, auteur, anneeDePublication, genre);


            mainTest.b1.ajouterLivre(l);
            System.out.println(livres);
            JOptionPane.showMessageDialog(this, "Livre ajouté avec succès");
            this.dispose();
        });

        annuler.addActionListener(e -> {
            this.dispose();
        });
    }
}