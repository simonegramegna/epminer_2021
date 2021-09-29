package data;

import java.io.IOException;
import java.util.Iterator;

/**
 * Definisce la classe ContinuousAttribute che estende la classe Attribute e modella 
un attributo continuo (numerico) rappresentandone il dominio [min,max]
 */
public class ContinuousAttribute extends Attribute implements Iterable<Float> {
    private static final long serialVersionUID = -3818247460944913935L;
    private float max;
    private float min;
/**
 * Invoca il costruttore della classe madre e avvalora i membri
 * @param name
 * @param index
 * @param min
 * @param float
 */
   public ContinuousAttribute(String name, int index, float min, float max) {

        super(name, index);
        this.max = max;
        this.min = min;
    }
/**
 *  Restituisce il valore del membro max
 * 
 * @return float
 */
    public float getMax() {
        
        return max;
    }
/**
 *  Restituisce il valore del membro min
 * @return float
 */
    public float getMin() {

        return min;
    }
    /**ritorna un oggetto iterator
     * @return ContinuosAttributeIterator
     */
    @Override
    public Iterator<Float> iterator() {
        return new ContinuousAttributeIterator(min, max, 5);
    }
}
