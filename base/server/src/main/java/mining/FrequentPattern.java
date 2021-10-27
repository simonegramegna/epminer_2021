package mining;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

import data.ContinuousAttribute;
import data.Data;
import data.DiscreteAttribute;

/**
 * rappresenta un itemset (o pattern) frequente
 */
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

    /**
     * costruttore che alloca fp come array di dimensione 0
     */
    public FrequentPattern() {

        fp = new LinkedList<Item>();
    }

    /**
     * costruttore che alloca fp e support come copia del frequent pattern FP
     * passato
     * 
     * @param FP
     */
    public FrequentPattern(FrequentPattern FP) {

        int length = FP.getPatternLength();
        fp = new LinkedList<Item>();

        for (int i = 0; i < length; i++) {

            fp.add(FP.getItem(i));
        }
        support = FP.getSupport();
    }

    /**
     * si estende la dimensione di fp di 1 e si inserisce in ultima posizione
     * l'argomento della procedura
     * 
     * @param item
     */
    public void addItem(Item item) {

        fp.add(item);
    }

    /**
     * si scandisce fp al fine di concatenare in una stringa la rappresentazione
     * degli item; alla fine si concatena il supporto
     */
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

    /**
     * calcola il supporto del pattern rappresentato dall'oggetto this rispetto al
     * dataset data passato come argomento
     * 
     * @param data
     * @return float
     */
    public float computeSupport(Data data) {

        int suppCount = 0;
        // indice esempio
        for (int i = 0; i < data.getNumberOfExamples(); i++) {
            // indice item
            boolean isSupporting = true;

            for (int j = 0; j < this.getPatternLength(); j++) {

                if(this.getItem(j) instanceof DiscreteItem){

                    // DiscreteItem
                    DiscreteItem item = (DiscreteItem) this.getItem(j);
                    DiscreteAttribute attribute = (DiscreteAttribute) item.getAttribute();

                    // Extract the example value
                    Object valueInExample = data.getAttributeValue(i, attribute.getIndex());

                    if (!item.checkItemCondition(valueInExample)) {

                        isSupporting = false;
                        break; // the ith example does not satisfy fp
                    }
                }else if(this.getItem(j) instanceof ContinuousItem){

                    ContinuousItem item = (ContinuousItem) this.getItem(j);
                    ContinuousAttribute attribute = (ContinuousAttribute) item.getAttribute();

                    Object valueInExample = data.getAttributeValue(i, attribute.getIndex());

                    if (!item.checkItemCondition(valueInExample)) {

                        isSupporting = false;
                        break; //the ith example does not satisfy fp
                    }
                }
            }
            if (isSupporting) {
                suppCount++;
            }
        }
        return ((float) suppCount) / (data.getNumberOfExamples());
    }

    /**
     * restituisce l'item in posizione index di fp
     * 
     * @param posizione
     * @return Item
     */
    public Item getItem(int posizione) {

        return this.fp.get(posizione);
    }

    /**
     * restituisce il membro support
     * 
     * @return float
     */
    public float getSupport() {

        return this.support;
    }

    /**
     * restituisce la dimensione (lunghezza) di fp
     * 
     * @return int
     */
    public int getPatternLength() {

        return this.fp.size();
    }

    /**
     * assegna al membro support il parametro della procedura
     * 
     * @param support
     */
    void setSupport(float support) {

        this.support = support;
    }

    /**
     * iteraore per gli item
     */
    @Override
    public Iterator<Item> iterator() {

        return fp.iterator();
    }

    /**
     * ritorna 1 se il supporto corrente e' maggiore del supporto passato in input,
     * ritorna -1 se il supporto corrente e' minore del supporto passato in input,
     * altrimenti 0
     * 
     * @return int
     */
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
