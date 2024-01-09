package Class;

import java.util.Calendar;
import java.util.Date;

public class emprunts {
    private static int id = 0;
    private final utilisateur Utilisateur;
    private final livre livresEmpruntes;
    private final Date dateEmprunt;
    private Date dateRetourPrevue;
    private Date dateRetourEffective;

    public emprunts(utilisateur Utilisateur, livre livresEmpruntes, Date dateEmprunt, Date dateRetourPrevue) {
        id++;
        this.Utilisateur = Utilisateur;
        this.livresEmpruntes = livresEmpruntes;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevue = dateRetourPrevue;
        livresEmpruntes.incrementerNbrEmprunts();
        Utilisateur.incrementerNbrEmpruntsParutilisateur();
    }



    public void prolongerEmprunt(int joursAjouter) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateRetourPrevue);
        calendar.add(Calendar.DAY_OF_MONTH, joursAjouter);
        dateRetourPrevue = calendar.getTime();
    }

    public int rendreLivre(Date dateRetour) {
        Calendar dRetour = Calendar.getInstance();
        dRetour.setTime(dateRetour);
        int a = dRetour.get(Calendar.DAY_OF_MONTH) - dateRetourPrevue.getDate();
        this.dateRetourEffective = dateRetour;
        if (a > 0) {
            return a;
        } else {
            return 0;
        }

    }

    @Override
    public String toString() {
        return "Emprunts{" +
                "id=" + id +
                ", Utilisateur=" + Utilisateur +
                ", livresEmpruntes=" + livresEmpruntes +
                ", dateEmprunt=" + dateEmprunt +
                ", dateRetourPrevue=" + dateRetourPrevue +
                ", dateRetourEffective=" + dateRetourEffective +
                '}';
    }

    public void afficherEmprunts() {
        System.out.println(this);
    }


    public int getId() {
        return id;
    }

    public utilisateur getUtilisateur() {
        return Utilisateur;
    }

    public String getNomUtilisateur() {
        return utilisateur.class.getName();
    }

    public String getNomLivre() {
        return livresEmpruntes.titre();
    }

    public livre getLivresEmpruntes() {
        return livresEmpruntes;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public Date getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    public Date getDateRetourEffective() {
        return dateRetourEffective;
    }


    public String getDateEmpruntDDMMYYYY() {
        int year = dateEmprunt.getYear() + 1900;
        return dateEmprunt.getDate() + "-" + dateEmprunt.getMonth() + "-" + year;
    }

    public String getDateRetourPrevueDDMMYYYY() {
        int year = dateRetourPrevue.getYear() + 1900;
        return dateRetourPrevue.getDate() + "-" + dateRetourPrevue.getMonth() + "-" + year;
    }

    public static void setId(int id) {
        emprunts.id = id;
    }


    public void setDateRetourPrevue(Date dateRetourPrevue) {
        this.dateRetourPrevue = dateRetourPrevue;
    }

    public void setDateRetourEffective(Date dateRetourEffective) {
        this.dateRetourEffective = dateRetourEffective;

    }

}
