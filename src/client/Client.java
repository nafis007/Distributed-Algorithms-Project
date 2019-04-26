package client;


import javax.swing.JFrame;

import crdt.*;

public class Client {
    public static void main(String args[]) {
//        NotePadGUI guiObject = new NotePadGUI();
//        guiObject.setBounds(0, 0, 700, 700);
//        guiObject.setTitle("Notepad");
//        guiObject.setResizable(false);
//        guiObject.setVisible(true);
//        guiObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        





        DocTree tree = new DocTree();
        tree.addSymbol('b', 1);
        tree.addSymbol('c', 2);
        tree.addSymbol('d', 100);
        tree.addSymbol('a', 0);

        System.out.println(tree.toString());
    }
}
