package aeroport;

import java.time.Duration;

public class Saut{

    private Duration duree;

    private Saut suivant;

    public Saut(){

    }

    protected Saut(Duration duree){
        this.duree = duree;
    }

    public boolean precede(){
        if(this.suivant == null){
            return false;
        }
        return true;
    }

    public Duration getDuree() {
        return duree;
    }

    public void setDuree(Duration duree) {
        this.duree = duree;
    }
    public Saut getSuivant() {
        return suivant;
    }

    public void setSuivant(Saut suivant) {
        this.suivant = suivant;
    }

    public void decaler(Duration T) {
        this.duree = this.duree.plus(T);
    }

    public void decaler(Saut s) {
        this.duree = this.duree.plus(s.getDuree());
    }

    
}