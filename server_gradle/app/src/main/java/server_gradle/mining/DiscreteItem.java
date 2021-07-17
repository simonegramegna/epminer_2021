package server_gradle.mining;

import server_gradle.data.DiscreteAttribute;

public class DiscreteItem extends Item {

	private static final long serialVersionUID = 2274848088367829499L;

	public DiscreteItem(DiscreteAttribute attribute, String value) {
        
        super(attribute, value);
    }

    boolean checkItemCondition(Object value) {

        return value.equals(this.getValue());
    }
 
}
