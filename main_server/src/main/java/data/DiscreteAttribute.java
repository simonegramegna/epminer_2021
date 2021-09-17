package data;

import java.io.IOException;

public class DiscreteAttribute extends Attribute {

	private static final long serialVersionUID = 3987937802944916562L;
	
	private String values[];

    public DiscreteAttribute(String name, int index, String values[]) {

        super(name, index);
        this.values = values;
    }

    public int getNumberOfDistinctValues() {

        return values.length;
    }

    public String getValue(int index) {

        return values[index];
    }
}
