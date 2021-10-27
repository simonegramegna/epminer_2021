package mining;

import java.io.Serializable;

/**
 * Estende FrequenPattern e modella un pattern emergente
 */
public class EmergingPattern extends FrequentPattern implements Serializable {

    private float growrate;

    /**
     * Chiama il costruttore della superclasse passandogli fp e inizializza il
     * membro growrate con l'argomento del costruttore
     * 
     * @param fp
     * @param growrate
     */
    public EmergingPattern(FrequentPattern fp, float growrate) {

        super(fp);
        this.growrate = growrate;
    }

    /**
     * Restituisce il valore del membro growrate
     * 
     * @return float
     */
    public float getGrowrate() {

        return growrate;
    }

    /**
     * Si crea e restituisce la stringa che rappresenta il pattern,il suo supporto e
     * il suo growrate
     */
    public String toString() {

        String value = super.toString();
        value += " [" + this.growrate + "]";
        return value;
    }
}