package mining;

import data.ContinuousAttribute;

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

    public String toString() {

        String value = "";
        value += this.getAttribute().getName() + " in " + this.getValue().toString();
        return value;
    }
}
