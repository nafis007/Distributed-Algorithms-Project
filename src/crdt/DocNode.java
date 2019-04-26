package crdt;


public class DocNode implements INode {
    private DocElement element;
    private DocNode leftChild;
    private DocNode rightChild;

    public DocNode(DocElement element) {
        this.element = element;
    }

    @Override
    public INode getLeftChild() {
        return leftChild;
    }

    @Override
    public void setLeftChild(INode leftChild) {
        this.leftChild = (DocNode)leftChild;
    }

    @Override
    public INode getRightChild() {
        return rightChild;
    }

    @Override
    public void setRightChild(INode rightChild) {
        this.rightChild = (DocNode)rightChild;
    }

    @Override
    public IElement getElement() {
        return element;
    }
}
