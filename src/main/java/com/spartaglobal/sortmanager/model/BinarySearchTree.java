package com.spartaglobal.sortmanager.model;

import java.util.ArrayList;

public class BinarySearchTree{
    // Node of the binary search tree
    class Node{
        int value;
        Node left;
        Node right;

        // Node constructor
        Node(int value){
            this.value = value;
        }
    }

    // Root of the binary search tree
    public Node root;

    // Binary search tree constructor
    public BinarySearchTree(){
        root = null;
    }

    // Populate the binary search tree with Nodes in a sorted order
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

    // Traverse the binary search tree to add Nodes to an ArrayList
    public void traverseInOrder(Node node, ArrayList<Integer> list) {
        if (node != null) {
            traverseInOrder(node.left, list);
            list.add(node.value);
            traverseInOrder(node.right, list);
        }
    }
}
