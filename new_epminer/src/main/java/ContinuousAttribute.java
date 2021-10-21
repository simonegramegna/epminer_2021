public class ContinuousAttribute extends Attribute{

    private float max;
    private float min;

    public ContinuousAttribute(String name, int index, float max, float min) {
        
        super(name, index);
        this.max = max;
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public float getMin() {
        return min;
    }
}