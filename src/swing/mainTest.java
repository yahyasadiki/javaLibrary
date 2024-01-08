package swing;

import Class.*;
import java.util.Date;
import javax.swing.*;
import java.util.ArrayList;

public class mainTest {
    public static ArrayList<livre> livres = new ArrayList<>();
    public static ArrayList<utilisateur> utilisateurs = new ArrayList<>();
    public static ArrayList<emprunts> emprunts = new ArrayList<>();
    public static ArrayList<emprunts> empruntsHistorique = new ArrayList<>();
    public static bibliotheque b1 = new bibliotheque("Bibliotheque de l'Universite de Paris", "Paris");

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            System.out.println("Error setting native LAF: " + e);
        }
        b1.ajouterLivre(new livre("Livre 1", "Auteur 1", 1990, "policier"));
        b1.ajouterLivre(new livre("Livre 2", "Auteur 2", 1991, "BD"));

        b1.ajouterEmprunteur(new utilisateur("Utilisateur 1", 81, "adherent"));
        b1.ajouterEmprunteur(new utilisateur("Utilisateur 2", 82, "adherent"));
        Menu menu = new Menu();
        menu.setVisible(true);

    }
}


