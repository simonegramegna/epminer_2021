package server_gradle.server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

import server_gradle.data.Data;
import server_gradle.data.EmptySetException;
import server_gradle.database.DatabaseConnectionException;
import server_gradle.database.NoValueException;
import server_gradle.mining.EmergingPatternMiner;
import server_gradle.mining.FrequentPatternMiner;
import server_gradle.utility.EmptyQueueException;

public class ServerOneClient extends Thread{
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	public ServerOneClient(Socket socket) throws IOException{
		this.socket =socket; 
		in = new ObjectInputStream(socket.getInputStream());
		out= new ObjectOutputStream(socket.getOutputStream());
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
			opzione=(int) in.readObject();
			minsup=(float) in.readObject();
			mingr=(float) in.readObject();
			targetName=(String) in.readObject();
			backgroundName=(String) in.readObject();
			Data datat=new Data(targetName);
			System.out.println("datat: " + datat);
			Data datab=new Data(backgroundName);
			System.out.println("datab: " + datab);
			FrequentPatternMiner fp=new FrequentPatternMiner(datat, minsup);
			System.out.println("fp: " + fp);
			out.writeObject(fp.toString());
			EmergingPatternMiner ep=new EmergingPatternMiner(datab, fp, mingr);
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
