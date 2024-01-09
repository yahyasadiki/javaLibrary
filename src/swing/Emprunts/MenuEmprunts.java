package swing.Emprunts;

import javax.swing.*;

public class MenuEmprunts extends javax.swing.JFrame {
    private JButton btnAjouter;
    private JButton btnRetourner;
    private JButton btnProlonger;

    public MenuEmprunts() {
        initComponents();
    }

    public static void main(String[] args) {
        MenuEmprunts menu = new MenuEmprunts();
    }

    public void initComponents() {
        btnAjouter = new JButton("Ajouter");
        btnRetourner = new JButton("Retourner un emprunt");
        btnProlonger = new JButton("Prolonger un emprunt");


        this.setTitle("Menu Emprunts");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(btnAjouter);
        panel.add(btnRetourner);
        panel.add(btnProlonger);


        btnAjouter.addActionListener(e -> {
            AjouterEmprunt ae = new AjouterEmprunt();
            ae.setVisible(true);
        });

        btnRetourner.addActionListener(e -> {
            retournerEmprunts re = new retournerEmprunts();
            re.setVisible(true);
        });

        btnProlonger.addActionListener(e -> {
            prolongerEmprunt pe = new prolongerEmprunt();
            pe.setVisible(true);
        });
        this.setContentPane(panel);
        this.setVisible(true);
    }
}
