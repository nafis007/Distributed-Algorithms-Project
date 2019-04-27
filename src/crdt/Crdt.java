package crdt;

import client.NotePadGUI;

import java.util.ArrayList;

public class Crdt implements ICrdt {
    private DocTree doc;

    public Crdt() {
        doc = new DocTree();
    }

    @Override
    public void update(OperationType operation, char symbol, int position) {
        if (operation == OperationType.insert) {
            doc.addSymbol(symbol, position);
        }
        if (operation == OperationType.remove) {
            try {
                doc.removeSymbol(symbol, position);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void uploadDoc(ArrayList<INode> doc) {

    }

    @Override
    public void updateEditor() {
        NotePadGUI.updateEditor(doc.toString());
//        System.out.println(doc.toString());
    }
}
