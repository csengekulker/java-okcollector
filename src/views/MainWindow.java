/*
 * File: MainWindow.java
 * Created Date: 2021-09-24 10:36:27
 * Author: Sallai Andras
 * Github: https://github.com/andteki
 * -----
 * Last Modified: 2021-09-24
 * Modified By: Sallai Andras
 * -----
 * Copyright (c) 2021 Sallai Andras
 * 
 * GNU GPL v2
 */

package views;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MainWindow extends JFrame {

    public JLabel appLabel;
    public JLabel urlLabel;
    public JTextField urlField;

    public JPanel listPanel;
    public JPanel listButtonsPanel;
    public JPanel bottomPanel;
    public JPanel collectorPanel;

    public JButton pasteButton;
    public JButton startButton;
    public JButton aboutButton;
    public JButton exitButton;

    public JLabel wordsLabel;
    public DefaultListModel<String> wordsModel;
    public JList<String> wordsList;
    public JScrollPane wordsScrollPane;
    
    public JButton deleteButton;
    public JButton sortButton;
    public JButton filterButton;
    public JButton saveButton;

    public StatusBar statusBar;

    public MainWindow() {

        appLabel = new JLabel("Szógyűjtő");
        urlLabel = new JLabel("URL");
        urlField = new JTextField();        

        setWordsList();

        setActionButtons();
        setListButtons();

        setPanelLayouts();
        setPanelComponents();
        
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        this.add(appLabel);
        this.add(urlLabel);
        this.add(urlField);
        this.add(collectorPanel);
        this.add(bottomPanel);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        /**
         * A pack() után kell szerepeljen, mert az ablak mérete
         * csak az után van meg.
         */
        statusBar = new StatusBar(this.getWidth());
        this.add(statusBar);

    }

    private void setPanelComponents() {

        collectorPanel.add(pasteButton);
        collectorPanel.add(startButton);
        collectorPanel.add(aboutButton);
        collectorPanel.add(exitButton);

        listPanel.add(wordsLabel);
        listPanel.add(wordsScrollPane);

        listButtonsPanel.add(Box.createVerticalGlue());
        listButtonsPanel.add(Box.createVerticalGlue());
        listButtonsPanel.add(deleteButton);
        listButtonsPanel.add(Box.createVerticalGlue());
        listButtonsPanel.add(sortButton);
        listButtonsPanel.add(Box.createVerticalGlue());
        listButtonsPanel.add(filterButton);
        listButtonsPanel.add(Box.createVerticalGlue());
        listButtonsPanel.add(saveButton);
        listButtonsPanel.add(Box.createVerticalGlue());
        listButtonsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        bottomPanel.add(listPanel);
        bottomPanel.add(listButtonsPanel);



    }

    private void setWordsList() {

        wordsLabel = new JLabel("Talált szavak");
        wordsModel = new DefaultListModel<>();
        wordsList = new JList<>(wordsModel);
        wordsScrollPane = new JScrollPane(wordsList);

    }

    private void setPanelLayouts() {

        collectorPanel = new JPanel();
        collectorPanel.setLayout(new BoxLayout(collectorPanel, BoxLayout.LINE_AXIS));

        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));

        listButtonsPanel = new JPanel();
        listButtonsPanel.setLayout(new BoxLayout(listButtonsPanel, BoxLayout.PAGE_AXIS));

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));

    }

    private void setActionButtons() {

        pasteButton = new JButton("Beillesztés");
        startButton = new JButton("Start");
        aboutButton = new JButton("Névjegy");
        exitButton = new JButton("Kilépés");

    }

    private void setListButtons() {
        deleteButton = new JButton("Törlés");
        setButtonSize(deleteButton);
        // deleteButton.setMargin(new Insets(20, 20, 20, 20));

        sortButton = new JButton("Kisbetű");
        setButtonSize(sortButton);
        
        filterButton = new JButton("Szűrés");
        setButtonSize(filterButton);

        saveButton = new JButton("Mentés");
        setButtonSize(saveButton);

    }

    private void setButtonSize (JButton button) {

        button.setMinimumSize(new Dimension(110, 25));
        button.setMaximumSize(new Dimension(110, 25));
        button.setPreferredSize(new Dimension(110, 25));
        
    }
 
}
