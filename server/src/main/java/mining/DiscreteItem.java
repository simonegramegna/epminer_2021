package mining;

import data.DiscreteAttribute;

/**
 * Estende la classe astratta Item e modella la coppia <Attributo continuo -
 * Intervallo di valori> (Temperature in [10;30.31[)
 */
public class DiscreteItem extends Item {

    private static final long serialVersionUID = 2274848088367829499L;

    /**
     * chiama il costruttore della superclasse passandogli come argomenti attribute
     * e value.
     * 
     * @param attribute
     * @param value
     */
    public DiscreteItem(DiscreteAttribute attribute, String value) {

        super(attribute, value);
    }

    /**
     * verifica che il parametro value rappresenti un numero reale incluso tra gli
     * estremi dell’intervallo associato allo item in oggetto
     * 
     * @param value
     */
    boolean checkItemCondition(Object value) {

        return value.equals(this.getValue());
    }
}
