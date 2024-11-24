package za.tut.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fredre
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.tut.models.Announcement;

public class AnnounceGUI extends JFrame {
    private JTextPane announcementTextPane;
    private JComboBox<String> courseComboBox;
    private JRadioButton campus1RadioButton;
    private JRadioButton campus2RadioButton;
    private JRadioButton campus3RadioButton;

    public AnnounceGUI() {
        setTitle("Announcement App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout manager
        setLayout(new GridLayout(4, 1));

        // Text Pane for announcement
        announcementTextPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(announcementTextPane);
        add(scrollPane);

        // Combo box for course selection
        courseComboBox = new JComboBox<>(new String[]{
                "Programming 1", "Algorithms 1", "AOP316D", "AOR316D"
        });
        add(courseComboBox);

        // Radio buttons for campus selection
        JPanel campusPanel = new JPanel();
        campusPanel.setLayout(new GridLayout(1, 3));
        campus1RadioButton = new JRadioButton("Campus 1");
        campus2RadioButton = new JRadioButton("Campus 2");
        campus3RadioButton = new JRadioButton("Campus 3");

        ButtonGroup campusGroup = new ButtonGroup();
        campusGroup.add(campus1RadioButton);
        campusGroup.add(campus2RadioButton);
        campusGroup.add(campus3RadioButton);

        campusPanel.add(campus1RadioButton);
        campusPanel.add(campus2RadioButton);
        campusPanel.add(campus3RadioButton);

        add(campusPanel);

        // Post, Clear, and Exit buttons
        JPanel buttonPanel = new JPanel();
        JButton postButton = new JButton("Post Announcement");
        JButton clearButton = new JButton("Clear");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(postButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        add(buttonPanel);

        // Button action listeners
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String announcementText = announcementTextPane.getText();
                String course = (String) courseComboBox.getSelectedItem();
                String campus = campus1RadioButton.isSelected() ? "Campus 1" :
                        campus2RadioButton.isSelected() ? "Campus 2" : "Campus 3";

                Announcement announcement = new Announcement(announcementText, course, campus);
                
                //Write the code to save to file !
                JFileChooser fc = new JFileChooser();
                int val = fc.showSaveDialog(AnnounceGUI.this);
                if(val == JFileChooser.APPROVE_OPTION)
                {
                    File file = fc.getSelectedFile();
                    BufferedWriter bw;
                    try {
                        bw = new BufferedWriter(new FileWriter(file,true));
                        bw.write(announcement.toString());
                        
                        bw.newLine();
                       
                        bw.close();
                        
                        JOptionPane.showMessageDialog(null, announcement.toString(), "Posted Announcement", JOptionPane.INFORMATION_MESSAGE);
                       
                    } catch (IOException ex) {
                        Logger.getLogger(AnnounceGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                announcementTextPane.setText("");
                courseComboBox.setSelectedIndex(0);
                campusGroup.clearSelection();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}