package mining;

import data.ContinuousAttribute;

/**
 * Estende la classe astratta Item e modella la coppia <Attributo continuo -
 * Intervallo di valori> (Temperature in [10;30.31[)
 *
 */
public class ContinuousItem extends Item {

    private static final long serialVersionUID = 7893147173498448187L;

    public ContinuousItem(ContinuousAttribute attribute, Interval value) {

        super(attribute, value);
    }

    /**
     * 
     * @param value
     * @return boolean
     */
    boolean checkItemCondition(Object value) {

        Interval interval = (Interval) this.getValue();
        Float _value = (Float) value;
        return interval.checkValueInclusion(_value);
    }

    /**
     * restituisce una stringa
     */
    public String toString() {

        String value = "";
        value += this.getAttribute().getName() + " in " + this.getValue().toString();
        return value;
    }
}
