package epminer_server;

public abstract class Attribute {

    protected String name;
    protected int index;

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
        return "Attribute [index=" + index + ", name=" + name + "]";
    }

    

    

}