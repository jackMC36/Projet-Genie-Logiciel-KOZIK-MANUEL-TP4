package reservation;

import java.util.Date;

// Classe représentant une pièce d'identité avec des informations personnelles.
public class PieceIdentite {
    // Attributs privés pour garantir l'encapsulation.
    private final String numeroIdentite; // Le numéro unique de la pièce d'identité.
    private final String nom; // Le nom de la personne.
    private final String prenom; // Le prénom de la personne.
    private final int taille; // La taille de la personne en centimètres.
    private final Date dateNaissance; // La date de naissance de la personne.

    /**
     * Constructeur de la classe PieceIdentite.
     * Initialise une pièce d'identité avec les informations fournies.
     *
     * @param numeroIdentite Le numéro unique de la pièce d'identité.
     * @param nom Le nom de la personne.
     * @param prenom Le prénom de la personne.
     * @param taille La taille de la personne en centimètres.
     * @param dateNaissance La date de naissance de la personne.
     */
    public PieceIdentite(String numeroIdentite, String nom, String prenom, int taille, Date dateNaissance) {
        this.numeroIdentite = numeroIdentite;
        this.nom = nom;
        this.prenom = prenom;
        this.taille = taille;
        this.dateNaissance = dateNaissance;
    }

    /**
     * Retourne le numéro unique de la pièce d'identité.
     *
     * @return Le numéro unique de la pièce d'identité.
     */
    public String getNumeroIdentite() {
        return numeroIdentite;
    }

    /**
     * Retourne le nom de la personne.
     *
     * @return Le nom de la personne.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le prénom de la personne.
     *
     * @return Le prénom de la personne.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Retourne la taille de la personne en centimètres.
     *
     * @return La taille de la personne en centimètres.
     */
    public int getTaille() {
        return taille;
    }

    /**
     * Retourne la date de naissance de la personne.
     *
     * @return La date de naissance de la personne.
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Retourne une représentation textuelle de la pièce d'identité.
     *
     * @return Une chaîne de caractères représentant la pièce d'identité.
     */
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

    /**
     * Méthode utilitaire pour vérifier l'identité d'un passager
     * 
     * @param passager Le passager à vérifier
     * @param pieceIdentite La pièce d'identité à vérifier
     */
    public static void verifierIdentite(Passager passager, PieceIdentite pieceIdentite) {
        PieceIdentite passagerPiece = passager.getPieceIdentite();
        boolean idMatch = passagerPiece.getNumeroIdentite().equals(pieceIdentite.getNumeroIdentite());
        boolean nomMatch = passagerPiece.getNom().equals(pieceIdentite.getNom());
        boolean prenomMatch = passagerPiece.getPrenom().equals(pieceIdentite.getPrenom());
        boolean tailleMatch = passagerPiece.getTaille() == pieceIdentite.getTaille();
        boolean dateMatch = passagerPiece.getDateNaissance().equals(pieceIdentite.getDateNaissance());
        
        if (idMatch && nomMatch && prenomMatch && tailleMatch && dateMatch) {
            System.out.println("Identité vérifiée pour " + passager.getNom() + " " + passager.getPrenom());
        } else {
            System.out.println("Échec de vérification d'identité pour " + passager.getNom() + " " + passager.getPrenom());
            if (!idMatch) System.out.println("   - Numéro d'identification incorrect");
            if (!nomMatch) System.out.println("   - Nom incorrect");
            if (!prenomMatch) System.out.println("   - Prénom incorrect");
            if (!tailleMatch) System.out.println("   - Taille incorrecte");
            if (!dateMatch) System.out.println("   - Date de naissance incorrecte");
        }
    }
}