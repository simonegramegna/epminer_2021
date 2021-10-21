public class EmergingPattern extends FrequentPattern {
    
    private float growrate;
    
    public EmergingPattern(FrequentPattern fp, float growrate) {

        super(fp);
        this.growrate = growrate;
    }

    public float getGrowrate() {
        return growrate;
    }

    public String toString() {

        String value = super.toString();
        value += " [" + this.growrate + "]";
        return value;
    }
    
    
}