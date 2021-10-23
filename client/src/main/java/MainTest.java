import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.SQLException;

import keyboardinput.Keyboard;

/**
 * Classe principale del client
 */
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		InetAddress addr = InetAddress.getByName(args[0]);
		System.out.println("addr = " + addr + "\nport=" + args[1]);
		Socket socket = new Socket(addr, new Integer(args[1]));
		System.out.println(socket);

		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

		char risp = 's';
		do {
			out.writeObject(risp);
			System.out.println("Scegli una opzione:");
			int opzione;
			do {
				System.out.println("1:Nuova scoperta");
				System.out.println("2: Risultati in archivio");
				opzione = Keyboard.readInt();
			} while (opzione != 1 && opzione != 2);

			float minsup = 0f;
			float minGr = 0f;
			do {
				System.out.println("Inserire valore minimo supporto (minsup>0 e minsup<=1):");
				minsup = Keyboard.readFloat();
			} while (minsup <= 0 || minsup > 1);

			do {
				System.out.println("Inserire valore minimo grow rate (minGr>0):");
				minGr = Keyboard.readFloat();
			} while (minGr <= 0);

			System.out.println("Tabella target:");
			String targetName = Keyboard.readString();
			System.out.println("Tabella background:");
			String backgroundName = Keyboard.readString();
			String nameFile = targetName + "_" + backgroundName;

			try {
                
				out.writeObject(opzione);
				out.writeObject(minsup);
				out.writeObject(minGr);
				out.writeObject(targetName);
				out.writeObject(backgroundName);

				String fpMiner = (String) (in.readObject());
                System.out.println("\nFrequent patterns");
                System.out.println(fpMiner);
                
				String epMiner = (String) (in.readObject());
                System.out.println("Emerging patterns");
				System.out.println(epMiner);

			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}

			System.out.println("Vuoi ripetere?(s/n)");
			risp = Keyboard.readChar();

		} while (risp != 'n');
	}
}
