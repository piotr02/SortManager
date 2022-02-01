package com.spartaglobal.sortmanager.model;

public abstract class SortFactory {
    /**
     * Abstract method used and implemented by sorting algorithm classes.
     */
    public abstract SortInterface getInstance();
}
