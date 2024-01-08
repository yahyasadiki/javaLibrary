package swing.Livre;

import Class.livre;
import swing.mainTest;

import javax.swing.*;

public class ModifierLivreFrame extends JFrame {
    private JTextField titre;
    private JTextField auteur;
    private JSpinner anneeDePublication;
    private JComboBox genre;
    private JLabel nbrEmprunts;
    private JButton modifier;
    private final livre livre;

    public ModifierLivreFrame(livre livre) {
        this.livre = livre;
        initComponents();
    }

    public static void main(String[] args) {
        ModifierLivreFrame ml = new ModifierLivreFrame(new livre("titre", "auteur", 2020, "genre"));
        ml.setVisible(true);
    }

    public void initComponents() {
        this.setTitle("Modifier un livre");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        JLabel titreLabel = new JLabel("Titre");
        titreLabel.setBounds(50, 50, 100, 30);
        this.add(titreLabel);

        titre = new JTextField();
        titre.setText(livre.titre());
        titre.setBounds(150, 50, 200, 30);
        this.add(titre);

        JLabel auteurLabel = new JLabel("Auteur");
        auteurLabel.setBounds(50, 100, 100, 30);
        this.add(auteurLabel);

        auteur = new JTextField();
        auteur.setText(livre.auteur());
        auteur.setBounds(150, 100, 200, 30);
        this.add(auteur);

        JLabel anneeDePublicationLabel = new JLabel("Année de publication");
        anneeDePublicationLabel.setBounds(50, 150, 100, 30);
        this.add(anneeDePublicationLabel);

        anneeDePublication = new JSpinner();
        anneeDePublication.setModel(new SpinnerNumberModel(2020, 0, 2020, 1));
        anneeDePublication.setBounds(150, 150, 200, 30);
        this.add(anneeDePublication);

        JLabel genreLabel = new JLabel("Genre");
        genreLabel.setBounds(50, 200, 100, 30);
        this.add(genreLabel);

        String[] genres = {"Roman", "Science-fiction", "Policier", "BD", "Manga", "Manuel scolaire", "Autre"};
        genre = new JComboBox(genres);
        genre.setSelectedItem(livre.genre());
        genre.setBounds(150, 200, 200, 30);
        this.add(genre);

        modifier = new JButton("Modifier");
        modifier.setBounds(50, 250, 100, 30);
        this.add(modifier);

        modifier.addActionListener(e -> {
            livre.setTitre(titre.getText());
            livre.setAuteur(auteur.getText());
            livre.setAnneeDePublication((int) anneeDePublication.getValue());
            livre.setGenre(genre.getSelectedItem().toString());

            mainTest.b1.modifierLivre(livre, titre.getText(), auteur.getText(), (int) anneeDePublication.getValue(), genre.getSelectedItem().toString());

            JOptionPane.showMessageDialog(null, "Livre modifié avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        });
    }
}