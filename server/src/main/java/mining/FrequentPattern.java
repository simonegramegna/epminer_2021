package mining;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

import data.Data;
import data.DiscreteAttribute;

public class FrequentPattern implements Iterable<Item>, Comparable<FrequentPattern>, Serializable {

    private static final long serialVersionUID = -3212928836144066570L;
    /**
     * @uml.property name="fp"
     * @uml.associationEnd multiplicity="(0 -1)"
     */
    private LinkedList<Item> fp;
    /**
     * @uml.property name="support"
     */
    private float support;

    public FrequentPattern() {
        fp = new LinkedList<Item>();
    }

    // costrutore per copia
    public FrequentPattern(FrequentPattern FP) {

        int length = FP.getPatternLength();
        fp = new LinkedList<Item>();

        for (int i = 0; i < length; i++) {

            fp.add(FP.getItem(i));
        }
        support = FP.getSupport();
    }

    // aggiunge un nuovo item al pattern
    public void addItem(Item item) {

        fp.add(item);
    }

    public String toString() {

        String value = "";

        for (int i = 0; i < fp.size() - 1; i++) {

            value += fp.get(i) + " AND ";
        }
        if (fp.size() > 0) {

            value += fp.getLast();
            value += "[" + support + "]";
        }
        return value;
    }

    // Aggiorna il supporto
    public float computeSupport(Data data) {

        int suppCount = 0;
        // indice esempio
        for (int i = 0; i < data.getNumberOfExamples(); i++) {
            // indice item
            boolean isSupporting = true;

            for (int j = 0; j < this.getPatternLength(); j++) {
                // DiscreteItem
                DiscreteItem item = (DiscreteItem) this.getItem(j);
                DiscreteAttribute attribute = (DiscreteAttribute) item.getAttribute();
                // Extract the example value
                Object valueInExample = data.getAttributeValue(i, attribute.getIndex());

                if (!item.checkItemCondition(valueInExample)) {

                    isSupporting = false;
                    break; // the ith example does not satisfy fp
                }
            }
            if (isSupporting) {
                suppCount++;
            }
        }
        return ((float) suppCount) / (data.getNumberOfExamples());
    }

    public Item getItem(int posizione) {

        return this.fp.get(posizione);
    }

    public float getSupport() {

        return this.support;
    }

    public int getPatternLength() {

        return this.fp.size();
    }

    void setSupport(float support) {
        this.support = support;
    }

    @Override
    public Iterator<Item> iterator() {

        return fp.iterator();
    }

    @Override
    public int compareTo(FrequentPattern o) {

        if (this.support > o.support) {
            return 1;

        } else if (this.support < o.support) {
            return -1;

        } else {
            return 0;
        }
    }
}
