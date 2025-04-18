package reservation;

import java.util.Date;

public class PieceIdentite {
    private final String numeroIdentite;
    private final String nom;
    private final String prenom;
    private final int taille;
    private final Date dateNaissance;

    public PieceIdentite(String numeroIdentite, String nom, String prenom, int taille, Date dateNaissance) {
        this.numeroIdentite = numeroIdentite;
        this.nom = nom;
        this.prenom = prenom;
        this.taille = taille;
        this.dateNaissance = dateNaissance;
    }

    public String getNumeroIdentite() {
        return numeroIdentite;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public int getTaille() {
        return taille;
    }   
    public Date getDateNaissance() {
        return dateNaissance;
    }
    @Override
    public String toString() {
        return "PieceIdentite{" +
                "numeroIdentite='" + numeroIdentite + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", taille=" + taille +
                ", dateNaissance=" + dateNaissance +
                '}';
    }
}
