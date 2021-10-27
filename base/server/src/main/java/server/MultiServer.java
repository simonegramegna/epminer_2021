package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * modella un server in grado di accettare la richiesta trasmesse da un generico
 * Client e istanzia un oggetto della classe ServerOneClient che si occupera di
 * servire le richieste del client in un thred dedicato. Il Server sara'
 * registrato su una porta predefinita (al di fuori del range 1-1024), per
 * esempio 8080.
 */
public class MultiServer {

    public static final int PORT = 8080;

    public MultiServer() throws IOException {

        this.run();
    }

    /**
     * assegna ad una variabile locale s il riferimento ad una istanza della classe
     * ServerSocket creata usando la porta PORT. s si pone in attesa di richieste di
     * connessione da parte di client in risposta alle quali viene restituito l'
     * oggetto Socketda passare come argomento al costruttore della classe
     * ServerOneClient.
     * @throws IOException
     */
    private void run() throws IOException {

        ServerSocket s = null;
        Socket socket = null;

        try {

            s = new ServerSocket(PORT);
            System.out.println("Started: " + s);

            while (true) {
                socket = s.accept();
                System.out.println(socket);
                ServerOneClient server = new ServerOneClient(socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * crea un oggetto istanza di MultiServer
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        MultiServer mainServer = new MultiServer();
    }
}