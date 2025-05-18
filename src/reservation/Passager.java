package reservation;

import java.util.Date;

// Classe représentant un passager avec un nom, une date de naissance et une pièce d'identité.
public class Passager {

    // Attributs privés pour garantir l'encapsulation.
    private final String nom; // Le nom du passager.
    private final Date dateNaissance; // La date de naissance du passager.
    private final PieceIdentite pieceIdentite; // La pièce d'identité du passager.

    /**
     * Constructeur de la classe Passager.
     * Initialise un passager avec un nom, une date de naissance et une pièce d'identité.
     *
     * @param nom Le nom du passager.
     * @param dateNaissance La date de naissance du passager.
     * @param pieceIdentite La pièce d'identité du passager.
     */
    public Passager(String nom, Date dateNaissance, PieceIdentite pieceIdentite) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.pieceIdentite = pieceIdentite;
    }

    /**
     * Retourne le nom du passager.
     *
     * @return Le nom du passager.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne la date de naissance du passager.
     *
     * @return La date de naissance du passager.
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Retourne la pièce d'identité du passager.
     *
     * @return La pièce d'identité du passager.
     */
    public PieceIdentite getPieceIdentite() {
        return pieceIdentite;
    }
}