package com.spartaglobal.sortmanager.model;

public class BinarySearchTreeFactory extends SortFactory{
    @Override
    public SortInterface getInstance() {
        return new BinarySearchTreeFacade();
    }
}
