package swing.Utilisateur;

import Class.utilisateur;
import swing.mainTest;

import javax.swing.*;

public class AjouterUtilisateur extends JFrame {
    //similar to ajouterlivre
    private JButton Ajouter;
    private JButton Annuler;
    private JTextField Nom;
    private JTextField Prenom;
    private JSpinner age;
    private JComboBox role;

    public AjouterUtilisateur(){
        initComponents();
    }

    public void initComponents(){
        this.setTitle("Ajouter un utilisateur");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        JLabel l1 = new JLabel("Ajouter un utilisateur");
        p1.add(l1);

        JLabel l2 = new JLabel("Nom : ");
        p2.add(l2);
        Nom = new JTextField(10);
        p2.add(Nom);

        JLabel l3 = new JLabel("Prenom : ");
        p2.add(l3);
        Prenom = new JTextField(10);
        p2.add(Prenom);

        JLabel l4 = new JLabel("Age : ");
        p2.add(l4);
        age = new JSpinner();
        age.setValue(0);
        p2.add(age);

        JLabel l5 = new JLabel("Role : ");
        p2.add(l5);
        role = new JComboBox();
        //bibliothecaire, adherent, admin
        role.addItem("bibliothecaire");
        role.addItem("adherent");
        role.addItem("admin");
        p2.add(role);

        Ajouter = new JButton("Ajouter");
        Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterActionPerformed(evt);
            }
        });

        Annuler = new JButton("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });

        p3.add(Ajouter);
        p3.add(Annuler);

        this.getContentPane().add(p1, "North");
        //p2 gridlayout
        this.getContentPane().add(p2, "Center");
        p2.setLayout(new java.awt.GridLayout(5, 2));

        this.getContentPane().add(p3, "South");

        this.setVisible(true);
    }

    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {
        String nom = Nom.getText();
        String prenom = Prenom.getText();
        int age = Integer.parseInt(String.valueOf(this.age.getValue()));
        String role = String.valueOf(this.role.getSelectedItem());
        if (nom.equals("") || prenom.equals("") || age == 0 || role.equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
            return;
        }
        if (age < 18 && role.equals("Adherent")) {
            JOptionPane.showMessageDialog(null, "L'age doit etre superieur a 18 ans");
            return;
        }
        utilisateur u = new utilisateur(nom + " " + prenom, age, role);

        u.afficherutilisateur();
        swing.mainTest.b1.ajouterEmprunteur(u);
        if (mainTest.b1.getEmprunteurs().contains(u)){
            JOptionPane.showMessageDialog(null, "Utilisateur ajouté avec succès");
        }

        this.dispose();
    }

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }
    public static void main(String[] args) {
        new AjouterUtilisateur();
    }
}
