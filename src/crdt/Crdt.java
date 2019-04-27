package crdt;

import java.util.ArrayList;

public class Crdt implements ICrdt {
    private DocTree doc;

    public Crdt() {
        doc = new DocTree();

//        doc.addSymbol('b', 1);
//        doc.addSymbol('c', 2);
//        doc.addSymbol('d', 3);
//        doc.addSymbol('a', 0);
//        doc.addSymbol('f', 1);
//        doc.addSymbol('m', 3);
//
//        ArrayList<INode> nodes = doc.traverseTreeUntilPosition(-1);
//
//        for (INode node : nodes) {
//            DocElement element = (DocElement)node.getElement();
//            System.out.println(element.getValue());
//
//            TreePath path =  element.getPath();
//
//            if (path != null) {
//                System.out.println(path.length());
//
//                Direction s = path.getNextStep();
//                while (s != null) {
//                    System.out.println(s);
//                    s = path.getNextStep();
//                }
//            }
//
//        }


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
        System.out.println(doc.toString());
    }
}
