package reservation;

/**
 * Classe représentant un passager avec une pièce d'identité
 */
public class Passager {
    
    private PieceIdentite pieceIdentite;
    
    /**
     * Constructeur de la classe Passager
     * 
     * @param pieceIdentite La pièce d'identité du passager
     */
    public Passager(PieceIdentite pieceIdentite) {
        this.pieceIdentite = pieceIdentite;
    }
    
    /**
     * Obtient la pièce d'identité du passager
     * 
     * @return La pièce d'identité du passager
     */
    public PieceIdentite getPieceIdentite() {
        return pieceIdentite;
    }
    
    /**
     * Obtient le nom du passager depuis sa pièce d'identité
     * 
     * @return Le nom du passager
     */
    public String getNom() {
        return pieceIdentite.getNom();
    }
    
    /**
     * Obtient le prénom du passager depuis sa pièce d'identité
     * 
     * @return Le prénom du passager
     */
    public String getPrenom() {
        return pieceIdentite.getPrenom();
    }
    
    /**
     * Obtient le numéro d'identification du passager depuis sa pièce d'identité
     * 
     * @return Le numéro d'identification du passager
     */
    public String getNumeroIdentification() {
        return pieceIdentite.getNumeroIdentite();
    }
    
    /**
     * Retourne une représentation textuelle du passager
     * 
     * @return Une chaîne de caractères représentant le passager
     */
    @Override
    public String toString() {
        return "Passager{" +
                "nom='" + getNom() + '\'' +
                ", prenom='" + getPrenom() + '\'' +
                ", numeroIdentification='" + getNumeroIdentification() + '\'' +
                '}';
    }
}