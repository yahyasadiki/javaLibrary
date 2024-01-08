package Class;


public class utilisateur {
    private static int id = 0;
    private String nom;
    private int age;
    private String role;

    private int nbrEmpruntsParutilisateur;


    public utilisateur(String nom, int age, String role) {
        id++;
        id = id;
        this.nom = nom;
        this.age = age;
        this.role = role;
        this.nbrEmpruntsParutilisateur = 0;
    }

    public void modifiertilisateur(utilisateur utilisateur, String nom, int age, String role) {
        id = id;
        this.nom = nom;
        this.age = age;
        this.role = role;
    }

    public void supprimerutilisateur(utilisateur utilisateur) {
        id = 0;
        this.nom = null;
        this.age = 0;
        this.role = null;
        this.nbrEmpruntsParutilisateur = 0;
    }

    public void afficherutilisateur() {
        System.out.println(this);
    }

    public void incrementerNbrEmpruntsParutilisateur() {
        nbrEmpruntsParutilisateur++;
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        utilisateur.id = id;
    }

    public String getnom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int age() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String role() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public int getNbrEmpruntsParutilisateur() {
        return nbrEmpruntsParutilisateur;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", age='" + age + '\'' +
                ", role=" + role +
                ", nombre d'emprunts par user =" + nbrEmpruntsParutilisateur +
                '}';
    }
}