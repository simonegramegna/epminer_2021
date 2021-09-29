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

import data.*;

public class FrequentPatternMiner implements Serializable {
    
    private LinkedList<FrequentPattern> outputFP = new LinkedList<FrequentPattern>();

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

                    if (fp.getSupport() >= minSup) { // 1-FP CANDIDATE
                        fpQueue.enqueue(fp);
                        // System.out.println(fp);
                        outputFP.add(fp);
                    }
                }
            }
        }
        outputFP = expandFrequentPatterns(data, minSup, fpQueue, outputFP);
        this.sort();
    }

    private LinkedList<FrequentPattern> expandFrequentPatterns(Data data, float minSup, Queue<FrequentPattern> fpQueue,
            LinkedList<FrequentPattern> outputFP) throws EmptyQueueException {

        while (!fpQueue.isEmpty()) {

            Object first_element = fpQueue.first();

            if (first_element instanceof FrequentPattern) {

                FrequentPattern fp = (FrequentPattern) fpQueue.first(); // fp to be refined
                fpQueue.dequeue();

                for (int i = 0; i < data.getNumberOfAttributes(); i++) {

                    boolean found = false;
                    for (int j = 0; j < fp.getPatternLength(); j++) {
                        /* the new item should involve an attribute different
                         * form attributes already involved into the items of fp
                         */
                        if (fp.getItem(j).getAttribute().equals(data.getAttribute(i))) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) // data.getAttribute(i) is not involve into an item of fp
                    {
                        if (data.getAttribute(i) instanceof DiscreteAttribute) {
                            for (int j = 0; j < ((DiscreteAttribute) data.getAttribute(i))
                                    .getNumberOfDistinctValues(); j++) {

                                DiscreteItem item = new DiscreteItem((DiscreteAttribute) data.getAttribute(i),
                                        ((DiscreteAttribute) (data.getAttribute(i))).getValue(j));

                                //System.out.println(item);

                                FrequentPattern newFP = refineFrequentPattern(fp, item); // generate refinement
                                newFP.setSupport(newFP.computeSupport(data));

                                if (newFP.getSupport() >= minSup) {
                                    fpQueue.enqueue(newFP);
                                    // System.out.println(newFP);
                                    outputFP.add(newFP);
                                }
                            }
                        }
                    }
                }
            }
        }
        return outputFP;
    }

    public FrequentPattern refineFrequentPattern(FrequentPattern FP, Item item) {
        FrequentPattern newfp = new FrequentPattern(FP);
        newfp.addItem(item);
        return newfp;
    }

    public String toString() {
        String value = "";

        for (FrequentPattern fp : outputFP) {

            value += fp.toString() + "\n";
        }
        return value;
    }

    // getter che non sta nel pdf;
    public LinkedList<FrequentPattern> getOutputFP() {

        return outputFP;
    }

    private void sort() {

        Collections.sort(outputFP);
    }

    public void salva(String nomeFile) throws FileNotFoundException, IOException {

        FileOutputStream out = new FileOutputStream(nomeFile);
        ObjectOutputStream s = new ObjectOutputStream(out);
        s.writeObject(this);
    }

    public static FrequentPatternMiner carica(String nomeFile)
            throws FileNotFoundException, IOException, ClassNotFoundException {

        FileInputStream in = new FileInputStream(nomeFile);
        ObjectInputStream o = new ObjectInputStream(in);
        FrequentPatternMiner miner = (FrequentPatternMiner) o.readObject();
        return miner;
    }
}
