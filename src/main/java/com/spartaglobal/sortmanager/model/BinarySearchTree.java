package com.spartaglobal.sortmanager.model;

import java.util.ArrayList;

public class BinarySearchTree{
    class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }
    }

    public Node root;

    public BinarySearchTree(){
        root = null;
    }

    public Node populateTree(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value <= current.value) {
            current.left = populateTree(current.left, value);
        } else if (value > current.value) {
            current.right = populateTree(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public void traverseInOrder(Node node, ArrayList<Integer> list) {
        if (node != null) {
            traverseInOrder(node.left, list);
            list.add(node.value);
            traverseInOrder(node.right, list);
        }
    }
}
