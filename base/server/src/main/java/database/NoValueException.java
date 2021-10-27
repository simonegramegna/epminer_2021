package database;

/**
 * classe che estende Exception per modellare l'assenza di un valore all'interno
 * di un resultset
 */
public class NoValueException extends Exception {
    /**
     * stampa il messaggio di errore in caso di eccezzione
     * 
     * @param msg
     */
    public NoValueException(String msg) {
        // TODO Auto-generated constructor stub
        super(msg);
    }
}
