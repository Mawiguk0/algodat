package de.mawiguko.util;

import de.mawiguko.util.binarytree.Node;
import de.mawiguko.util.binarytree.NodeAlreadySetException;
import de.mawiguko.util.binarytree.TraversalMode;

import java.io.Serializable;

/**
 *
 */
public class BinaryTree implements Cloneable, Serializable {
    public int getHeight(){
        return root.getHeight();
    }

    private Node root;
    /**
     *
     * @param traversalMode sets the traversal route for adding multple nodes
     * @param nodes
     */
    public void add(TraversalMode traversalMode, Node... nodes) {
            for(Node n : nodes){
                if(root==null) {
                    root = n;
                } else {
                    switch (traversalMode) {
                        case PREORDER: {

                        } break;
                        case INORDER: {

                        }break;
                        case POSTORDER: {

                        }break;
                    }
            }
        }
    }

    public void traversalPreOrder() {
        System.out.println("PreOrder Traversal:");
        this.root.recursivePreOrder(root);
        System.out.println();
    }

    public void traversalInOrder() {
        System.out.println("InOrder Traversal:");
        this.root.recursiveInOrder(root);
        System.out.println();
    }

    public void traversalPostOrder() {
        System.out.println("PostOrder Traversal:");
        this.root.recursivePostOrder(root);
        System.out.println();
    }


    /**
     *  Save to use if you want to build a tree without datalos trough checking before setting the child
     * @param parent which gets a new child
     * @param child which will be the child of given parent
     * @throws NodeAlreadySetException when the left child was not null before method call!
     */
    public void addLeft(Node parent, Node child) throws NodeAlreadySetException {
        if(parent.getLeft()== null) {
            throw new NodeAlreadySetException("Left node of "+parent.toString()+" is not null!");
        }
        this.setLeft(parent, child);
    }

    /**
     * Save to use if you want to build a tree without datalos trough checking before setting the child
     * @param parent which gets a new child
     * @param child which will be the child of given parent
     * @throws NodeAlreadySetException when the right child was not null before method call!
     */
    public void addRight(Node parent, Node child) throws NodeAlreadySetException {
        if(parent.getLeft()== null) {
            throw new NodeAlreadySetException("Right node of "+parent.toString()+" is not null!");
        }
        this.setRight(parent, child);
    }

    /**
     * Overrides left child of parent, use with Care!
     * @param parent
     * @param child
     */
    public void setLeft(Node parent,  Node child) {
        parent.setLeft(child);
    }

    /**
     * Overrides right child of parent, use with Care!
     * @param parent
     * @param child
     */
    public void setRight(Node parent,  Node child) {
        parent.setRight(child);
    }

    public Node getRoot(){
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
