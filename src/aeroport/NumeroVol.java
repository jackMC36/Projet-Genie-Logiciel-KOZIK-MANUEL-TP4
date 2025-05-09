package aeroport;

public class NumeroVol implements Comparable<NumeroVol>{
    private String numero;
    
    public NumeroVol(String numero) {
        this.numero = numero;
    }
    
    public String getNumero() {
        return numero;
    }
    
    @Override
    public String toString() {
        return numero;
    }

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