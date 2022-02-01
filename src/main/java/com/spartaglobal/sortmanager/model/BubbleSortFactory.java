package com.spartaglobal.sortmanager.model;

public class BubbleSortFactory extends SortFactory{
    /**
     * Returns a new instance of the BubbleSort class.
     *
     * @return new instance of the BubbleSort class
     */
    @Override
    public SortInterface getInstance() {
        return new BubbleSort();
    }
}
