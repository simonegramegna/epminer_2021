package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
    public static final int PORT = 5000;

    public MultiServer() throws IOException {
        this.run();
    }

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

    public static void main(String[] args) throws IOException {

        MultiServer mainServer = new MultiServer();
    }
}