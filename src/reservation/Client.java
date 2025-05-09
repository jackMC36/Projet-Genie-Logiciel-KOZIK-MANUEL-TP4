package reservation;


public class Client{
    private final User user;
    private final String nom;
    private final InfoBanquaire infoBanquaire;

    
    public Client(User user, String nom, InfoBanquaire infoBanquaire){
        if(user == null || nom == null || infoBanquaire == null) {
            throw new IllegalArgumentException("User, nom, and infoBanquaire cannot be null");
        }
        if(nom.isEmpty()) {
            throw new IllegalArgumentException("Nom cannot be empty");
        }
        if(infoBanquaire.getSolde() < 0) {
            throw new IllegalArgumentException("Solde cannot be negative");
        }
        this.user = user;
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
