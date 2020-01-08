package de.mawiguko.studium.aldastru.Aufgabe_3;

import de.mawiguko.util.BinaryTree;
import de.mawiguko.util.binarytree.Node;

public class Programm_myTree {
    public static void main (String[] args) {
        BinaryTree myTree = new BinaryTree();
        String input = "Dies ist ein binaerer Baum zum traversieren.";
        String[] words = input.split("(?=(\\.|,|\\s|!|\\?))");
        Node root = myTree.getRoot();
        Node[] leftNodes = new Node[words.length];
        int j = 0;
        for (String s : words) {
            leftNodes[j]= new Node<>(s.toCharArray()[0]);
            if(myTree.getRoot() == null) {
                myTree.setRoot(leftNodes[0]);
            }
            Node[] rightNodes = new Node[s.length()];
            int i = 0;
            for (Character c : s.toCharArray()) {
                rightNodes[i++] = new Node<>(c);
            }
            leftNodes[j].appendRightRecursive(leftNodes[j], rightNodes);
            myTree.traversalPreOrder();
            j++;
        }
    }

}
