public class DiscreteItem extends Item {

    public DiscreteItem(Attribute attribute, Object value) {

        super(attribute, value);
    }

    public boolean checkItemCondition(Object value) {
        
        return value.equals(this.getValue());
    }

}