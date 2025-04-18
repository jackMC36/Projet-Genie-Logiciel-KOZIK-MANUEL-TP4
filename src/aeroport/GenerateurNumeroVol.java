package aeroport;

public class GenerateurNumeroVol {
    private String prefix;
    private long compteur = 0;

    //constructeur
    public generateurNumeroVol(String prefix){
        this.prefix = prefix;
    }

    public void setPrefix(String prefix){
        this.prefix = prefix;
    }

    protected NumeroVol generate(){
        this.compteur+=1;
        return prefix+this.compteur;
    }

}