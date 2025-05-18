package aeroport;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;

import reservation.Reservation;



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

    public Duration obtenirDuree() {
        if(this.dateDepart != null && this.dateArrivee != null) {
            return Duration.between(dateDepart, dateArrivee);
        }
        return null;
    }

    public ZonedDateTime getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(ZonedDateTime dateDepart) {
        this.dateDepart = dateDepart;
    }

    public ZonedDateTime getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(ZonedDateTime dateArrivee) {
        this.dateArrivee = dateArrivee;
    }


    public Vol() {
    }

    protected Vol(String numero, Compagnie c){
        this.numero = numero;
        if(c == null){
            throw new IllegalArgumentException("Vol non valide, la compagnie ne peut pas être nulle");
        }
    }

    public Compagnie getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(Compagnie compagnie) {
        if(compagnie == null){
            throw new IllegalArgumentException("Impossible. La compagnie ne peut pas être null.");
        }
        this.compagnie = compagnie;
    }



    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Aeroport getDepart() {
        return depart;
    }

    public void setDepart(Aeroport depart) {
        this.depart = depart;
    }

    public Aeroport getArrivee() {
        return arrivee;
    }

    public void setArrivee(Aeroport arrivee) {
        this.arrivee = arrivee;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            return ((Vol) obj).getNumero().equals(this.numero);
        } catch (Exception e){
            return false;
        }
    }

    public boolean estReservable(){
        return placesReservees < capacite;
    }

    public synchronized void reserver(){
        if(!estReservable()){
            throw new IllegalStateException();
        }
        placesReservees++;
    }

    public synchronized void annulerReservation(){
        if(placesReservees > 0){
            placesReservees --;
        }
        else{
            throw new IllegalStateException("Aucune Reservation à annuler");
        }
    }

    public Collection<Reservation> getReservation(){
        return this.reservations;
    }
}
