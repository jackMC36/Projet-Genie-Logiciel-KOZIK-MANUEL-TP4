package aeroport;

import java.time.Duration;
import java.time.ZonedDateTime;



public class Vol {

    private String numero;

    private Aeroport depart;

    private Aeroport arrivee;

    private Compagnie compagnie;

    private ZonedDateTime dateDepart;

    private ZonedDateTime dateArrivee;

    private int placesReservees;

    private int capacite;

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

    protected Vol(String numero){
        this.numero = numero;
    }

    public Compagnie getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(Compagnie compagnie) {
        if(compagnie!=null) {
            compagnie.addVolWithoutBidirectional(this);
        }
        if(this.compagnie!=null){
            this.compagnie.removeVolWithoutBidirectional(this);
        }
        this.compagnie = compagnie;
    }

    protected void setCompagnieWithoutBidirectional(Compagnie compagnie) {
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
}
