package data;

import java.io.IOException;

/**
 * Definisce la classe DiscreteAttribute che estende la classe Attribute e
 * modella un attributo discreto rappresentando l'insieme di valori distinti del
 * relativo dominio.
 *
 */
public class DiscreteAttribute extends Attribute {

    private static final long serialVersionUID = 3987937802944916562L;

    private String values[];

    /**
     * Invoca il costruttore della classe madre e avvalora l'array values[ ] con i
     * valori discreti in input.
     * 
     * @param name
     * @param index
     * @param values
     */
    public DiscreteAttribute(String name, int index, String values[]) {
        super(name, index);
        this.values = values;
    }

    /**
     * Restituisce la cardinalita' del membro values
     * 
     * @return int
     */
    public int getNumberOfDistinctValues() {

        return values.length;
    }

    /**
     * Restituisce il valore in posizione i del membro values
     * 
     * @param index
     * @return String
     */
    public String getValue(int index) {

        return values[index];
    }
}
