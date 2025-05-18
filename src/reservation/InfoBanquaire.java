package reservation;

// Classe représentant les informations bancaires d'un client.
public class InfoBanquaire {

    private final String nomBanque; // Le nom de la banque.
    private final String numeroCompte; // Le numéro de compte bancaire.
    private final String codeBanque; // Le code de la banque.
    private final String codeGuichet; // Le code du guichet.
    private final String cleRib; // La clé RIB.
    private int solde; // Le solde du compte bancaire.

    /**
     * Constructeur de la classe InfoBanquaire.
     * Initialise les informations bancaires avec les détails fournis.
     *
     * @param nomBanque Le nom de la banque.
     * @param numeroCompte Le numéro de compte bancaire.
     * @param codeBanque Le code de la banque.
     * @param codeGuichet Le code du guichet.
     * @param cleRib La clé RIB.
     * @param solde Le solde initial du compte bancaire.
     */
    public InfoBanquaire(String nomBanque, String numeroCompte, String codeBanque, String codeGuichet, String cleRib, int solde) {
        this.nomBanque = nomBanque;
        this.numeroCompte = numeroCompte;
        this.codeBanque = codeBanque;
        this.codeGuichet = codeGuichet;
        this.cleRib = cleRib;
        this.solde = solde;
    }

    /**
     * Débite un montant du compte bancaire.
     * Vérifie que le solde est suffisant avant de débiter.
     *
     * @param montant Le montant à débiter.
     * @throws IllegalArgumentException Si le montant est supérieur au solde.
     */
    public void debiter(float montant) {
        if (montant <= solde) {
            solde -= montant;
        } else {
            throw new IllegalArgumentException("Fonds insuffisants pour débiter " + montant);
        }
    }

    /**
     * Crédite un montant sur le compte bancaire.
     *
     * @param montant Le montant à créditer.
     * @throws IllegalArgumentException Si le montant est négatif.
     */
    public void crediter(float montant) {
        if (montant < 0) {
            throw new IllegalArgumentException("Le montant à créditer ne peut pas être négatif.");
        }
        solde += montant;
    }

    /**
     * Retourne le nom de la banque.
     *
     * @return Le nom de la banque.
     */
    public String getNomBanque() {
        return nomBanque;
    }

    /**
     * Retourne le numéro de compte bancaire.
     *
     * @return Le numéro de compte bancaire.
     */
    public String getNumeroCompte() {
        return numeroCompte;
    }

    /**
     * Retourne le code de la banque.
     *
     * @return Le code de la banque.
     */
    public String getCodeBanque() {
        return codeBanque;
    }

    /**
     * Retourne le code du guichet.
     *
     * @return Le code du guichet.
     */
    public String getCodeGuichet() {
        return codeGuichet;
    }

    /**
     * Retourne la clé RIB.
     *
     * @return La clé RIB.
     */
    public String getCleRib() {
        return cleRib;
    }

    /**
     * Retourne le solde actuel du compte bancaire.
     *
     * @return Le solde actuel.
     */
    public int getSolde() {
        return solde;
    }

    
}