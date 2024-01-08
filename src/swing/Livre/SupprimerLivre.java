package swing.Livre;

import Class.livre;
import swing.mainTest;

import javax.swing.*;
import java.util.ArrayList;

public class SupprimerLivre extends JFrame {
    private JButton supprimer;
    private JButton annuler;
    private JComboBox titre;

    public SupprimerLivre() {
        initComponents();
    }

    public static void main(String[] args) {
        SupprimerLivre sl = new SupprimerLivre();
        sl.setVisible(true);
    }

    public void initComponents() {
        this.setTitle("Supprimer un livre");
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

        supprimer = new JButton("Supprimer");
        supprimer.setBounds(50, 100, 100, 30);
        this.add(supprimer);
        supprimer.addActionListener(e -> {
            livre livre = livres.get(titre.getSelectedIndex());
            mainTest.b1.supprimerLivre(livre);
            JOptionPane.showMessageDialog(null, "Livre supprimé avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        });

        annuler = new JButton("Annuler");
        annuler.setBounds(250, 100, 100, 30);
        this.add(annuler);
        annuler.addActionListener(e -> {
            this.dispose();
        });
    }


}
