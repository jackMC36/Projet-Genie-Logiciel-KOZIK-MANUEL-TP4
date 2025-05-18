package reservation;

import aeroport.Vol;
import java.time.ZonedDateTime;

// Classe représentant une réservation effectuée par un client pour un vol.
public class Reservation {

    // Attributs privés pour garantir l'encapsulation.
    private final Client client; // Le client qui effectue la réservation.
    private final ZonedDateTime date; // La date de la réservation.
    private final float prix; // Le prix de la réservation.
    private final Vol vol; // Le vol associé à la réservation.
    private final Passager passager; // Le passager associé à la réservation.

    /**
     * Constructeur privé de la classe Reservation.
     * Initialise une réservation avec les informations fournies.
     *
     * @param client Le client qui effectue la réservation.
     * @param date La date de la réservation.
     * @param prix Le prix de la réservation.
     * @param vol Le vol associé à la réservation.
     * @param passager Le passager associé à la réservation.
     */
    private Reservation(Client client, ZonedDateTime date, float prix, Vol vol, Passager passager) {
        this.client = client;
        this.date = date;
        this.prix = prix;
        this.vol = vol;
        this.passager = passager;
    }

    /**
     * Méthode statique pour créer une réservation.
     * Vérifie si le vol est réservable avant de créer la réservation.
     * Cette méthode est synchronisée pour éviter les conflits entre threads.
     *
     * @param client Le client qui effectue la réservation.
     * @param date La date de la réservation.
     * @param prix Le prix de la réservation.
     * @param vol Le vol associé à la réservation.
     * @param passager Le passager associé à la réservation.
     * @return Une instance de Reservation.
     * @throws IllegalArgumentException Si le vol n'est pas réservable.
     */
    public static synchronized Reservation create(Client client, ZonedDateTime date, float prix, Vol vol, Passager passager) {
        if (vol.estReservable()) {
            return new Reservation(client, date, prix, vol, passager);
        } else {
            throw new IllegalArgumentException("Le vol n'est pas réservable");
        }
    }

    /**
     * Retourne le client associé à la réservation.
     *
     * @return Le client associé à la réservation.
     */
    public Client getClient() {
        return client;
    }

    /**
     * Retourne la date de la réservation.
     *
     * @return La date de la réservation.
     */
    public ZonedDateTime getDate() {
        return date;
    }

    /**
     * Effectue le paiement de la réservation.
     * Débite le compte bancaire du client du montant de la réservation.
     */
    public void payer() {
        client.debiter(this.prix);
    }

    /**
     * Annule la réservation.
     * Libère la place réservée sur le vol.
     */
    public void annuler() {
        vol.annulerReservation();
    }

    /**
     * Confirme la réservation.
     * Réserve une place sur le vol.
     */
    public void confirmer() {
        vol.reserver();
    }

    /**
     * Rembourse la réservation.
     * Crédite le compte bancaire du client du montant de la réservation.
     */
    public void rembourser() {
        client.crediter((int) this.prix);
    }
}