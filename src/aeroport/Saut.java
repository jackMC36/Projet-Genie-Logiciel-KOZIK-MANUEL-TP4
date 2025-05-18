package aeroport;

import java.time.Duration;

/**
 * Classe représentant un saut entre deux aéroports dans un trajet
 * Les sauts peuvent être chaînés pour former un itinéraire complet
 */
public class Saut{

    private Duration duree;

    private Saut suivant;

    public Saut(){

    }

    protected Saut(Duration duree){
        this.duree = duree;
    }

    /**
     * Vérifie si ce saut est suivi par un autre saut
     * 
     * @return true si ce saut est suivi par un autre, false sinon
     */
    public boolean precede(){
        if(this.suivant == null){
            return false;
        }
        return true;
    }

    /**
     * Obtient la durée de ce saut
     * 
     * @return La durée du saut
     */
    public Duration getDuree() {
        return duree;
    }

    /**
     * Définit la durée de ce saut
     * 
     * @param duree La nouvelle durée à définir pour ce saut
     */
    public void setDuree(Duration duree) {
        this.duree = duree;
    }
    
    /**
     * Obtient le saut suivant dans l'itinéraire
     * 
     * @return Le saut suivant dans la chaîne, ou null s'il n'y en a pas
     */
    public Saut getSuivant() {
        return suivant;
    }

    /**
     * Définit le saut suivant dans l'itinéraire
     * 
     * @param suivant Le nouveau saut suivant à associer à ce saut
     */
    public void setSuivant(Saut suivant) {
        this.suivant = suivant;
    }

    /**
     * Décale la durée du saut en ajoutant une durée supplémentaire
     * 
     * @param T La durée à ajouter à la durée actuelle du saut
     */
    public void decaler(Duration T) {
        this.duree = this.duree.plus(T);
    }

    /**
     * Décale la durée du saut en ajoutant la durée d'un autre saut
     * 
     * @param s Le saut dont la durée sera ajoutée à ce saut
     */
    public void decaler(Saut s) {
        this.duree = this.duree.plus(s.getDuree());
    }

    
}