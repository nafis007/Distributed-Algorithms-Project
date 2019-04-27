package client;

import crdt.*;
import tests.CrdtTests;

public class Client {

	static Communication comm;
	
    public Client() {

//        guiObject.setBounds(0, 0, 700, 700);
//        guiObject.setTitle("Notepad");
//        guiObject.setResizable(false);
//        guiObject.setVisible(true);
//        guiObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        Crdt data = new Crdt();
        NotePadGUI.init(data);
//        data.update(OperationType.insert, 'b', 1);
//        data.update(OperationType.insert, 'c', 2);
//        data.update(OperationType.insert, 'd', 100);
//        data.update(OperationType.insert, 'a', 0);
//
//        data.update(OperationType.remove, 'a', 0);


//        data.updateEditor();

//        CrdtTests.testCrdtGetNodeByPath();
//        CrdtTests.testCrdtGetNodeByPath_1();
        CrdtTests.testCrdtAddNodeByPath();
        CrdtTests.testCrdtAddNodeByPath_1();
        CrdtTests.testCrdtAddNodeByPath_2();
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
