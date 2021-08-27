package server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

import data.Data;
import data.EmptySetException;
import database.DatabaseConnectionException;
import database.NoValueException;
import mining.EmergingPatternMiner;
import mining.FrequentPatternMiner;
import utility.EmptyQueueException;

public class ServerOneClient extends Thread {

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    protected ServerOneClient(Socket s) throws IOException {
        socket = s;
        in = new ObjectInputStream(s.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
        this.start();
    }

    @Override
    public void run() {

        int opzione;
        float minsup;
        float mingr;
        String targetName;
        String backgroundName;

        try {

            //char choose = (char) in.readObject();

            while (true) {

                opzione = (int) in.readObject();
                minsup = (float) in.readObject();
                mingr = (float) in.readObject();
                targetName = (String) in.readObject();
                backgroundName = (String) in.readObject();

                System.out.println("Opzione " + opzione);

                if (opzione == 1) {

                    Data dataTarget = new Data(targetName);

                    Data dataBackground = new Data(backgroundName);
                    System.out.println("Background data");
                    System.out.println(dataBackground);

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

                //choose = (char) in.readObject();
            }

            //socket.close();

        } catch (NumberFormatException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException | IOException e) {

            e.printStackTrace();
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