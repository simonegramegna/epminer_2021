package data;

import java.io.IOException;
import java.io.Serializable;

public abstract class Attribute implements Serializable {

    private static final long serialVersionUID = -1011201825379454272L;
    private String name;
    private int index;

    public Attribute(String name, int index) {
        
        this.name = name;
        this.index = index;
    }

    public String getName() {

        return name;
    }

    public int getIndex() {

        return index;
    }

    @Override
    public String toString() {

        return name;
    }
}
