package crdt;

public interface INode {
    INode getLeftChild();
    void setLeftChild(INode leftChild);
    INode getRightChild();
    void setRightChild(INode rightChild);
    IElement getElement();
}
