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
    
    public void debiter(int montant){
        
    }

    public void crediter(int montant){

    }
}
