package aeroport;

/**
 * Classe représentant le numéro d'un vol
 * Implémente Comparable pour permettre de trier les numéros de vol
 */
public class NumeroVol implements Comparable<NumeroVol>{

    private String numero;
    
    /**
     * Constructeur pour créer un nouveau numéro de vol
     * 
     * @param numero La chaîne de caractères représentant le numéro de vol
     */
    public NumeroVol(String numero) {
        this.numero = numero;
    }
    
    /**
     * Obtient le numéro de vol
     * 
     * @return La chaîne de caractères représentant le numéro de vol
     */
    public String getNumero() {
        return numero;
    }
    
    /**
     * Convertit le numéro de vol en chaîne de caractères
     * 
     * @return La représentation sous forme de chaîne du numéro de vol
     */
    @Override
    public String toString() {
        return numero;
    }

    /**
     * Compare ce numéro de vol avec un autre pour déterminer l'ordre
     * Implémente l'interface Comparable
     * 
     * @param other Le numéro de vol à comparer avec celui-ci
     * @return un entier négatif, zéro ou positif si ce numéro est 
     *         inférieur, égal ou supérieur à l'autre
     */
    @Override
    public int compareTo(NumeroVol other) {
        return this.numero.compareTo(other.numero);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        NumeroVol other = (NumeroVol) obj;
        return numero.equals(other.numero);
    }
    
    @Override
    public int hashCode() {
        return numero != null ? numero.hashCode() : 0;
    }

}