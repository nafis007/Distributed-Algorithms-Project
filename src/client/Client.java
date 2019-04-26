package client;

import javax.swing.JFrame;

public class Client {

	Communication comm;
	
    public Client() {
        NotePadGUI guiObject = new NotePadGUI();
        guiObject.setBounds(0, 0, 700, 700);
        guiObject.setTitle("Notepad");
        guiObject.setResizable(false);
        guiObject.setVisible(true);
        guiObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void connectTo(String host, int port) {
    	comm = new Communication(host, port);
    }
    public void connectTo(String host, String port) {
    	comm = new Communication(host, Integer.parseInt(port));
    }
}
