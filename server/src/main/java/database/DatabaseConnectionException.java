package database;

/**
 * classe che estende Exception per controllare l�assenza di una connessione
 *
 *
 */
public class DatabaseConnectionException extends Exception {
    /**
     * stampa a video l'eccezzione
     * 
     * @param msg
     */
    DatabaseConnectionException(String msg) {
        super(msg);
    }
}
