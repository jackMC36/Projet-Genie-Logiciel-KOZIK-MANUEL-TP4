package reservation;

// Classe représentant un client qui est associé à un utilisateur (User) et possède des informations bancaires.
public class Client {
    // Attributs privés pour garantir l'encapsulation.
    private final User user; // L'utilisateur associé au client.
    private final String nom; // Le nom du client.
    private final InfoBanquaire infoBanquaire; // Les informations bancaires du client.

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
}