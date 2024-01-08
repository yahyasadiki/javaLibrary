package swing.Livre;

import javax.swing.*;
import java.awt.*;

public class MenuLivre extends JFrame {
    private JButton ajouter;
    private JButton lister;
    private JButton supprimer;
    private JButton modifier;


    public MenuLivre() {
        initComponents();
    }


    public void initComponents() {
        setTitle("Menu Livre");
        setSize(300, 200);

        ajouter = new JButton("Ajouter");
        lister = new JButton("Lister");
        supprimer = new JButton("Supprimer");
        modifier = new JButton("Modifier");

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 1));
        p1.add(ajouter);
        p1.add(lister);
        p1.add(supprimer);
        p1.add(modifier);
        p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(p1);

        ajouter.addActionListener(e -> {
            AjouterLivre aj = new AjouterLivre();
            aj.setVisible(true);
        });

        lister.addActionListener(e -> {
            ListLivre ll = new ListLivre();

            ll.setVisible(true);
        });

        supprimer.addActionListener(e -> {
            SupprimerLivre sl = new SupprimerLivre();
            sl.setVisible(true);
        });

        modifier.addActionListener(e -> {
            ModifierLivre ml = new ModifierLivre();
            ml.setVisible(true);
        });

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MenuLivre ml = new MenuLivre();
    }
}
