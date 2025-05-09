package aeroport;

public class Trajet{

    private String name;

    private Saut saut;


    public Trajet() {
    }

    protected Trajet(String name, Saut saut){
        this.name = name;
        this.saut = saut;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Saut getSaut() {
        return saut;
    }
    
    public void setSaut(Saut saut) {
        this.saut = saut;
    }

    

}