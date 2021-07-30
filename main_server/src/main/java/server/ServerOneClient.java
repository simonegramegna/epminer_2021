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

    public ServerOneClient(Socket socket) throws IOException {
        this.socket = socket;
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
        this.start();
    }

    @Override
    public void run() {

        super.run();

        int opzione;
        float minsup;
        float mingr;
        String targetName;
        String backgroundName;

        try {
            opzione = (int) in.readObject();
            minsup = (float) in.readObject();
            mingr = (float) in.readObject();

            System.out.println("Opzione ricevuta " + opzione);
            System.out.println("minsup ricevuto " + minsup);
            System.out.println("mingr ricevuto " + mingr);


            System.out.println("\n\n\n");



            targetName = (String) in.readObject();

            System.out.println("target ricevuto " + targetName);


            backgroundName = (String) in.readObject();

            System.out.println("background ricevuto " + backgroundName);


            Data datat = new Data(targetName);
            System.out.println("datat: " + datat);
            Data datab = new Data(backgroundName);
            System.out.println("datab: " + datab);
            FrequentPatternMiner fp = new FrequentPatternMiner(datat, minsup);
            System.out.println("fp: " + fp);
            out.writeObject(fp.toString());
            EmergingPatternMiner ep = new EmergingPatternMiner(datab, fp, mingr);
            System.out.println("ep: " + ep);
            out.writeObject(ep.toString());
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DatabaseConnectionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoValueException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (EmptySetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (EmptyQueueException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
