package crdt;

import java.util.ArrayList;


class P {
    int stop;
    int current;

    P(int position) {
        stop = position;
        current = 0;
    }
}

public class DocTree implements ITree {
    DocNode root;


    private INode createNode() {
        return null;
    }

    private INode getNode(TreePath path) {
        return null;
    }

    private ArrayList<INode> traverseTreeUntilPosition(int position) {
        ArrayList<INode> nodes = new ArrayList();
        inorderTraverse(root, new P(position), nodes);
        return nodes;
    }

    public INode getNode(int position) {
        ArrayList<INode> nodes = traverseTreeUntilPosition(position);
        return nodes.get(nodes.size()-1);
    }

    private static boolean inorderTraverse(INode root, P positions, ArrayList<INode> result) {
        if (root != null) {
            boolean exit = inorderTraverse(root.getLeftChild(), positions, result);
            if (exit) {
                return true;
            }
            if (positions.current == positions.stop) {
                return true;
            }
            result.add(root);
            positions.current++;
            return inorderTraverse(root.getRightChild(), positions, result);
        }
        return false;
    }

    @Override
    public INode addSymbol(char symbol, int position) {
        DocElement el = new DocElement(symbol, null);
        DocNode newNode = new DocNode(el);

        if (root == null) {
            root = newNode;
            return newNode;
        }

        if (position == 0) {
            INode leaf = findLeftLeaf(root);
            leaf.setLeftChild(newNode);
            return newNode;
        }

        INode node = getNode(position);
        if (node.getRightChild() == null) {
            node.setRightChild(newNode);
        }
        else {
            INode leaf = findLeftLeaf(node);
            leaf.setLeftChild(newNode);
        }
        return newNode;
    }

    private INode findLeftLeaf(INode root) {
        if (root != null) {
            INode leaf =  findLeftLeaf(root.getLeftChild());
            if (leaf == null) {
                return root;
            }
            return leaf;
        }
        return null;
    }

    @Override
    public INode removeSymbol(char a, int position) {
        return null;
    }


    private void removeNode(INode node) {

    }

    @Override
    public String toString() {
        ArrayList<INode> nodes = traverseTreeUntilPosition(-1);
        StringBuilder str = new StringBuilder();
        for (INode node : nodes) {
            str.append(node.getElement().getValue());
        }
        return str.toString();
    }
}
