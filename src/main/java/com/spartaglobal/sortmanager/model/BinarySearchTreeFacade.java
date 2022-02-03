package com.spartaglobal.sortmanager.model;

import java.util.ArrayList;

public class BinarySearchTreeFacade implements SortInterface{

    @Override
    public int[] sort(int[] ints) {
        if(ints.length == 0)
            return null;

        ArrayList<Integer> list = new ArrayList<>();
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTree.Node root = bst.new Node(ints[0]);

        for(int i = 0; i < ints.length; i++){
            bst.populateTree(root, ints[i]);
        }

        bst.traverseInOrder(root, list);

        int[] output = new int[list.size()];

        int i = 0;
        for(int value: list){
            output[i] = value;
            i++;
        }

        return output;
    }
}
