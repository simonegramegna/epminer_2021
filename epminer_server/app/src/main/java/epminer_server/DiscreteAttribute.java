package epminer_server;

public class DiscreteAttribute extends Attribute {

    String[] values;

    public DiscreteAttribute(String name, int index, String[] values) {

        super(name, index);
        this.values = values;
    }

    int getNumberOfDistinctValues() {

        return values.length;
    }

    String getValue(int index) {

        return values[index];
    }

}
