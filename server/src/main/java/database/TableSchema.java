package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * modella lo schema di una tabella nel database relazionale
 */
public class TableSchema {

    private Connection connection;

    /**
     * costruttore che modella lo schema di una tabella nel database relazionale
     * 
     * @param tableName
     * @param connection
     * @throws SQLException
     */
    public TableSchema(String tableName, Connection connection) throws SQLException {

        this.connection = connection;
        HashMap<String, String> mapSQL_JAVATypes = new HashMap<String, String>();

        mapSQL_JAVATypes.put("CHAR", "string");
        mapSQL_JAVATypes.put("VARCHAR", "string");
        mapSQL_JAVATypes.put("LONGVARCHAR", "string");
        mapSQL_JAVATypes.put("BIT", "string");
        mapSQL_JAVATypes.put("SHORT", "number");
        mapSQL_JAVATypes.put("INT", "number");
        mapSQL_JAVATypes.put("LONG", "number");
        mapSQL_JAVATypes.put("FLOAT", "number");
        mapSQL_JAVATypes.put("DOUBLE", "number");

        DatabaseMetaData meta = connection.getMetaData();
        ResultSet res = meta.getColumns(null, null, tableName, null);

        while (res.next()) {

            if (mapSQL_JAVATypes.containsKey(res.getString("TYPE_NAME")))
                tableSchema.add(
                        new Column(res.getString("COLUMN_NAME"), mapSQL_JAVATypes.get(res.getString("TYPE_NAME"))));
        }
        res.close();
    }

    /**
     * classe Column formata da due stringhe
     */
    public class Column {

        private String name;
        private String type;

        /**
         * @param name
         * @param type
         */
        Column(String name, String type) {
            this.name = name;
            this.type = type;
        }

        /**
         * ritorna il nome in colonna
         * 
         * @return String
         */
        public String getColumnName() {
            return name;
        }

        /**
         * ritorna vero se type=number, falso altrimenti
         * @return boolean
         */
        public boolean isNumber() {
            return type.equals("number");
        }

        /**
         * ritorna una stringa
         * @return String
         */
        public String toString() {
            return name + ":" + type;
        }
    }

    List<Column> tableSchema = new ArrayList<Column>();

    /**
     * ritorna la dimensione di tableSchema
     * @return int
     */
    public int getNumberOfAttributes() {

        return tableSchema.size();
    }

    /**
     * ritorna il valore di tableSchema in posizione index
     * @param index
     * @return String
     */
    public Column getColumn(int index) {

        return tableSchema.get(index);
    }
}
