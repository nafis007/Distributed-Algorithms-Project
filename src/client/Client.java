package client;

import crdt.*;
import network.ICommunicationManager;
import tests.CrdtTests;

public class Client {

	static Communication comm;



    public Client() {

//        guiObject.setBounds(0, 0, 700, 700);
//        guiObject.setTitle("Notepad");
//        guiObject.setResizable(false);
//        guiObject.setVisible(true);
//        guiObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



//        CrdtTests.testCrdtGetNodeByPath();
//        CrdtTests.testCrdtGetNodeByPath_1();
//        CrdtTests.testCrdtAddNodeByPath();
//        CrdtTests.testCrdtAddNodeByPath_1();
//        CrdtTests.testCrdtAddNodeByPath_2();
    }
    public void connectTo(String host, int port) {
    	comm = new Communication(host, port);
    }
    public void connectTo(String host, String port) {
    	comm = new Communication(host, Integer.parseInt(port));
    }
	public static void sentToServer(Object obj) {
		comm.getChannel().writeAndFlush(obj);
	}
}
