package com.spartaglobal.sortmanager;

import com.spartaglobal.sortmanager.controller.SortManager;
import com.spartaglobal.sortmanager.model.ArrayGenerator;
import com.spartaglobal.sortmanager.view.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortManagerMain {
    public static Logger logger = LogManager.getLogger("Logger");

    public static void main(String[] args) {
        logger.info("Program Start");
        DisplayManager view = new DisplayManager();
        ArrayGenerator ag = new ArrayGenerator();
        SortManager sm = new SortManager();
        view.printStart();
        String desiredSortMethod = sm.getDesiredSortMethod();
        logger.debug("desiredSortMethod= " + desiredSortMethod);
        SortManager controller = new SortManager();
        String desiredArrayType = ag.getDesiredArrayType();
        logger.debug("desiredArrayType= " + desiredArrayType);
        controller.executeSort(desiredSortMethod, desiredArrayType);
        logger.info("Program End");
    }
}
