package server;

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

        	char choose = (char) in.readObject();

            while (choose == 's') {

                opzione = (int) in.readObject();
                minsup = (float) in.readObject();
                mingr = (float) in.readObject();
                targetName = (String) in.readObject();
                backgroundName = (String) in.readObject();

                Data datat = new Data(targetName);
                System.out.println("datat: " + datat);

                Data datab = new Data(backgroundName);
                System.out.println("datab: " + datab);

                FrequentPatternMiner fp = new FrequentPatternMiner(datat, minsup);
                System.out.println("fp: " + fp);

                EmergingPatternMiner ep = new EmergingPatternMiner(datab, fp, mingr);
                System.out.println("ep: " + ep);

                out.writeObject(fp.toString());
                out.writeObject(ep.toString());

                choose = (char) in.readObject();
            }

            socket.close();

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
        } catch (EmptySetException e) {

            e.printStackTrace();
        } catch (EmptyQueueException e) {

            e.printStackTrace();
        }

    }

}