package mining;

import java.io.Serializable;

/**
 * Classe interval che definisce un intervallo reale
 */
class Interval implements Serializable {

    private float inf;
    private float sup;

    /**
     * Avvalora i due attributi inf e sup con i parametri del costruttore
     * 
     * @param inf
     * @param sup
     */
    Interval(float inf, float sup) {

        this.inf = inf;
        this.sup = sup;
    }

    /**
     * Restituisce inf
     * 
     * @return float
     */
    float getInf() {

        return inf;
    }

    /**
     * Avvalora inf con il parametro passato
     * 
     * @param inf
     */
    void setInf(float inf) {

        this.inf = inf;
    }

    /**
     * Restituisce sup
     * 
     * @return float
     */
    float getSup() {

        return sup;
    }

    /**
     * Avvalora sup con il paramtero passato
     * 
     * @param sup
     */
    void setSup(float sup) {

        this.sup = sup;
    }

    /**
     * Verifica se il valore passato come parametro e' contenuto nell'intervallo
     * 
     * @param value
     * @return boolean
     */
    boolean checkValueInclusion(float value) {

        return (value >= inf) && (value < sup);
    }

    /**
     * rappresenta in una stringa gli estremi dell'intervallo e restituisce tale
     * stringa
     * 
     * @return String
     */
    public String toString() {

        return "[" + inf + "," + sup + "[";
    }
}