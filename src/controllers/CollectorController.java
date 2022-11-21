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

/**********************KEZDÉS************************************* */

/* 
    FIXME Az öröklés felesleges. 
    Ha megszüntetjük szükség lesz egy mainWindow adattagra. 
*/

public class CollectorController extends MainController {

    public CollectorController(MainWindow mainWindow) {

        super(mainWindow);

        /**************** pasteButton ****************************/

        mainWindow.pasteButton.addActionListener(event -> {

            System.out.println("Beillesztés");
            mainWindow.urlField.paste();
        });


        /**************** startButton ****************************/


        //Indul a szógyűjtés
        mainWindow.startButton.addActionListener(event -> {
            // URL
            String URL = mainWindow.urlField.getText();
            if (URL.isEmpty()) {
                URL = "https://index.hu";
            }
            //Egy weblap
            Page page = new Page();
            page.setUrl(URL);

            ArrayList<String> words = page.getContent();

            for(String word : words) {
                if (mainWindow.wordsModel.indexOf(word)<0) {
                    mainWindow.wordsModel.addElement(word);
                }                
            }

            Integer wordCount = mainWindow.wordsModel.getSize();
            mainWindow.statusBar.setm("Szavak: " + wordCount.toString());
        });

    }   
}
