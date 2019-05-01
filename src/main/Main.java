package main;

import client.Client;
import server.Server;

public class Main {
	private static Client client;
	private static Server server;
	
	public static void main(String[] args) {
		processArgs(args);
	}
	
	private static void processArgs(String[] args) {
		// args[0] = server port, default = 8888
		int port;
		if (args.length==0) {
			port = 8888;
		}else {
			port = Integer.parseInt(args[0]);
		}
		System.err.println("Server starts at port " + port);
		establishConnections(port);
	}
	
	/**
	 * @param selfPort A port to allow connections from other clients
	 * @param serverAddress Connect to a server via this address
	 * @param serverPort Connect to a server via this port
	 */
	private static void establishConnections(int selfPort) {
		// show connection info
		ConnectionInfo.getInstance();
		
		// create a thread to run the server
		server = new Server(selfPort);
		server.start();
				
		// run client
		client = new Client();
		
	}

	public static Client getClient() {
		return client;
	}

	public static Server getServer() {
		return server;
	}

}
