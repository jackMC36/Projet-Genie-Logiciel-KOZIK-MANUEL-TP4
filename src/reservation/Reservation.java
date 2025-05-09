package reservation;
import aeroport.Vol;


import java.time.ZonedDateTime;

public class Reservation {

    private final Client client;
    private final ZonedDateTime date;
    private final float prix;
    private final Vol vol;
    private final Passager passager;

    private Reservation(Client client, ZonedDateTime date, float prix, Vol vol, Passager passager) {
        this.client = client;
        this.date = date;
        this.prix = prix;
        this.vol = vol;
        this.passager = passager;
    }

    public static synchronized Reservation create(Client client, ZonedDateTime date, float prix, Vol vol, Passager passager) {
        if(vol.estReservable()){
            return new Reservation(client, date, prix, vol, passager);
        }
        else{
            throw new IllegalArgumentException("Le vol n'est pas reservable");
        }
    }

    public Client getClient() {
        return client;
    }


    public ZonedDateTime getDate() {
        return date;
    }

    public void payer(){
        client.debiter(this.prix);
    }

    public void annuler(){
        vol.annulerReservation();
    }

    public void confirmer(){
        vol.reserver();
    }

    public void rembourser(){
        client.crediter((int)this.prix);
    }
}
