package aeroport;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;

import reservation.Reservation;

/**
 * Classe représentant un vol d'avion avec toutes ses caractéristiques
 * (numéro, aéroports, dates, capacité, etc.)
 */
public class Vol {

    private String numero;

    private Aeroport depart;

    private Aeroport arrivee;

    private Compagnie compagnie;

    private ZonedDateTime dateDepart;

    private ZonedDateTime dateArrivee;

    private int placesReservees;

    private int capacite;

    private Collection<Reservation> reservations = new ArrayList<>();

    /**
     * Calcule la durée du vol en fonction des dates de départ et d'arrivée
     * 
     * @return La durée du vol sous forme d'un objet Duration, ou null si une 
     *         des dates n'est pas définie
     */
    public Duration obtenirDuree() {
        if(this.dateDepart != null && this.dateArrivee != null) {
            return Duration.between(dateDepart, dateArrivee);
        }
        return null;
    }

    /**
     * Obtient la date et l'heure de départ du vol
     * 
     * @return La date et l'heure de départ du vol
     */
    public ZonedDateTime getDateDepart() {
        return dateDepart;
    }

    /**
     * Définit la date et l'heure de départ du vol
     * 
     * @param dateDepart La nouvelle date et heure de départ à définir
     */
    public void setDateDepart(ZonedDateTime dateDepart) {
        this.dateDepart = dateDepart;
    }

    /**
     * Obtient la date et l'heure d'arrivée du vol
     * 
     * @return La date et l'heure d'arrivée du vol
     */
    public ZonedDateTime getDateArrivee() {
        return dateArrivee;
    }

    /**
     * Définit la date et l'heure d'arrivée du vol
     * 
     * @param dateArrivee La nouvelle date et heure d'arrivée à définir
     */
    public void setDateArrivee(ZonedDateTime dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    /**
     * Constructeur par défaut pour créer un vol vide
     */
    public Vol() {
    }

    /**
     * Constructeur protégé pour créer un vol avec un numéro et une compagnie
     * 
     * @param numero Le numéro du vol à créer
     * @param c La compagnie aérienne du vol
     * @throws IllegalArgumentException Si la compagnie est null
     */
    protected Vol(String numero, Compagnie c){
        this.numero = numero;
        if(c == null){
            throw new IllegalArgumentException("Vol non valide, la compagnie ne peut pas être nulle");
        }
    }

    /**
     * Obtient la compagnie aérienne associée au vol
     * 
     * @return La compagnie aérienne du vol
     */
    public Compagnie getCompagnie() {
        return compagnie;
    }

    /**
     * Définit la compagnie aérienne pour ce vol
     * 
     * @param compagnie La nouvelle compagnie à définir pour ce vol
     * @throws IllegalArgumentException Si la compagnie est null
     */
    public void setCompagnie(Compagnie compagnie) {
        if(compagnie == null){
            throw new IllegalArgumentException("Impossible. La compagnie ne peut pas être null.");
        }
        this.compagnie = compagnie;
    }

    /**
     * Obtient le numéro du vol
     * 
     * @return Le numéro du vol
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Définit le numéro du vol
     * 
     * @param numero Le nouveau numéro à définir
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtient l'aéroport de départ du vol
     * 
     * @return L'aéroport de départ
     */
    public Aeroport getDepart() {
        return depart;
    }

    /**
     * Définit l'aéroport de départ du vol
     * 
     * @param depart Le nouvel aéroport de départ
     */
    public void setDepart(Aeroport depart) {
        this.depart = depart;
    }

    /**
     * Obtient l'aéroport d'arrivée du vol
     * 
     * @return L'aéroport d'arrivée
     */
    public Aeroport getArrivee() {
        return arrivee;
    }

    /**
     * Définit l'aéroport d'arrivée du vol
     * 
     * @param arrivee Le nouvel aéroport d'arrivée
     */
    public void setArrivee(Aeroport arrivee) {
        this.arrivee = arrivee;
    }

    /**
     * Redéfinition de la méthode equals pour comparer deux vols
     * Deux vols sont considérés égaux s'ils ont le même numéro
     * 
     * @param obj L'objet à comparer avec ce vol
     * @return true si les vols ont le même numéro, false sinon
     */
    @Override
    public boolean equals(Object obj) {
        try {
            return ((Vol) obj).getNumero().equals(this.numero);
        } catch (Exception e){
            return false;
        }
    }

    /**
     * Vérifie si le vol peut encore accepter des réservations
     * 
     * @return true si le nombre de places réservées est inférieur à la capacité, false sinon
     */
    public boolean estReservable(){
        return placesReservees < capacite;
    }

    /**
     * Réserve une place sur le vol
     * Cette méthode est synchronisée pour éviter les problèmes de concurrence
     * 
     * @throws IllegalStateException Si le vol est complet (plus de places disponibles)
     */
    public synchronized void reserver(){
        if(!estReservable()){
            throw new IllegalStateException();
        }
        placesReservees++;
    }

    /**
     * Annule une réservation sur le vol
     * Cette méthode est synchronisée pour éviter les problèmes de concurrence
     * 
     * @throws IllegalStateException Si aucune réservation n'existe pour ce vol
     */
    public synchronized void annulerReservation(){
        if(placesReservees > 0){
            placesReservees --;
        }
        else{
            throw new IllegalStateException("Aucune Reservation à annuler");
        }
    }

    /**
     * Obtient la liste des réservations pour ce vol
     * 
     * @return La collection des réservations associées à ce vol
     */
    public Collection<Reservation> getReservation(){
        return this.reservations;
    }
}
