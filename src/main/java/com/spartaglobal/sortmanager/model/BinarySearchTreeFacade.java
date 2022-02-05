package com.spartaglobal.sortmanager.model;

import java.util.ArrayList;

public class BinarySearchTreeFacade implements SortInterface{

    /**
     * Sorts an array with the binary search tree algorithm.
     *
     * @param ints unsorted array
     * @return sorted array
     */
    @Override
    public int[] sort(int[] ints) {
        if(ints.length == 0)
            return null;

        ArrayList<Integer> list = new ArrayList<>();
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTree.Node root = bst.new Node(ints[0]);

        // Populate the binary search tree with values from an array
        for(int i = 1; i < ints.length; i++){
            bst.populateTree(root, ints[i]);
        }

        // Add sorted values into an ArrayList
        bst.traverseInOrder(root, list);

        // Convert back to an array
        int[] output = new int[list.size()];
        int i = 0;
        for(int value: list){
            output[i] = value;
            i++;
        }
        return output;
    }
}
