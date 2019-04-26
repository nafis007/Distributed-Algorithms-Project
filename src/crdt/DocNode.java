package crdt;


public class DocNode implements INode {
    private DocElement element;
    private DocNode leftChild;
    private DocNode rightChild;
    private DocNode parent;

    public DocNode(DocElement element) {
        this.element = element;
    }

    @Override
    public INode getLeftChild() {
        return leftChild;
    }

    @Override
    public void setLeftChild(INode node) {
        this.leftChild = (DocNode)node;
        node.setParent(this);
    }

    @Override
    public INode getRightChild() {
        return rightChild;
    }

    @Override
    public void setRightChild(INode node) {
        this.rightChild = (DocNode)node;
        node.setParent(this);
    }

    @Override
    public void setParent(INode node) {
        this.parent = (DocNode) node;
        element.setPath(getPathToRoot());
    }

    @Override
    public IElement getElement() {
        return element;
    }

    private TreePath getPathToRoot() {
        TreePath path = new TreePath();
        getPathToParent(path);
        return path;
    }

    private void getPathToParent(TreePath path) {
        if (parent != null) {
            parent.getPathToParent(path);
            if (this == parent.rightChild) {
                path.addStep(Direction.right);
            } else {
                path.addStep(Direction.left);
            }
        }
    }
}
