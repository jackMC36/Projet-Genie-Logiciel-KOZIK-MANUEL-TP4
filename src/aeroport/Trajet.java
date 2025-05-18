package aeroport;

/**
 * Classe représentant un trajet de voyage aérien
 * Un trajet peut comporter un ou plusieurs sauts entre aéroports
 */
public class Trajet{

    private String name;

    private Saut saut;

    /**
     * Constructeur par défaut pour créer un trajet vide
     */
    public Trajet() {
    }

    /**
     * Constructeur protégé pour créer un trajet avec un nom et un saut
     * 
     * @param name Le nom du trajet à créer
     * @param saut Le saut associé à ce trajet
     */
    protected Trajet(String name, Saut saut){
        this.name = name;
        this.saut = saut;
    }

    /**
     * Obtient le nom du trajet
     * 
     * @return Le nom du trajet
     */
    public String getName() {
        return name;
    }
    
    /**
     * Définit le nom du trajet
     * 
     * @param name Le nouveau nom à définir pour ce trajet
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtient le saut associé à ce trajet
     * 
     * @return Le saut associé au trajet
     */
    public Saut getSaut() {
        return saut;
    }
    
    /**
     * Définit le saut associé à ce trajet
     * 
     * @param saut Le nouveau saut à associer à ce trajet
     */
    public void setSaut(Saut saut) {
        this.saut = saut;
    }
}