package swing.Livre;

import Class.livre;
import swing.mainTest;

import javax.swing.*;
import java.util.ArrayList;

public class ModifierLivre extends JFrame {
    private JButton modifier;
    private JButton annuler;
    private JComboBox titre;

    public ModifierLivre() {
        initComponents();
    }

    public static void main(String[] args) {
        ModifierLivre ml = new ModifierLivre();
        ml.setVisible(true);
    }

    public void initComponents() {

        this.setTitle("Modifier un livre");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        ArrayList<livre> livres = mainTest.b1.getLivres();
        String[] titres = new String[livres.size()];
        for (int i = 0; i < livres.size(); i++) {
            titres[i] = livres.get(i).titre();
        }
        titre = new JComboBox(titres);
        titre.setBounds(50, 50, 300, 30);
        this.add(titre);
        modifier = new JButton("Modifier");
        modifier.setBounds(50, 100, 100, 30);
        this.add(modifier);
        modifier.addActionListener(e -> {
            livre livre = livres.get(titre.getSelectedIndex());
            ModifierLivreFrame ajouterLivre = new ModifierLivreFrame(livre);
            ajouterLivre.setVisible(true);
            this.dispose();

        });


    }
}
