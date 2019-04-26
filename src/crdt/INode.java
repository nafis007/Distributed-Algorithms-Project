package crdt;

public interface INode {
    INode getLeftChild();
    void setLeftChild(INode node);
    INode getRightChild();
    void setRightChild(INode node);
    void setParent(INode node);
    IElement getElement();
}
