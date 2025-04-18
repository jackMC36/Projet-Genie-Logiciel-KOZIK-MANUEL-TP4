package reservation;
import aeroport.Vol;


import java.time.ZonedDateTime;

public class Reservation {

    private final Client client;
    private final ZonedDateTime date;
    private final float prix;
    private final Vol vol;
    private final Passager passager;

    public Reservation(Client client, ZonedDateTime date, float prix, Vol vol, Passager passager) {
        this.client = client;
        this.date = date;
        this.prix = prix;
        this.vol = vol;
        this.passager = passager;
    }

    public Client getClient() {
        return client;
    }

    public static Reservation create(Client client, ZonedDateTime date, float prix, Vol vol, Passager passager) {
        if(vol.estReservable()){
             return new Reservation(client, date, prix, vol, passager);
        }
        else{
            throw new IllegalArgumentException("Le vol n'est pas reservable");
        }
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void payer(){

    }

    public void annuler(){
    
    }

    public void confirmer(){

    }

    public void rembourser(){

    }
}
