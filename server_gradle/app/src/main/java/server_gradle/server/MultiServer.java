package server_gradle.server;

import java.io.*;
import java.net.*;

public class MultiServer {
	public static final int PORT = 5000;
	public MultiServer() throws IOException {
		this.run();
	}
	private void run() throws IOException {

		InetAddress addr = InetAddress.getByName("localhost");
		int backlog = 10;

		ServerSocket s = new ServerSocket(PORT,backlog, addr);
		System.out.println("Started: " + s);
		while(true) {
				Socket socket = s.accept();
				System.out.println(socket);
				ServerOneClient server=new ServerOneClient(socket);
		}
	}
	public static void main(String[] args) throws IOException {
		MultiServer ms= new MultiServer();
	}
} 
