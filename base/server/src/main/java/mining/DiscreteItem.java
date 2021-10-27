package mining;

import data.DiscreteAttribute;

/**
 * DiscreteItem che estende la classe Item e rappresenta la coppia <Attributo
 * discreto - valore discreto> (Outlook=[Sunny])
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
     * estremi dell'intervallo associato allo item in oggetto
     * 
     * @param value
     */
    boolean checkItemCondition(Object value) {

        return value.equals(this.getValue());
    }
}
