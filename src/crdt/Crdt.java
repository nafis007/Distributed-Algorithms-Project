package crdt;

import client.NotePadGUI;

import java.util.ArrayList;

public class Crdt implements ICrdt {
    private DocTree doc;

    public Crdt() {
        doc = new DocTree();
    }

    /**
     * Method update() is used to update DocTree by Editor
     * */
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

    /**
     * Method sync() is used to update local DocTree by messages from remote peers
     * Only insert operation yet
     * */
    @Override
    public void sync(Operation operation) {
        if (operation.getType() == OperationType.insert) {
            try {
                doc.addNode(operation.getElement());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //ToDo: Add remove operation
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
