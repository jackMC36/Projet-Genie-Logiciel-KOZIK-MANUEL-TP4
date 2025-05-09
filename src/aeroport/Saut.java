package aeroport;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Saut{

    private Time duree;

    private Saut suivant;

    public Saut(){

    }

    protected Saut(Time duree){
        this.duree = duree;
    }

    public boolean precede(){
        if(this.suivant == null){
            return false;
        }
        return true;
    }

}