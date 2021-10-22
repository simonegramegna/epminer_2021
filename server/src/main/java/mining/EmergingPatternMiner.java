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
 * modella la scoperta di emerging pattern a partire dalla lista di frequent
 * pattern
 */
public class EmergingPatternMiner implements Iterable<EmergingPattern>, Serializable {

    private LinkedList<EmergingPattern> epList;

    /**
     * Si scandiscono tutti i frequent pattern in fpList , per ognuno di essi si
     * calcola il grow rate usando dataBackground e se tale valore e' maggiore
     * uguale di minG allora il pattern e' aggiunto ad epList
     * 
     * @param dataBackGround
     * @param fpList
     * @param minG
     * @throws EmptySetException
     */
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

    /**
     * Si ottiene da fp il suo supporto relativo al dataset target. Si calcola il
     * supporto di fp relativo al dataset di background. Si calcola il grow rate
     * come rapporto dei due supporti.
     * @param dataBackground
     * @param fp
     * @return float
     */
    private float computeGrowRate(Data dataBackground, FrequentPattern fp) {

        float growrate;
        float suppbackground = fp.computeSupport(dataBackground);
        float suppdataset = fp.getSupport();
        growrate = suppdataset / suppbackground;
        return growrate;
    }

    /**
     * Verifica che il gorw rate di fp sia maggiore di minGR.In caso affermativo
     * crea un oggetto EmemrgingPattern da fp.
     * @param dataBackground
     * @param fp
     * @param minGR
     * @return
     * @throws EmergingPatternException
     */
    private EmergingPattern computeEmergingPattern(Data dataBackground, FrequentPattern fp, float minGR)
            throws EmergingPatternException {

        float growrate = this.computeGrowRate(dataBackground, fp);

        if (growrate >= minGR) {

            EmergingPattern ep = new EmergingPattern(fp, growrate);
            return ep;

        } else {

            throw new EmergingPatternException();
        }
    }

    /**
     * Scandisce epList al fine di concatenare in un'unica stringa le stringhe
     * rappresentati i pattern emergenti letti
     */
    public String toString() {

        String value = "";

        for (EmergingPattern ep : epList) {
            value += ep.toString() + "\n";
        }
        return value;
    }

    /**
     * iteratore di EmergingPattern
     * 
     * @return Iterator
     */
    @Override
    public Iterator<EmergingPattern> iterator() {

        return epList.iterator();
    }

    /**
     * sort mette in ordine la lista
     */
    private void sort() {

        Collections.sort(epList, new ComparatorGrowRate());
    }

    /**
     * salva l'EmergingPatternMiner
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
     * carica l'EmergingPatternMiner
     * 
     * @param nomeFile
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static EmergingPatternMiner carica(String nomeFile)
            throws FileNotFoundException, IOException, ClassNotFoundException {

        FileInputStream in = new FileInputStream(nomeFile);
        ObjectInputStream o = new ObjectInputStream(in);
        EmergingPatternMiner miner = (EmergingPatternMiner) o.readObject();

        o.close();
        in.close();

        return miner;
    }
}