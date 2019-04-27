package crdt;

import java.util.ArrayList;

public interface ICrdt {
    void update(OperationType operation, char symbol, int position);
    void uploadDoc(ArrayList<INode> doc);

    void updateEditor();

}
