package main;

import client.Client;
import server.Server;

public class Main {

	public static void main(String[] args) {
		
		// create a thread to run the server
		Server server = new Server(8888);
		server.start();
		
		// run client
		Client client = new Client();
		client.connectTo("127.0.0.1", 8888);
	}

}
