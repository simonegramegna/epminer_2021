package data;
import java.io.IOException;
import java.io.Serializable;
/**
 *Definisce la classe astratta Attribute che modella un generico attributo discreto o 
continuo.
 * 
 */
public abstract class Attribute implements Serializable {

	private static final long serialVersionUID = -1011201825379454272L;
	private String name;
	private int index;
/**
 * inizializza i valori per nome simbolico dell'attributo e identificativo numerico dell'attributo
 * @param name
 * @param index
 */
	public Attribute(String name, int index) {

		this.name = name;
		this.index = index;
	}
	
	/**
	 * restitisce il nome dell'attributo
	 * @return String
	 */
	public String getName() {

		return name;
	}
/**
 * restituisce l'index corrente
 * @return int
 */
	public int getIndex() {

		return index;
	}

	@Override
	/**
	 *restituisce una rappresentazione in stringa dell'oggetto
	 *@return String
	 */
	public String toString() {

		return name;
	}
}
