package de.mawiguko.util.binarytree;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @param <T> Type of the Object which is stored into this Node.
 */
public class Node<T> implements Serializable, Cloneable {
    Node left;
    T object;
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

    public void setLeft(Node left) {
        this.left = left;
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

    public void setRight(Node right) {
        this.right = right;
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
        sb.append(object.toString());
        return sb.toString();
    }

    public void recursivePreOrder(Node node){
        System.out.println(object.toString());
        if(node.hasLeft()) {
            recursivePreOrder(node.getLeft());
        }
        if(node.hasRight())
            recursivePreOrder(node.getRight());
    }
}
