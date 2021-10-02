package mining;

import java.io.Serializable;
import data.Attribute;

/**
 * Classe astratta che modella un generico item (coppia attributo-valore, per
 * esempio Outlook="Sunny")
 */
public abstract class Item implements Serializable {

    private Attribute attribute;
    private Object value;

    /**
     * Inizializza i valori dei membri attributi con i parametri passati come
     * argomento al costruttore
     * 
     * @param attribute
     * @param value
     */
    public Item(Attribute attribute, Object value) {

        this.attribute = attribute;
        this.value = value;
    }

    /**
     * Restituisce il membro attribute
     * 
     * @return Attribute
     */
    public Attribute getAttribute() {

        return attribute;
    }

    /**
     * Restituisce il membro value
     * 
     * @return Object
     */
    public Object getValue() {

        return value;
    }

    /**
     * @param value
     * @return boolean
     */
    abstract boolean checkItemCondition(Object value);

    /**
     * Restituisce una stringa nella forma <attribute>=<value>
     * 
     * @return String
     */
    public String toString() {

        return "(" + this.attribute.toString() + "=" + this.value.toString() + ")";
    }
}
