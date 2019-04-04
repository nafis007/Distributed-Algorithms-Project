package client;

import javax.swing.JFrame;

public class Client {
	
	
	
    public static void main(String args[]) {
        NotePadGUI guiObject = new NotePadGUI();
        guiObject.setBounds(0, 0, 700, 700);
        guiObject.setTitle("Notepad");
        guiObject.setResizable(false);
        guiObject.setVisible(true);
        guiObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Communication comm = new Communication();
        
    }
}
