package aeroport;

import java.time.Duration;
import java.time.ZonedDateTime;

/**
 * Classe représentant une étape dans un itinéraire de voyage
 * Une étape est caractérisée par un aéroport et une date/heure
 */
public class Etape{


    private ZonedDateTime date;

    private Aeroport aeroport;

    /**
     * Constructeur par défaut pour créer une étape vide
     */
    public Etape(){

    }

    /**
     * Constructeur protégé pour créer une étape avec une date spécifique
     * 
     * @param date La date et l'heure de l'étape
     */
    protected Etape(ZonedDateTime date){
        this.date = date;
    }

    /**
     * Décale la date de cette étape en ajoutant une durée
     * Utile pour gérer les retards ou modifications de planning
     * 
     * @param T La durée à ajouter à la date actuelle de l'étape
     */
    public void decaler(Duration T) {
        this.date = this.date.plus(T);
    }

    public Aeroport getAeroport(){
        return this.aeroport;
    }
}