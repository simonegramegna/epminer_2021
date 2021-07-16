package epminer_server;

public class ContinuosAttribute extends Attribute {

    float min;
    float max;

    public ContinuosAttribute(String name, int index, float min, float max) {

        super(name, index);
        this.min = min;
        this.max = max;
    }

    public float getMin() {
        return min;
    }

    public float getMax() {
        return max;
    }

}
