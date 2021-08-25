package utility;

import java.util.Comparator;
import mining.EmergingPattern;

public class ComparatorGrowRate implements Comparator<EmergingPattern> {

    @Override
    public int compare(EmergingPattern o1, EmergingPattern o2) {

        if (o1.getGrowrate() < o2.getGrowrate()) {

            return -1;

        } else if (o1.getGrowrate() > o2.getGrowrate()) {

            return 1;

        } else {
            return 0;
        }
    }

}
