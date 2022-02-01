package com.spartaglobal.sortmanager;

import com.spartaglobal.sortmanager.controller.SortManager;
import com.spartaglobal.sortmanager.view.DisplayManager;

public class SortManagerMain {
    public static void main(String[] args) {
        DisplayManager view = new DisplayManager();
        String desiredSortMethod = view.getDesiredSortMethod();
        SortManager controller = new SortManager();
        String result = controller.initiateSorting(desiredSortMethod);
        view.getResult(result);
    }
}
