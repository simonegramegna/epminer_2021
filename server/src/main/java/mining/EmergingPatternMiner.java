package mining;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import data.*;
import utility.ComparatorGrowRate;

/**
 * 
 */
public class EmergingPatternMiner implements Iterable<EmergingPattern>, Serializable {

    private LinkedList<EmergingPattern> epList;

    public EmergingPatternMiner(Data dataBackGround, FrequentPatternMiner fpList, float minG) throws EmptySetException {

        super();
        if (fpList.getOutputFP().isEmpty()) {

            throw new EmptySetException();
        }

        this.epList = new LinkedList<EmergingPattern>();
        LinkedList<FrequentPattern> list = fpList.getOutputFP();

        for (FrequentPattern fp : list) {

            EmergingPattern ep = null;

            try {
                ep = this.computeEmergingPattern(dataBackGround, fp, minG);
            } catch (EmergingPatternException e) {
                ;
            }

            if (ep != null) {
                
                epList.add(ep);
            }
        }
        this.sort();
    }

    private float computeGrowRate(Data dataBackground, FrequentPattern fp) {

        float growrate;
        float suppbackground = fp.computeSupport(dataBackground);
        float suppdataset = fp.getSupport();
        growrate = suppdataset / suppbackground;
        return growrate;
    }

    private EmergingPattern computeEmergingPattern(Data dataBackground, FrequentPattern fp, float minGR)
            throws EmergingPatternException {

        float growrate = this.computeGrowRate(dataBackground, fp);

        if (growrate > minGR) {

            EmergingPattern ep = new EmergingPattern(fp, growrate);
            return ep;

        } else {

            throw new EmergingPatternException();
        }
    }

    public String toString() {

        String value = "";

        for (EmergingPattern ep : epList) {
            value += ep.toString() + "\n";
        }
        return value;
    }

    @Override
    public Iterator<EmergingPattern> iterator() {

        return epList.iterator();
    }

    private void sort() {

        Collections.sort(epList, new ComparatorGrowRate());
    }

    public void salva(String nomeFile) throws FileNotFoundException, IOException {

        FileOutputStream out = new FileOutputStream(nomeFile);
        ObjectOutputStream s = new ObjectOutputStream(out);
        s.writeObject(this);
    }

    public static EmergingPatternMiner carica(String nomeFile)
            throws FileNotFoundException, IOException, ClassNotFoundException {

        FileInputStream in = new FileInputStream(nomeFile);
        ObjectInputStream o = new ObjectInputStream(in);
        EmergingPatternMiner miner = (EmergingPatternMiner) o.readObject();

        return miner;
    }
}