package de.mawiguko.studium.aldastru.Aufgabe_3;

import de.mawiguko.util.BinaryTree;
import de.mawiguko.util.binarytree.Node;

import java.util.Arrays;

public class Aufgabe_3_4_MyTree {
    public static void main (String[] args) {
        BinaryTree myTree = new BinaryTree();
        String input = "Dies ist ein binaerer Baum zum traversieren.";
        String[] words = input.split("(?=(\\.|,|\\s|!|\\?))");
        Node root = myTree.getRoot();
        Node[] leftNodes = new Node[words.length];
        int i = 0;
        //Creation of All left nodes
        for(String w : words) {
            leftNodes[i++] = new Node<>(w.toCharArray()[0]);
        }
        i = 0;
        for(Node left : leftNodes) {
            if(myTree.getRoot() == null) {
                myTree.setRoot(left);
            }else {
                leftNodes[i-1].setLeft(left);
            }
            //creation of all right nodes
            int rightIndex = 0;
            Node[] rightNodes = new Node[words[i].length()];
            for(Character c : words[i].substring(1).toCharArray()) {
                rightNodes[rightIndex++] = new Node<>(c);
            }
            i++;
            left.setRight(rightNodes);

        }

        System.out.println("Tree traversals:");
        myTree.traversalPreOrder();
        myTree.traversalInOrder();
        myTree.traversalPostOrder();

        System.out.println("Height of Root Element:");
        System.out.println(myTree.getRoot().getHeight());
    }

}
