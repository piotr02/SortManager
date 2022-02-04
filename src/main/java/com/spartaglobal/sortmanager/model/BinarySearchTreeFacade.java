package com.spartaglobal.sortmanager.model;

import com.spartaglobal.sortmanager.SortManagerMain;
import com.spartaglobal.sortmanager.view.DisplayManager;

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
        SortManagerMain.logger.debug("ints= " + new DisplayManager().displayArray(ints));
        if(ints.length == 0)
            return null;

        ArrayList<Integer> list = new ArrayList<>();
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTree.Node root = bst.new Node(ints[0]);

        // Populate the binary search tree with values from an array
        for(int i = 1; i < ints.length; i++){
            bst.populateTree(root, ints[i]);
            SortManagerMain.logger.debug("Entered value= " + ints[i]);
        }

        // Add sorted values into an ArrayList
        bst.traverseInOrder(root, list);

        // Convert back to an array
        int[] output = new int[list.size()];
        int i = 0;
        for(int value: list){
            SortManagerMain.logger.debug("value= " + value);
            output[i] = value;
            i++;
        }
        SortManagerMain.logger.debug("output= " + new DisplayManager().displayArray(output));
        return output;
    }
}
