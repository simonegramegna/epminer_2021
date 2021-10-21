public abstract class Item {

    public Attribute attribute;
    public Object value;

    public Item(Attribute attribute, Object value) {

        this.attribute = attribute;
        this.value = value;
    }

    public Attribute getAttribute() {

        return attribute;
    }

    public Object getValue() {

        return value;
    }

    abstract boolean checkItemCondition(Object value);

    @Override
    public String toString() {

        return "<" + attribute + ">=<" + value + ">";
    }
}