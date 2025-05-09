package aeroport;

import java.time.Duration;
import java.time.ZonedDateTime;


public class Etape{

    private ZonedDateTime date;

    private Aeroport aeroport;

    public Etape(){

    }

    protected Etape(ZonedDateTime date){
        this.date = date;
    }

    public void decaler(Duration T) {
        this.date = this.date.plus(T);
    }

    public Aeroport getAeroport(){
        return this.aeroport;
    }
}