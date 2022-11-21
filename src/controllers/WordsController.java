/*
 * File: WordsController.java
 * Created Date: 2021-09-24 10:43:16
 * Author: Sallai Andras
 * Github: https://github.com/andteki
 * -----
 * Last Modified: 2022-11-21
 * Modified By: Balogh Csenge
 * -----
 * Copyright (c) 2021 Sallai Andras
 * 
 * GNU GPL v2
 */

package controllers;

import views.MainWindow;

public class WordsController {

    MainWindow mainWindow;
    
    public WordsController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        setEvents();
        
    }

    private void setEvents() {
        mainWindow.deleteButton.addActionListener(event -> deleteButtonEvent());
        mainWindow.sortButton.addActionListener(event -> sortButtonEvent());
        mainWindow.filterButton.addActionListener(event -> filterButtonEvent());
        mainWindow.saveButton.addActionListener(event -> saveButtonEvent());
    }

    private void deleteButtonEvent() {
        //set list to initial empty state, empty out wordslist
    }

    private void sortButtonEvent() {
        //mostakkorezmi?
    }
    
    private void filterButtonEvent() {
        //en csak takaritok
    }

    private void saveButtonEvent() {
        // write to file?
    }
}