package main;

import client.Client;
import server.Server;

public class Main {
	public static void main(String[] args) {
		establishConnections(8888, "127.0.0.1", 8888);
		
	}
	
	/**
	 * @param selfPort A port to allow connections from other clients
	 * @param serverAddress Connect to a server via this address
	 * @param serverPort Connect to a server via this port
	 */
	private static void establishConnections(int selfPort, String serverAddress, int serverPort) {
		// create a thread to run the server
		Server server = new Server(selfPort);
		server.start();
				
		// run client
		Client client = new Client();
		client.connectTo(serverAddress, serverPort);
		
		// show connection info
		ConnectionInfo.getInstance();
	}

}
