// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);

    private String[] choices = {"Select Exercise:","Cycle","Sprint","Swim"};
    private JComboBox dropDown = new JComboBox<String>(choices);

    private JTextField terrain = new JTextField(6);
    private JTextField tempo = new JTextField(6);
    private JTextField repetitions = new JTextField(3);
    private JTextField recovery = new JTextField(2);
    private JTextField where = new JTextField(5);

    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");

    private JLabel labterrain = new JLabel(" Terrain:");
    private JLabel labtempo = new JLabel(" Tempo:");
    private JLabel labrep = new JLabel(" Repetitions:");
    private JLabel labreco = new JLabel(" Recovery:");
    private JLabel labwhe = new JLabel(" Where:");

    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find All By Date");
    private JButton weeklyDistance = new JButton("Weekly Distance");
    private JButton findAllByName = new JButton("Find All By Name");
    private JButton remove = new JButton("Remove");

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    private boolean hasAlreadyRan = false;

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();

        // Uncomment code below to test weekly distance button and change hasAlreadyRan to true.
/*
        SwimEntry swim = new SwimEntry("Bob",1,2,3,4,5,6,36,"pool");
        applic.setDropDownValue(3);
        applic.fillDisplay(swim);
        applic.addEntry("generic");

        SwimEntry swim2 = new SwimEntry("Bob",2,2,3,4,5,6,42,"pool");
        applic.setDropDownValue(3);
        applic.fillDisplay(swim2);
        applic.addEntry("generic");

        SwimEntry swim3 = new SwimEntry("Bob",3,2,3,4,5,6,23,"pool");
        applic.setDropDownValue(3);
        applic.fillDisplay(swim3);
        applic.addEntry("generic");

        Cycle cycle = new Cycle("Bob",4,2,3,4,5,6,2,"asphalt","moderate");
        applic.setDropDownValue(1);
        applic.fillDisplay(cycle);
        applic.addEntry("generic");

        Cycle cycle2 = new Cycle("Bob",5,2,3,4,5,6,15,"asphalt","moderate");
        applic.setDropDownValue(1);
        applic.fillDisplay(cycle2);
        applic.addEntry("generic");

        Cycle cycle3 = new Cycle("Bob",6,2,3,4,5,6,12,"asphalt","moderate");
        applic.setDropDownValue(1);
        applic.fillDisplay(cycle3);
        applic.addEntry("generic");

        Sprint sprint = new Sprint("Bob",7,2,3,4,5,6,4,4,5);
        applic.setDropDownValue(2);
        applic.fillDisplay(sprint);
        applic.addEntry("generic");

        Sprint sprint2 = new Sprint("Bob",8,2,3,4,5,6,72,4,5);
        applic.setDropDownValue(2);
        applic.fillDisplay(sprint2);
        applic.addEntry("generic");

        Sprint sprint3 = new Sprint("Bob",9,2,3,4,5,6,7,4,5);
        applic.setDropDownValue(2);
        applic.fillDisplay(sprint3);
        applic.addEntry("generic");
 */
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(dropDown);
        dropDown.addActionListener(this);
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(labterrain);
        add(terrain);
        terrain.setEditable(true);
        labterrain.setVisible(false);
        terrain.setVisible(false);
        add(labtempo);
        add(tempo);
        tempo.setEditable(true);
        labtempo.setVisible(false);
        tempo.setVisible(false);
        add(labrep);
        add(repetitions);
        repetitions.setEditable(true);
        labrep.setVisible(false);
        repetitions.setVisible(false);
        add(labreco);
        add(recovery);
        recovery.setEditable(true);
        labreco.setVisible(false);
        recovery.setVisible(false);
        add(labwhe);
        add(where);
        labwhe.setVisible(false);
        where.setVisible(false);
        add(addR);
        addR.addActionListener(this);
        add(remove);
        remove.addActionListener(this);
        remove.setEnabled(false);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        lookUpByDate.setEnabled(false);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        findAllByDate.setEnabled(false);
        add(findAllByName);
        findAllByName.addActionListener(this);
        findAllByName.setEnabled(false);
        add(weeklyDistance);
        weeklyDistance.addActionListener(this);
        weeklyDistance.setEnabled(false);
        add(outputArea);
        outputArea.setEditable(false);
        outputArea.setBackground(Color.BLACK);
        outputArea.setForeground(Color.green);
        setSize(720, 250);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
            if(!hasAlreadyRan && !message.equals("Something went wrong, please try again.")
                    && !message.equals("Please enter a valid date!")
                    && !message.contains("No Duplicates Allowed!")
                    && !message.equals("Select an exercise using the drop down menu!")){
                hasAlreadyRan = true;
                remove.setEnabled(true);
                lookUpByDate.setEnabled(true);
                findAllByDate.setEnabled(true);
                findAllByName.setEnabled(true);
                weeklyDistance.setEnabled(true);
            }
        }
        if (event.getSource() == remove) {
            message = removeEntry();
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate) {
            message = lookUpAllEntries();
        }
        if (event.getSource() == findAllByName) {
            message = findAllEntriesByName();
        }
        if (event.getSource() == weeklyDistance) {
            message = getWeeklyDistance();
        }
        // Show the correct corresponding fields needed for that exercise.
        if (event.getSource() == dropDown) {
            // Check that an activity is selected in the dropdown menu.
            if (!isActivitySelected()) {
                message = "Select an exercise using the drop down menu!";
            }
            // Check that program has already ran successfully (i.e. an entry has been added).
            if (hasAlreadyRan) {
                // Set the buttons to now be enabled as there is data which can be used.
                remove.setEnabled(true);
                lookUpByDate.setEnabled(true);
                findAllByDate.setEnabled(true);
                findAllByName.setEnabled(true);
                weeklyDistance.setEnabled(true);
            }
            // Run through which activity is selected and show the corresponding fields.
            if (dropDown.getSelectedItem().equals("Cycle")) {
                setVisibleFalse("Cycle");
                setVisibleTrue("Cycle");
            } else if (dropDown.getSelectedItem().equals("Sprint")) {
                setVisibleFalse("Sprint");
                setVisibleTrue("Sprint");
            } else if (dropDown.getSelectedItem().equals("Swim")) {
                setVisibleFalse("Swim");
                setVisibleTrue("Swim");
            }
        }
        // Check the message, and set the colour to be red if it is an error, or green if it is not.
        checkMessageSetColour(message);
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    /**
     * This method will calculate the weekly distance for an athlete given a name,
     * day, month and year to begin with.
     * @return The total distance covered by that athlete for a week block.
     */
    private String getWeeklyDistance() {
        try {
            // Collect the input from the GUI.
            String n = name.getText().toUpperCase();
            String mon = month.getText();
            String da = day.getText();
            String yea = year.getText();
            // Check Entry boxes are not null or empty.
            if (n == null || n.trim().isEmpty()
                    || mon == null || mon.trim().isEmpty()
                    || da == null || da.trim().isEmpty()
                    || yea == null || yea.trim().isEmpty()) {
                throw new Exception();
            }
            // Change the string values into integers for day, month and year.
            int m = Integer.parseInt(mon);
            int d = Integer.parseInt(da);
            int y = Integer.parseInt(yea);

            // Check that the date is valid.
            if (!isDateValid(d+"/"+m+"/"+y)){
                return "Please enter a valid date!";
            }
            // Pass the data to the function and store the returned value as the message.
            String message = myAthletes.getWeeklyDistance(n,d,m,y);
            return message;
        } catch (Exception e) {
            return "Something went wrong, please try again.";
        }
    }

    /**
     * This method will check the message passed to it and set the foreground colour
     * of the output area to GREEN if the message is a non-error message,
     * or it will set the foreground colour to RED if it is an error message.
     * @param message a string which can be a success message or an error message.
     */
    private void checkMessageSetColour(String message){
        // Set out what errors need to be caught.
        String[] errors = {"Something went wrong, please try again.","Select an exercise using the drop down menu!",
                "Please enter a valid date!","No Duplicates Allowed!",
                "Something went wrong when checking for duplicate records, please try again.",
                "No entries found..."};
        // Loop through the errors and catch a match if found.
        for (String error:errors) {
            if (error.contains(message)){
                outputArea.setForeground(Color.RED);
                break;
            } else {
                outputArea.setForeground(Color.GREEN);
            }
        }
    }

    /**
     *  This will set the corresponding input fields and labels as visible entities
     *  for a given exercise.
     * @param exercise takes input as a string.
     */
    private void setVisibleTrue(String exercise) {
        // Determine which exercise is selected.
        switch (exercise) {
            case "Cycle":
                labterrain.setVisible(true);
                terrain.setVisible(true);
                labtempo.setVisible(true);
                tempo.setVisible(true);
                break;
            case "Sprint":
                labrep.setVisible(true);
                repetitions.setVisible(true);
                labreco.setVisible(true);
                recovery.setVisible(true);
                break;
            case "Swim":
                labwhe.setVisible(true);
                where.setVisible(true);
                break;
        }
    }

    /**
     * This will set the corresponding input fields and labels as hidden entities
     * for a given exercise.
     * @param exercise takes input as a string.
     */
    private void setVisibleFalse(String exercise) {
        // Determine which exercise is selected.
        switch (exercise) {
            case "Cycle":
                labrep.setVisible(false);
                repetitions.setVisible(false);
                labreco.setVisible(false);
                recovery.setVisible(false);
                labwhe.setVisible(false);
                where.setVisible(false);
                break;
            case "Sprint":
                labterrain.setVisible(false);
                terrain.setVisible(false);
                labtempo.setVisible(false);
                tempo.setVisible(false);
                labwhe.setVisible(false);
                where.setVisible(false);
                break;
            case "Swim":
                labrep.setVisible(false);
                repetitions.setVisible(false);
                labreco.setVisible(false);
                recovery.setVisible(false);
                labterrain.setVisible(false);
                terrain.setVisible(false);
                labtempo.setVisible(false);
                tempo.setVisible(false);
                break;
        }
    }

    /**
     * This will determine if an exercise has been chosen in the dropdown field.
     * @return true if an exercise is selected, false if no exercise is selected.
     */
    private Boolean isActivitySelected() {
        if (dropDown.getSelectedItem().equals("Select Exercise:")){
            return false;
        }
        return true;
    }

    /**
     * This will take the user input from the GUI and remove the corresponding
     * entry that is found in the stored list.
     * @return a message after an attempt is made to delete an entry.
     */
    public String removeEntry() {
        try {
            // Collect the input from the GUI.
            String n = name.getText().toUpperCase();
            String mon = month.getText();
            String da = day.getText();
            String yea = year.getText();
            // Check Entry boxes are not null or empty.
            if (n == null || n.trim().isEmpty()
                    || mon == null || mon.trim().isEmpty()
                    || da == null || da.trim().isEmpty()
                    || yea == null || yea.trim().isEmpty()) {
                throw new Exception();
            }
            // Change the string values into integers for day, month and year.
            int m = Integer.parseInt(mon);
            int d = Integer.parseInt(da);
            int y = Integer.parseInt(yea);

            // Attempt to remove the entry and catch the message piped back.
            String message = myAthletes.removeEntry(n,d,m,y);
            // Reset the dropdown to force the user to select a value each time.
            dropDown.setSelectedIndex(0);
            return message;
        } catch (Exception e) {
            return "Something went wrong, please try again.";
        }
    }

    /**
     * This will take the user input from the GUI and add the
     * entry to the stored list.
     * @param what the entry is.
     * @return a message either confirming that it has been added, or raise an error due to illegal parameters.
     */
    public String addEntry(String what) {
        try {
            // Check that an activity is selected
            if (!isActivitySelected()) {
                return "Select an exercise using the drop down menu!";
            }
            String message = "Record added\n";
            System.out.println("Adding "+what+" entry to the records");

            // Set local variables by getting user input
            String n = name.getText().toUpperCase();
            String mon = month.getText();
            String da = day.getText();
            String yea = year.getText();
            String distance = dist.getText();
            String hour = hours.getText();
            String min = mins.getText();
            String sec = secs.getText();
            String terr = terrain.getText();
            String temp = tempo.getText();
            String rep = repetitions.getText();
            String rec = recovery.getText();
            String whe = where.getText();

            // Check Entry boxes are not null or empty
            if (n == null || n.trim().isEmpty()
                    || mon == null || mon.trim().isEmpty()
                    || da == null || da.trim().isEmpty()
                    || yea == null || yea.trim().isEmpty()
                    || distance == null || distance.trim().isEmpty()
                    || hour == null || hour.trim().isEmpty()
                    || min == null || min.trim().isEmpty()
                    || sec == null || sec.trim().isEmpty()) {
                throw new Exception();
            }
            // Parse string values to numbers
            int m = Integer.parseInt(mon);
            int d = Integer.parseInt(da);
            int y = Integer.parseInt(yea);
            float km = java.lang.Float.parseFloat(distance);
            int h = Integer.parseInt(hour);
            int mm = Integer.parseInt(min);
            int s = Integer.parseInt(sec);

            // Check that the date is a valid date
            if (!isDateValid(d+"/"+m+"/"+y)) {
                return "Please enter a valid date!";
            }

            // Check for duplicate entries
            if (anyDuplicateEntries(n,d,m,y)) {
                return "No Duplicates Allowed!\n" +
                        "Records already exist with..."+
                        "\nName:\t"+n+
                        "\nDay:\t"+d+
                        "\nMonth:\t"+m+
                        "\nYear:\t"+y;
            }

            // Add the correct record since validation has been passed
            switch (dropDown.getSelectedItem().toString()) {
                case "Cycle":
                    Cycle cycle = new Cycle(n,d,m,y,h,mm,s,km,terr,temp);
                    myAthletes.addEntry(cycle);
                    break;
                case "Sprint":
                    int reps = Integer.parseInt(rep);
                    int reco = Integer.parseInt(rec);
                    Sprint sprint = new Sprint(n,d,m,y,h,mm,s,km,reps,reco);
                    myAthletes.addEntry(sprint);
                    break;
                case "Swim":
                    SwimEntry sw = new SwimEntry(n,d,m,y,h,mm,s,km,whe);
                    myAthletes.addEntry(sw);
                    break;
            }
            // Reset the drop down selected value
            dropDown.setSelectedIndex(0);
            return message;
        }catch (Exception e) {
            return "Something went wrong, please try again.";
        }

    }

    /**
     * This method checks if a date is valid in the format dd/mm/yyyy.
     * @param date a string in the date format "dd/mm/yyyy".
     * @return true if the date is valid, false if invalid.
     */
    public static boolean isDateValid(String date){
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * This will check for any duplicate entries given the parameters.
     * @param name a string determining the name of an athlete.
     * @param day an integer determining the day the exercise took place.
     * @param month an integer determining the month the exercise took place.
     * @param year an integer determining the year the exercise took place.
     * @return true if duplicate entries exist, false if no duplicate entries exist.
     */
    public boolean anyDuplicateEntries(String name, int day, int month, int year){
        try {
            outputArea.setText("Checking for duplicate records...");
            String message = myAthletes.checkForDuplicates(name,day,month,year);
            if (message.equals("No entries found...")){
                return false;
            }
            return true;
        } catch (Exception e) {
            outputArea.setText("Something went wrong when checking for duplicate records, please try again.");
            return false;
        }
    }

    /**
     * This method will find a single record given a day, month and year.
     * @return a string of a single matching record or that no entries were found.
     */
    public String lookupEntry() {
        try {
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            outputArea.setText("looking up record ...");
            String message = myAthletes.lookupEntry(d, m, y);
            return message;
        } catch (Exception e) {
            return "Something went wrong, please try again.";
        }
    }

    /**
     * This method will find all records given a day, month and year.
     * @return a string of any and all matching records or that no entries were found.
     */
    public String lookUpAllEntries() {
        try {
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            outputArea.setText("looking up record ...");
            String message = myAthletes.lookUpAllEntries(d, m, y);
            return message;
        } catch (Exception e) {
            return "Something went wrong, please try again.";
        }
    }

    /**
     * This method will find all records given a day.
     * @return a string of any and all matching records or that no entries were found.
     */
    public String findAllEntriesByName() {
        try {
            String n = name.getText();
            outputArea.setText("looking up records...");
            String message = myAthletes.findAllByName(n);
            return message;
        }  catch (Exception e) {
            return "Something went wrong, please try again.";
        }
    }

    /**
     * Clear the display on the GUI.
     */
    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        terrain.setText("");
        tempo.setText("");
        where.setText("");
        repetitions.setText("");
        recovery.setText("");
    }// blankDisplay

    /**
     * Overloading being used for FillDisplay to handle different inputs and differing entry points.
     */
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

    public void fillDisplay(Sprint ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
        repetitions.setText(String.valueOf(ent.getRepetitions()));
        recovery.setText(String.valueOf(ent.getRecovery()));
    }

    public void fillDisplay(Cycle ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
        terrain.setText(String.valueOf(ent.getTerrain()));
        tempo.setText(String.valueOf(ent.getTempo()));
    }

    public void fillDisplay(SwimEntry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
        where.setText(String.valueOf(ent.getWhere()));
    }

    // used for testing
    public void setDropDownValue(int position) {
        dropDown.setSelectedIndex(position);
    }

} // TrainingRecordGUI

