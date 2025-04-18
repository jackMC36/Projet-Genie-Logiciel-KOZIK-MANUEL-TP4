package reservation;

public class InfoBanquaire {
    private final String nomBanque;
    private final String numeroCompte;
    private final String codeBanque;
    private final String codeGuichet;
    private final String cleRib;

    public InfoBanquaire(String nomBanque, String numeroCompte, String codeBanque, String codeGuichet, String cleRib) {
        this.nomBanque = nomBanque;
        this.numeroCompte = numeroCompte;
        this.codeBanque = codeBanque;
        this.codeGuichet = codeGuichet;
        this.cleRib = cleRib;
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
    
}
