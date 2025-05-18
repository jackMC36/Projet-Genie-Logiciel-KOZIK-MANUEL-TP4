package reservation;

import java.util.ArrayList;
import java.util.List;

// Classe représentant un client qui est associé à un utilisateur (User) et possède des informations bancaires.
public class Client {

    private final User user; // L'utilisateur associé au client.
    private final String nom; // Le nom du client.
    private final InfoBanquaire infoBanquaire; // Les informations bancaires du client.

    // Liste des passagers associés à ce client
    private final List<Passager> passagers = new ArrayList<>();

    /**
     * Constructeur de la classe Client.
     * Initialise un client avec un utilisateur, un nom et des informations bancaires.
     * Effectue des validations pour s'assurer que les paramètres sont valides.
     *
     * @param user L'utilisateur associé au client.
     * @param nom Le nom du client.
     * @param infoBanquaire Les informations bancaires du client.
     * @throws IllegalArgumentException Si l'un des paramètres est null, si le nom est vide,
     *                                  ou si le solde des informations bancaires est négatif.
     */
    public Client(User user, String nom, InfoBanquaire infoBanquaire) {
        if (user == null || nom == null || infoBanquaire == null) {
            throw new IllegalArgumentException("User, nom, and infoBanquaire cannot be null");
        }
        if (nom.isEmpty()) {
            throw new IllegalArgumentException("Nom cannot be empty");
        }
        if (infoBanquaire.getSolde() < 0) {
            throw new IllegalArgumentException("Solde cannot be negative");
        }
        this.user = user;
        this.nom = nom;
        this.infoBanquaire = infoBanquaire;
    }

    /**
     * Constructeur alternatif qui crée un client avec un email et un numéro de téléphone.
     * Crée automatiquement un User et une InfoBanquaire avec des valeurs par défaut.
     *
     * @param email L'adresse email du client utilisée pour créer un User
     * @param telephone Le numéro de téléphone du client
     */
    public Client(String email, String telephone) {
        this(new User(email, "defaultPassword", telephone),
             "Client " + email.split("@")[0],
             new InfoBanquaire("Default Bank", "000000000", "00000", "00000", "00", 1000));
    }

    /**
     * Retourne le nom du client.
     *
     * @return Le nom du client.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Débite un montant du compte bancaire du client.
     * Vérifie que le solde est suffisant avant de débiter.
     *
     * @param montant Le montant à débiter.
     */
    public void debiter(float montant) {
        if (montant <= infoBanquaire.getSolde()) {
            infoBanquaire.debiter(montant); // Appelle la méthode debiter de la classe InfoBanquaire.
        } else {
            System.out.println("Fonds insuffisants"); // Affiche un message si le solde est insuffisant.
        }
    }

    /**
     * Crédite un montant sur le compte bancaire du client.
     *
     * @param montant Le montant à créditer.
     */
    public void crediter(int montant) {
        infoBanquaire.crediter(montant); // Appelle la méthode crediter de la classe InfoBanquaire.
    }

    /**
     * Ajoute un passager à la liste des passagers associés à ce client.
     *
     * @param passager Le passager à ajouter
     */
    public void ajouterPassager(Passager passager) {
        if (passager != null) {
            passagers.add(passager);
        }
    }

    /**
     * Retire un passager de la liste des passagers associés à ce client.
     *
     * @param passager Le passager à retirer
     * @return true si le passager a été retiré, false sinon
     */
    public boolean retirerPassager(Passager passager) {
        return passagers.remove(passager);
    }

    /**
     * Retourne la liste des passagers associés à ce client.
     *
     * @return La liste des passagers
     */
    public List<Passager> getPassagers() {
        return new ArrayList<>(passagers); // Retourne une copie pour éviter les modifications externes
    }
}