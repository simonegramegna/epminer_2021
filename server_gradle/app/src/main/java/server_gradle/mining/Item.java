package server_gradle.mining;
import java.io.Serializable;

import server_gradle.data.Attribute;

public abstract class Item implements Serializable{

    private Attribute attribute;
    private Object value;

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

    public String toString() {
        return "(" + this.attribute.toString() + "=" + this.value.toString() + ")";
    }
    
    
}
