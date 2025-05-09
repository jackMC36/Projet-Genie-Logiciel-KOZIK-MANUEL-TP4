package reservation;

public class InfoBanquaire {
    private final String nomBanque;
    private final String numeroCompte;
    private final String codeBanque;
    private final String codeGuichet;
    private final String cleRib;
    private int solde;

    public InfoBanquaire(String nomBanque, String numeroCompte, String codeBanque, String codeGuichet, String cleRib, int solde) {
        this.nomBanque = nomBanque;
        this.numeroCompte = numeroCompte;
        this.codeBanque = codeBanque;
        this.codeGuichet = codeGuichet;
        this.cleRib = cleRib;
        this.solde = solde;

    }

    public void debiter(float montant) {
        if (montant <= solde) {
            solde -= montant;
        } else {
            System.out.println("Fonds insuffisants");
        }
    }

    public void crediter(float montant) {
        solde += montant;
    }

    public String getNomBanque() {
        return nomBanque;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public String getCodeBanque() {
        return codeBanque;
    }

    public String getCodeGuichet() {
        return codeGuichet;
    }

    public String getCleRib() {
        return cleRib;
    }

    public int getSolde() {
        return solde;
    }
    
}
