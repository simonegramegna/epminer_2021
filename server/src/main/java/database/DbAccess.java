package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Gestisce l'accesso al DB per la lettura dei dati di training
 * @author Map Tutor
 */
public class DbAccess {

    private final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private final String DBMS = "jdbc:mysql";
    private final String SERVER = "localhost";
    private final int PORT = 3306;
    private final String DATABASE = "Map";
    private final String USER_ID = "Student";
    private final String PASSWORD = "map";

    private Connection conn;

    /**
     * Inizializza una connessione al DB
     */
    public void initConnection() throws DatabaseConnectionException {

        String connectionString = DBMS + "://" + SERVER + ":" + PORT + "/" + DATABASE + "?user=" + USER_ID
                + "&password=" + PASSWORD + "&serverTimezone=UTC";

        try {
            Class.forName(DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * ritorna l'oggetto Connection
     * @return Connection
     */
    public Connection getConnection() {

        return conn;
    }

    /**
     * chiude la connessione conn
     */
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Impossibile chiudere la connessione");
        }
    }
}
