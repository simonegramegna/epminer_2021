public class FrequentPattern {

    /**
     * @uml.property name="fp"
     * @uml.associationEnd multiplicity="(0 -1)"
     */
    private Item fp[];
    /**
     * @uml.property name="support"
     */
    private float support;

    FrequentPattern() {
        fp = new Item[0];
    }

    // costrutore per copia
    FrequentPattern(FrequentPattern FP) {

        int length = FP.getPatternLength();
        fp = new Item[length];

        for (int i = 0; i < length; i++) {

            fp[i] = FP.getItem(i);
        }
        support = FP.getSupport();
    }

    // aggiunge un nuovo item al pattern
    void addItem(Item item) {

        int length = fp.length;

        Item temp[] = new Item[length + 1];
        System.arraycopy(fp, 0, temp, 0, length);
        temp[length] = item;
        fp = temp;

    }

    public String toString() {

        String value = "";

        for (int i = 0; i < fp.length - 1; i++) {

            value += fp[i] + " AND ";
        }

        if (fp.length > 0) {

            value += fp[fp.length - 1];
            value += "[" + support + "]";
        }

        return value;
    }

    // Aggiorna il supporto
    float computeSupport(Data data) {
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

    Item getItem(int index) {

        return fp[index];
    }

    float getSupport() {

        return support;
    }

    int getPatternLength() {
        
        return fp.length;
    }

}
