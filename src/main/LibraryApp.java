package main;

import dataManagement.DataManager;
import gui.MainGUI;

/**
 *
 */
public class LibraryApp {

    public static void main(String[] args) {
        DataManager dm = new DataManager();
        new MainGUI(dm);

    }
}
