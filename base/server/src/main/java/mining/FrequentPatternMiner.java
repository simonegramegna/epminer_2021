package mining;

import utility.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Iterator;

import data.*;

/**
 * Classe che che include i metodi per ù la scoperta di pattern frequenti con
 * Algoritmo APRIORI
 */
public class FrequentPatternMiner implements Serializable {

    private LinkedList<FrequentPattern> outputFP = new LinkedList<FrequentPattern>();

    /**
     * Costruttore che genera tutti i pattern k=1 frequenti e per ognuno di questi
     * genera quelli con k>1 richiamand expandFrequentPatterns()
     * 
     * @param data
     * @param minSup
     * @throws EmptySetException
     * @throws EmptyQueueException
     */
    public FrequentPatternMiner(Data data, float minSup) throws EmptySetException, EmptyQueueException {

        if (data.getNumberOfAttributes() == 0) {

            throw new EmptySetException();
        }
        Queue<FrequentPattern> fpQueue = new Queue<FrequentPattern>();

        for (int i = 0; i < data.getNumberOfAttributes(); i++) {

            Attribute currentAttribute = data.getAttribute(i);

            if (currentAttribute instanceof DiscreteAttribute) {
                for (int j = 0; j < ((DiscreteAttribute) currentAttribute).getNumberOfDistinctValues(); j++) {

                    DiscreteItem item = new DiscreteItem((DiscreteAttribute) currentAttribute,
                            ((DiscreteAttribute) currentAttribute).getValue(j));

                    FrequentPattern fp = new FrequentPattern();
                    fp.addItem(item);
                    fp.setSupport(fp.computeSupport(data));

                    if (fp.getSupport() >= minSup) { 

                        fpQueue.enqueue(fp);
                        outputFP.add(fp);
                    }
                }
            }else if(currentAttribute instanceof  ContinuousAttribute){

                ContinuousAttribute continuousCurrentAttribute = (ContinuousAttribute) currentAttribute;
                Iterator<Float> contIterator = continuousCurrentAttribute.iterator();

                if(contIterator.hasNext()){

                    float a = contIterator.next();

                    while(contIterator.hasNext()){

                        float b = contIterator.next();

                        if(b == continuousCurrentAttribute.getMax()){

                            b = continuousCurrentAttribute.getMax() + 0.0001f;
                        }
                        ContinuousItem item = new ContinuousItem(continuousCurrentAttribute, new Interval(a,b));
                        FrequentPattern fp = new FrequentPattern();

                        fp.addItem(item);
                        fp.setSupport(fp.computeSupport(data));

                        if(fp.getSupport() >= minSup){

                            fpQueue.enqueue(fp);
                            outputFP.add(fp);
                        }
                        a = b;
                    }
                }
            }
        }
        outputFP = expandFrequentPatterns(data, minSup, fpQueue, outputFP);
        this.sort();
    }

    /**
     * Finché fpQueue contiene elementi, si estrae un elemento dalla coda fpQueue,
     * si generano i raffinamenti per questo (aggiungendo un nuovo item non
     * incluso). Per ogni raffinamento si verifica se è frequente e, in caso
     * affermativo, lo si aggiunge sia ad fpQueue sia ad outputFP
     * 
     * @param data
     * @param minSup
     * @param fpQueue
     * @param outputFP
     * @return LinkedList<FrequentPattern>
     * @throws EmptyQueueException
     */
    private LinkedList<FrequentPattern> expandFrequentPatterns(Data data, float minSup, Queue<FrequentPattern> fpQueue,
            LinkedList<FrequentPattern> outputFP) throws EmptyQueueException {

        while (!fpQueue.isEmpty()) {

            Object first_element = fpQueue.first();

            if (first_element instanceof FrequentPattern) {

                FrequentPattern fp = (FrequentPattern) fpQueue.first();
                fpQueue.dequeue();

                for (int i = 0; i < data.getNumberOfAttributes(); i++) {

                    boolean found = false;
                    for (int j = 0; j < fp.getPatternLength(); j++) {

                        if (fp.getItem(j).getAttribute().equals(data.getAttribute(i))) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        if (data.getAttribute(i) instanceof DiscreteAttribute) {
                            for (int j = 0; j < ((DiscreteAttribute) data.getAttribute(i))
                                    .getNumberOfDistinctValues(); j++) {

                                DiscreteItem item = new DiscreteItem((DiscreteAttribute) data.getAttribute(i),
                                        ((DiscreteAttribute) (data.getAttribute(i))).getValue(j));

                                FrequentPattern newFP = refineFrequentPattern(fp, item);
                                newFP.setSupport(newFP.computeSupport(data));

                                if (newFP.getSupport() >= minSup) {

                                    fpQueue.enqueue(newFP);
                                    outputFP.add(newFP);
                                }
                            }
                        }else if(data.getAttribute(i) instanceof  ContinuousAttribute){

                            ContinuousAttribute currentAttribute = (ContinuousAttribute) data.getAttribute(i);
                            Iterator<Float> continuousIterator =  currentAttribute.iterator();

                            if(continuousIterator.hasNext()){

                                float a = continuousIterator.next();

                                while(continuousIterator.hasNext()){

                                    float b = continuousIterator.next();

                                    if(b == currentAttribute.getMax()){

                                        b = currentAttribute.getMax() + 0.0001f;
                                    }
                                    ContinuousItem item = new ContinuousItem(currentAttribute, new Interval(a, b));
                                    FrequentPattern newFP = refineFrequentPattern(fp, item); //generate refinement
                                    newFP.setSupport(newFP.computeSupport(data));
                                    if (newFP.getSupport() >= minSup) {
                                        fpQueue.enqueue(newFP);
                                        outputFP.add(newFP);
                                    }
                                    a = b;

                                }
                            }
                        }
                    }
                }
            }
        }
        return outputFP;
    }

    /**
     * Crea un nuovo pattern a cui aggiunge tutti gli item di FP e il parametro item
     * 
     * @param FP
     * @param item
     * @return FrequentPattern
     */
    public FrequentPattern refineFrequentPattern(FrequentPattern FP, Item item) {

        FrequentPattern newfp = new FrequentPattern(FP);
        newfp.addItem(item);
        return newfp;
    }

    /**
     * Scandisce OutputFp al fine di concatenare in un'unica stringa i pattern
     * frequenti letti
     * 
     * @return String
     */
    public String toString() {
        String value = "";

        for (FrequentPattern fp : outputFP) {

            value += fp.toString() + "\n";
        }
        return value;
    }

    /**
     * Restituisce il membro outputFP
     * 
     * @return LinkedList<FrequentPattern>
     */
    public LinkedList<FrequentPattern> getOutputFP() {

        return outputFP;
    }

    private void sort() {

        Collections.sort(outputFP);
    }

    /**
     * salva un istanza del FrequentPatternMiner
     * 
     * @param nomeFile
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void salva(String nomeFile) throws FileNotFoundException, IOException {

        FileOutputStream out = new FileOutputStream(nomeFile);
        ObjectOutputStream s = new ObjectOutputStream(out);
        s.writeObject(this);

        s.close();
        out.close();
    }

    /**
     * carica un istanza del FrequentPatternMiner
     * 
     * @param nomeFile
     * @return FrequentPatternMiner
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static FrequentPatternMiner carica(String nomeFile)
            throws FileNotFoundException, IOException, ClassNotFoundException {

        FileInputStream in = new FileInputStream(nomeFile);
        ObjectInputStream o = new ObjectInputStream(in);
        FrequentPatternMiner miner = (FrequentPatternMiner) o.readObject();

        o.close();
        in.close();

        return miner;
    }
}
