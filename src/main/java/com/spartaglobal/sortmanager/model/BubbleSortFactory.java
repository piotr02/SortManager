package com.spartaglobal.sortmanager.model;

public class BubbleSortFactory extends SortFactory{
    @Override
    public SortInterface getInstance() {
        return new BubbleSort();
    }
}
