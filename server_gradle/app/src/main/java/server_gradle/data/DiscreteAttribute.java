package server_gradle.data;

import java.io.IOException;

public class DiscreteAttribute extends Attribute {
	private static final long serialVersionUID = 3987937802944916562L;
	
	private String values[];

    public DiscreteAttribute(String name, int index, String values[]) {
        
        super(name, index);
        this.values = values;
    }

    public int getNumberOfDistinctValues() {
        return values.length;
    }

    public String getValue(int index) {
        return values[index];
    }
    
//    private void writeObject(java.io.ObjectOutputStream out)
//      	     throws IOException{
//    	out.writeInt(this.values.length);
//       	for(int i=0; i<values.length;i++) {
//       		out.writeUTF(this.values[i]);
//       	}
//      }
//      	 private void readObject(java.io.ObjectInputStream in) throws IOException {
//      		 int length=in.readInt();
//      		 String values[]=new String[length];
//      		for(int i=0; i<values.length;i++) {
//      			this.values[i]=in.readUTF();
//           	}
//
//      }
}
