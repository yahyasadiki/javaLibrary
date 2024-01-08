package Class;

import java.util.ArrayList;

public class bibliotheque {
    private final ArrayList<livre> livres;
    private final ArrayList<utilisateur> emprunteurs;
    private final ArrayList<emprunts> emprunts;
    private final String nom;
    private final String adresse;

    public bibliotheque(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        livres = new ArrayList<livre>();
        emprunteurs = new ArrayList<utilisateur>();
        emprunts = new ArrayList<emprunts>();
    }

    public void setEmprunts(ArrayList<emprunts> emprunts) {
        this.emprunts.clear();
        this.emprunts.addAll(emprunts);
    }
    public void ajouterEmprunteur(utilisateur utilisateur) {
        emprunteurs.add(utilisateur);
    }

    public void ajouterLivre(livre livre) {
        livres.add(livre);
    }

    public void supprimerLivre(livre livre) {
        livres.remove(livre);
    }

    public void supprimerEmprunteur(utilisateur utilisateur) {
        emprunteurs.remove(utilisateur);
    }

    public void ajouterEmprunt(emprunts emprunt) {
        emprunts.add(emprunt);
    }

    public void supprimerEmprunt(emprunts emprunt) {
        emprunts.remove(emprunt);
    }

    public void modifierLivre(livre livre, String titre, String auteur, int anneeDePublication, String genre) {
        livre.setTitre(titre);
        livre.setAuteur(auteur);
        livre.setAnneeDePublication(anneeDePublication);
        livre.setGenre(genre);
    }

    //return emprunt arraylist where isStatutEmprunt = false
    public ArrayList<emprunts> getEmpruntsEnCours() {
        ArrayList<emprunts> empruntsEnCours = new ArrayList<>();
        for (emprunts emprunt : emprunts) {
                empruntsEnCours.add(emprunt);
        }
        return empruntsEnCours;
    }

    public emprunts getEmpruntById(int id) {
        for (emprunts emprunt : emprunts) {
            if (emprunt.getId() == id) {
                return emprunt;
            }
        }
        return null;
    }

    public void afficherLivres() {
        for (livre livre : livres) {
            System.out.println(livre);
        }
    }

    public void afficherEmprunts() {
        for (emprunts emprunt : emprunts) {
            System.out.println(emprunt);
        }
    }

    public void setLivres(ArrayList<livre> livres) {
        this.livres.clear();
        this.livres.addAll(livres);
    }

    public ArrayList<livre> getLivres() {
        return livres;
    }

    public ArrayList<utilisateur> getEmprunteurs() {
        return emprunteurs;
    }

    public ArrayList<emprunts> getEmprunts() {
        return emprunts;
    }

    public void bibliotequestats() {
        System.out.println("Nombre de livres : " + livres.size());
        if (!emprunts.isEmpty()) {
            System.out.println("Livres les plus empruntés : " + emprunts.get(0).getLivresEmpruntes().titre());
        } else {
            System.out.println("Aucun livre emprunté pour le moment.");
        }
    }
}
