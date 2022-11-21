/*
 * File: CollectorController.java
 * Created Date: 2021-09-24 10:42:41
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

import java.util.ArrayList;

import models.Page;
import views.MainWindow;

public class CollectorController {

    MainWindow mainWindow;

    public CollectorController(MainWindow mainWindow) {

        this.mainWindow = mainWindow;

        mainWindow.pasteButton.addActionListener(event -> {

            System.out.println("Beillesztés");
            mainWindow.urlField.paste();
        });

        mainWindow.startButton.addActionListener(event -> {

            String URL = mainWindow.urlField.getText();
            if (URL.isEmpty()) {
                URL = "https://index.hu";
            }
            Page page = new Page();
            page.setUrl(URL);

            ArrayList<String> words = page.getContent();

            for(String word : words) {
                if (mainWindow.wordsModel.indexOf(word)<0) {
                    mainWindow.wordsModel.addElement(word);
                }                
            }

            Integer wordCount = mainWindow.wordsModel.getSize();
            mainWindow.statusBar.setText("Szavak: " + wordCount.toString());
        });

        this.mainWindow.aboutButton.addActionListener(event -> {
            mainWindow.statusBar.setText("Balogh Csenge | Szoft_II_N | 2022.11.21");
        });

        this.mainWindow.exitButton.addActionListener(event -> {
            System.exit(0);
        });

    }   
}
