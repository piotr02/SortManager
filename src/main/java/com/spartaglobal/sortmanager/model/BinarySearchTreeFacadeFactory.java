package com.spartaglobal.sortmanager.model;

public class BinarySearchTreeFacadeFactory extends SortFactory{
    /**
     * Returns a new instance of the BinarySearchTreeFacade object.
     *
     * @return a new instance of the BinarySearchTreeFacade object
     */
    @Override
    public SortInterface getInstance() {
        return new BinarySearchTreeFacade();
    }
}
