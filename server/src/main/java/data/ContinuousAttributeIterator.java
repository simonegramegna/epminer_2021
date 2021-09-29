package data;

import java.util.Iterator;

/**
 * classe realizza l’iteratore che itera sugli elementi della sequenza 
 * composta da numValues valori reali equidistanti tra di loro (cut points) 
 * compresi tra min e max ottenuti per mezzo di discretizzazione. 
 * La classe implementa i metodi della interfaccia generica Iterator<T> tipizzata con Float
 */
public class ContinuousAttributeIterator implements Iterator<Float> {

    private float min;
    private float max;
    private int j = 0;
    private int numValues;

    /**
     * 
     * @param min
     * @param max
     * @param numValues
     */
    ContinuousAttributeIterator(float min, float max, int numValues) {

        this.min = min;
        this.max = max;
        this.numValues = numValues;
    }

    /**
     * @return boolean
     */
    @Override
    public boolean hasNext() {

        return (j <= numValues);
    }
    
    /**
     * @return Float
     */
    public Float next() {

        j++;
        return min + ((max - min) / numValues) * (j - 1);
    }

    public void remove() {

    }
}
