package reservation;


public class Client{
    private final String nom;
    private final InfoBanquaire infoBanquaire;

    
    public Client(String nom, InfoBanquaire infoBanquaire){
        this.nom = nom;
        this.infoBanquaire = infoBanquaire;
    }


    public String getNom() {
        return nom;
    }

    public void debiter(float montant){
        if (montant <= infoBanquaire.getSolde()) {
            infoBanquaire.debiter(montant);
        } else {
            System.out.println("Fonds insuffisants");
        }
    }

    public void crediter(int montant){
        infoBanquaire.crediter(montant);
    }
}
