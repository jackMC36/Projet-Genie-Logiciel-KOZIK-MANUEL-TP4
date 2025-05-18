package aeroport;

/**
 * Classe permettant de générer des numéros de vol uniques
 * Utilise un préfixe et un compteur pour créer des identifiants séquentiels
 */
public class GenerateurNumeroVol {

    private String prefix;

    private long compteur = 0;

    /**
     * Constructeur pour créer un générateur de numéros de vol
     * 
     * @param prefix Le préfixe à utiliser pour les numéros générés
     * @param compteur La valeur initiale du compteur
     */
    public GenerateurNumeroVol(String prefix, long compteur){
        this.compteur = compteur;
        this.prefix = prefix;
    }

    /**
     * Modifie le préfixe utilisé pour la génération des numéros
     * 
     * @param prefix Le nouveau préfixe à utiliser
     */
    public void setPrefix(String prefix){
        this.prefix = prefix;
    }

    /**
     * Génère un nouveau numéro de vol unique
     * Incrémente le compteur et combine le préfixe avec la nouvelle valeur du compteur
     * 
     * @return Un nouvel objet NumeroVol avec un identifiant unique
     */
    protected NumeroVol generate(){
        this.compteur+=1;
        return new NumeroVol(prefix + this.compteur);
    }
}