package crdt;

public interface ITree {
    INode addSymbol(char a, int position);
    INode removeSymbol(char a, int position) throws Exception;
    String toString();

}
