package server_gradle.data;

import java.io.IOException;
import java.util.Iterator;



public class ContinuousAttribute extends Attribute implements Iterable<Float> {

	private static final long serialVersionUID = -3818247460944913935L;
	private float max;
    private float min;

    public ContinuousAttribute(String name, int index, float min, float max) {
        
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

	@Override
	public Iterator<Float> iterator() {
		// TODO Auto-generated method stub
		return new ContinuousAttributeIterator(min, max, 5);
	}
	
}
