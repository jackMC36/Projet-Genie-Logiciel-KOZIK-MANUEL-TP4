package aeroport;

import java.util.ArrayList;
import java.util.Collection;


public class Compagnie {

    private String name;

    private String prefix;

    private Collection<Vol> vols = new ArrayList<>();

    private GenerateurNumeroVol gen;


    public Compagnie(String nom, String prefix) {
        this.name = nom;
        this.prefix = prefix;
        this.gen.setPrefix(prefix);

    }

    public Compagnie(){}

    public String getPrefix(){
        return this.prefix;
    }

    public void setPrefix(String prefix){
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Vol> getVols() {
        return vols;
    }

    public void setVols(Collection<Vol> vols) {
        this.vols = vols;
    }

    /**
     * Ajoute un vol à la collection de vols de cette compagnie
     * Permet d'associer un vol à cette compagnie aérienne
     * 
     * @param vol Le vol à ajouter à la collection de la compagnie
     */
    public void addVol(Vol vol){
        this.vols.add(vol);
    }

    /**
     * Retire un vol de la collection de vols de cette compagnie
     * Permet de dissocier un vol de cette compagnie aérienne
     * 
     * @param vol Le vol à retirer de la collection de la compagnie
     */
    public void removeVol(Vol vol){
        this.vols.remove(vol);
    }
}
