package server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;
import data.Data;
import data.EmptySetException;
import database.DatabaseConnectionException;
import database.NoValueException;
import mining.EmergingPatternMiner;
import mining.FrequentPatternMiner;
import utility.EmptyQueueException;

/**
 * la classe ServerOneClient che estende la classe Thread che modella la
 * comunicazione con un unico client.
 *
 */
public class ServerOneClient extends Thread {

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    /**
     * Inizia il membro this.socket con il parametro in input al costruttore.
     * Inizializza in e out, avvia il thread invocando il metodo start() (ereditato
     * da Thread).
     * 
     * @param s
     * @throws IOException
     */
    protected ServerOneClient(Socket s) throws IOException, SocketException {

        socket = s;
        in = new ObjectInputStream(s.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
        this.start();
    }

    /**
     * Ridefinisce il metodo run della classe Thread (variazione funzionale).
     * Gestisce le richieste del client (apprendere pattern/regole e popolare con
     * queste archive; salvare archive in un file, avvalorare archive con oggetto
     * serializzato nel file)
     */
    @Override
    public void run() {
        try {
            int option;
            float minsup;
            float mingr;
            String targetName;
            String backgroundName;
            char continueEP;

            continueEP = (char) in.readObject();

            while (continueEP == 's') {

                option = (int) in.readObject();
                minsup = (float) in.readObject();
                mingr = (float) in.readObject();

                targetName = (String) in.readObject();
                backgroundName = (String) in.readObject();

                if (option == 1) {

                    Data dataTarget = new Data(targetName);
                    Data dataBackground = new Data(backgroundName);

                    try {
                        FrequentPatternMiner fpMiner = new FrequentPatternMiner(dataTarget, minsup);

                        try {
                            fpMiner.salva("FP_playtennis_minSup" + minsup + ".dat");

                        } catch (IOException e1) {

                            e1.printStackTrace();
                        }
                        out.writeObject(fpMiner.toString());

                        try {
                            EmergingPatternMiner epMiner = new EmergingPatternMiner(dataBackground, fpMiner, mingr);

                            try {
                                epMiner.salva("EP_playtennis_minSup" + minsup + "_minGr" + mingr + ".dat");

                            } catch (IOException e1) {

                                out.writeObject(e1.toString());
                            }
                            out.writeObject(epMiner.toString());

                        } catch (EmptySetException e) {

                            out.writeObject(e.toString());
                        }
                    } catch (EmptySetException e) {

                        out.writeObject(e.toString());
                    }
                } else {
                    if (option == 2) {
                        try {
                            FrequentPatternMiner fpMiner = FrequentPatternMiner
                                    .carica("FP_playtennis_minSup" + minsup + ".dat");

                            out.writeObject(fpMiner.toString());

                            EmergingPatternMiner epMiner = EmergingPatternMiner
                                    .carica("EP_playtennis_minSup" + minsup + "_minGr" + mingr + ".dat");
                            out.writeObject(epMiner.toString());

                        } catch (ClassNotFoundException | IOException e) {

                            out.writeObject(e.toString());
                        }
                    }
                }
                continueEP = (char) in.readObject();
            }
            socket.close();
        } catch (NumberFormatException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException | IOException e) {

            e.printStackTrace();
            try {

                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (DatabaseConnectionException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        } catch (NoValueException e) {

            e.printStackTrace();
        } catch (EmptyQueueException e) {

            e.printStackTrace();
        }
    }
}