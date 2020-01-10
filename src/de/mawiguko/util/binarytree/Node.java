package de.mawiguko.util.binarytree;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @param <T> Type of the Object which is stored into this Node.
 */
public class Node<T> implements Serializable, Cloneable {
    T object;
    Node left;
    Node parent;
    Node right;

    public Node(T object) {
        this.object = object;
    }

    public boolean hasRight() {
        return right != null;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node... leftys) {
        this.left = leftys[0];
        if(leftys.length > 1) {
            this.left.setLeft(Arrays.asList(leftys).subList(1,leftys.length).toArray(new Node[leftys.length-1]));
        }
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node... rightys) {
        this.right = rightys[0];
        if(rightys.length>1) {
            this.right.setRight(Arrays.asList(rightys).subList(1, rightys.length).toArray(new Node[rightys.length-1]));
            this.right.setParent(this);
        }
    }

    private void setParent(Node<T> tNode) {
        this.parent = tNode;
    }

    public void appendRightRecursive(Node parent, Node... nodes) {
        if (parent == null|| nodes[0] == null) {
            return;
        }
        parent.setRight(nodes[0]);
        Node[] tmp = Arrays.copyOfRange(nodes,1,nodes.length);
        if(nodes.length >1) {
            parent.appendRightRecursive(nodes[1], tmp);
        }
    }

    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(object.toString()).append("]");
        return sb.toString();
    }

    public void recursivePreOrder(Node node){
        if(node!= null) {
            System.out.print(node.toString());
        }
        if(node == null) {
            return;
        }
        if(node.hasLeft()) {
            recursivePreOrder(node.getLeft());
        }
        if(node.hasRight())
            recursivePreOrder(node.getRight());
    }

    public void recursiveInOrder(Node node) {
        if(node.hasLeft()) {
            recursiveInOrder(node.getLeft());
        }
        if(node!= null) {
            System.out.print(node.toString());
        }
        if(node.hasRight()) {
            recursiveInOrder(node.getRight());
        }
    }

    public void recursivePostOrder(Node node) {
        if(node.hasLeft()) {
            recursiveInOrder(node.getLeft());
        }
        if(node.hasRight()) {
            recursiveInOrder(node.getRight());
        }
        if(node!= null) {
            System.out.print(node.toString());
        }
    }

    public int getHeight() {
        int leftHeight = 0;
        int rightHeight = 0;
        if(this.isLeaf()) {
            return 1;
        }
        if (this.hasLeft()) {
            leftHeight = left.getHeight();
        }
        if (this.hasRight()) {
            rightHeight = right.getHeight();
        }
        return leftHeight++ > rightHeight++ ? leftHeight : rightHeight;
    }

    public int countLeaf() {
        int rightLeafs =  0;
        int leftLeafs = 0;
        if (this.isLeaf()) {
            return 1;
        }
        if (hasRight()){
            rightLeafs = right.countLeaf();
        }
        if (hasLeft()) {
            leftLeafs = left.countLeaf();
        }
        return leftLeafs + rightLeafs;

    }

    public int countNodes() {
        int leftNodes = 0;
        int rightNodes = 0;
        if(hasLeft()) {
            leftNodes = left.countNodes();
        }
        if(hasRight()) {
            rightNodes = right.countNodes();
        }
        return 1+rightNodes+leftNodes;
    }
}
