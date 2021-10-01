package utility;

import java.util.Comparator;
import mining.EmergingPattern;
/**
 * Tramite l'implementazione di Comparator, vengono comparati due emerging pattern.
 * Se il primo è minore del secondo -1, se il primo è maggiore del secondo 1, altrimenti 0
 */
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
