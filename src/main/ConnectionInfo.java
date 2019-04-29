package main;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ConnectionInfo {
	
	private static ConnectionInfo ci = null;
	private JFrame mainWindow;

	public ConnectionInfo() {
		CreateMainWindow();
	}
	
	public static ConnectionInfo getInstance() {
		if (ci==null) {
			ci = new ConnectionInfo();
		}
		return ci;
	}
	
	public void CreateMainWindow() {
        mainWindow = new JFrame("Connection Infomation");
        mainWindow.setVisible(true);
        mainWindow.setSize(500, 350);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
