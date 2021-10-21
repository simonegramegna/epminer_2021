public class DiscreteAttribute extends Attribute{

    private String values[];

    public DiscreteAttribute(String name, int index, String[] values) {
        
        super(name, index);
        this.values = values.clone();
    }

    public int getNumberOfDistinctValues(){

        return values.length;
    }
    
    public String getValue(int index){
    
        return values[index];
    }

}