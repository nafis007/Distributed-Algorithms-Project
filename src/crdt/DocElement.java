package crdt;
import java.sql.Timestamp;

public class DocElement implements IElement {
    TreePath path;
    char symbol;
    Timestamp timestamp;

    public DocElement(char symbol, TreePath path) {
        this.symbol = symbol;
        this.path = path;
    }

    @Override
    public TreePath getPath() {
        return null;
    }

    @Override
    public char getValue() {
        return symbol;
    }
}
