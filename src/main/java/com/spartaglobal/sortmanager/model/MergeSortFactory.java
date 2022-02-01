package com.spartaglobal.sortmanager.model;

public class MergeSortFactory extends SortFactory{
    /**
     * Returns a new instance of the MergeSort class.
     *
     * @return new instance of the MergeSort class
     */
    @Override
    public SortInterface getInstance() {
        return new MergeSort();
    }
}
