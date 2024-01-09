package swing;

import Class.bibliotheque;
import Class.emprunts;
import Class.livre;
import Class.utilisateur;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.util.ArrayList;


public class mainTest {
    public static ArrayList<livre> livres = new ArrayList<>();

    public static ArrayList<emprunts> emprunts = new ArrayList<>();
    public static ArrayList<emprunts> empruntsHistorique = new ArrayList<>();
    public static bibliotheque b1 = new bibliotheque("Bibliotheque de l'Universite de Paris", "Paris");

    public static void main(String[] args) {

        try {
            //flatlaf dark intellij
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            System.out.println("Error setting native LAF: " + e);
        }
        b1.ajouterLivre(new livre("Livre 1", "Auteur 1", 1990, "policier"));
        b1.ajouterLivre(new livre("Livre 2", "Auteur 2", 1991, "BD"));

        b1.ajouterEmprunteur(new utilisateur("Utilisateur 1", 81, "adherent"));
        b1.ajouterEmprunteur(new utilisateur("Utilisateur 2", 82, "adherent"));
        b1.ajouterEmprunteur(new utilisateur("yahya", 83, "admin"));
        Login login = new Login();
        login.setVisible(true);
    }
}


