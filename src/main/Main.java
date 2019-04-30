package main;

import client.Client;
import client.NotePadGUI;
import crdt.Crdt;
import crdt.IMessageHandler;
import crdt.Operation;
import network.ICommunicationManager;
import server.Server;

public class Main {

	public static void main(String[] args) {
		
		// create a thread to run the server
		Server server = new Server(8888);
		server.start();
		
		// run client
		Client client = new Client();
		client.connectTo("127.0.0.1", 8888);

		// initialize the Crdt (Model/Controller) and NotePadGUI (View)
		init();
	}

	private static void init(){
		ICommunicationManager communicationManager = new ICommunicationManager() {
			@Override
			public void broadcastMessage(Operation o) {

			}

			@Override
			public void handleIncomingMessage(IMessageHandler messageHandler) {
				messageHandler.handle(null);
			}
		}; //ToDO: It is just a stub. Remove it after proper implementation.
		Crdt data = new Crdt(communicationManager);
		NotePadGUI.init(data);
	}

}
