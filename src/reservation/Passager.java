package reservation;

import java.util.Date;

public class Passager{

    private final String nom;
    private final Date dateNaissance;
    private final PieceIdentite pieceIdentite;

    public Passager(String nom, Date dateNaissance, PieceIdentite pieceIdentite) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.pieceIdentite = pieceIdentite;
    }
    public String getNom() {
        return nom;
    }
    public Date getDateNaissance() {
        return dateNaissance;
    }
    public PieceIdentite getPieceIdentite() {
        return pieceIdentite;
    }


}