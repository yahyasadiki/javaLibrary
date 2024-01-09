package swing.Utilisateur;
import Class.utilisateur;
import swing.mainTest;

import javax.swing.*;
import java.awt.*;

public class modifierUtilisateur2 extends JFrame {
    private final utilisateur user;

    public modifierUtilisateur2(utilisateur user) {
        this.user = user;
        initComponents();
    }

    public void initComponents(){

        this.setTitle("Modifier un utilisateur");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.add(new JLabel("Modifier un utilisateur"));
        this.add(p1, BorderLayout.NORTH);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 2));
        p2.add(new JLabel("Nom de l'utilisateur :"));
        JTextField nom = new JTextField(user.getnom());
        p2.add(nom);
        p2.add(new JLabel("Prénom de l'utilisateur :"));
        JTextField prenom = new JTextField();
        p2.add(prenom);
        JSpinner age = new JSpinner();
        age.setModel(new SpinnerNumberModel(0, 0, 100, 1));
        p2.add(new JLabel("Age de l'utilisateur :"));
        age.setValue(user.age());
        p2.add(age);
        this.add(p2, BorderLayout.CENTER);


        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton Modifier = new JButton("Modifier");
        JButton Annuler = new JButton("Annuler");
        p3.add(Modifier);
        p3.add(Annuler);
        this.add(p3, BorderLayout.SOUTH);



        Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user.setNom(nom.getText()+ " " + prenom.getText());
                user.setAge((int) age.getValue());
                mainTest.b1.getEmprunteurs().set(mainTest.b1.getEmprunteurs().indexOf(user), user);
                if (mainTest.b1.getEmprunteurs().contains(user)) {
                    JOptionPane.showMessageDialog(null, "L'utilisateur a bien été modifié");
                } else {
                    JOptionPane.showMessageDialog(null, "L'utilisateur n'a pas été modifié");
                }
                dispose();
            }
            });

        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });

        this.setVisible(true);
    }
}

