package aeroport;

/**
 * Classe représentant un aéroport
 * Contient des informations comme le nom et la ville de l'aéroport
 */
public class Aeroport {


    private String nom;

    private String ville;

    public Aeroport() {
    }

    /**
     * Obtient le nom de l'aéroport
     * 
     * @return Le nom de l'aéroport
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de l'aéroport
     * 
     * @param nom Le nouveau nom à définir pour cet aéroport
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient la ville où se situe l'aéroport
     * 
     * @return La ville de l'aéroport
     */
    public String getVille() {
        return ville;
    }

    /**
     * Définit la ville où se situe l'aéroport
     * 
     * @param ville La nouvelle ville à définir pour cet aéroport
     */
    public void setVille(String ville) {
        this.ville = ville;
    }
}
