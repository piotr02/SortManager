package com.spartaglobal.sortmanager.model;

public class MergeSortFactory extends SortFactory{
    @Override
    public SortInterface getInstance() {
        return new MergeSort();
    }
}
