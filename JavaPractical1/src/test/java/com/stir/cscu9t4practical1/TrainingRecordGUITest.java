/*
 * Test class for TrainingRecordGUI
 * It is not finished as we're not expecting you to implement GUI testing
 * However, you're welcome to use this starter template and extend it and add
 * test for public methods you implement in TrainingRecordGUI.java
 */
package com.stir.cscu9t4practical1;

import java.awt.event.ActionEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionListener;
import java.util.*;
// Only used if you want to use reflection to test private features
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JButton;




/**
 *
 * @author saemundur
 */
public class TrainingRecordGUITest {

    public TrainingRecordGUITest() {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of main method, of class TrainingRecordGUI.
     * just tests if the class can be initialised without errors
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TrainingRecordGUI.main(args);
    }

    /**
     * Test of actionPerformed method, of class TrainingRecordGUI.
     * This doesn't test anything but might be used in evaluations
     */
    @Test
    public void testActionPerformed() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("Action not performed");
    }

    /**
     * Test of blankDisplay method, of class TrainingRecordGUI.
     * It just executes the method to see if it doesn't throw an exception
     */
    @Test
    public void testBlankDisplay() {
        System.out.println("blankDisplay");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        instance.blankDisplay();
    }
    
    /**
     * Test of addEntry method, of class TrainingRecordGUI
     * 
     */
    @Test
    public void testAddEntry() {
        System.out.println("addEntry");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Entry entry = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        instance.setDropDownValue(3);
        instance.fillDisplay(entry);
        String message = instance.addEntry("generic");
        System.out.println(message);
        assertEquals(message,"Record added\n");

        Sprint sprint = new Sprint("Bob",1,2,2021,3,4,5,12,4,5);
        instance.setDropDownValue(2);
        instance.fillDisplay(sprint);
        String message2 = instance.addEntry("generic");
        System.out.println(message2);
        assertEquals(message2,"Record added\n");

        Cycle cycle = new Cycle("Dorris",2,3,2021,5,3,2,30.78f,"asphalt","moderate");
        instance.setDropDownValue(1);
        instance.fillDisplay(cycle);
        String message3 = instance.addEntry("generic");
        System.out.println(message3);
        assertEquals(message3,"Record added\n");

        SwimEntry swim = new SwimEntry("John",15,12,2020,3,12,7,10.34f,"outdoors");
        instance.setDropDownValue(3);
        instance.fillDisplay(swim);
        String message4 = instance.addEntry("generic");
        System.out.println(message4);
        assertEquals(message4,"Record added\n");
    }

    /**
     * Test of removeEntry method, of class TrainingRecordGUI
     *
     */
    @Test
    public void testRemoveEntry() {
        // Add entry to be deleted first.
        System.out.println("removeEntry");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Entry entry = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        instance.setDropDownValue(3);
        instance.fillDisplay(entry);
        String message = instance.addEntry("generic");
        System.out.println(message);
        assertEquals(message,"Record added\n");

        // Fill GUI with data to delete.
        instance.fillDisplay(entry);
        String delMessage = instance.removeEntry();
        System.out.println(delMessage);
        assertEquals("Entry has been successfully deleted.",delMessage);

        // Add entry to be deleted first.
        Sprint sprint = new Sprint("Bob",1,2,2021,3,4,5,12,4,5);
        instance.setDropDownValue(2);
        instance.fillDisplay(sprint);
        String message2 = instance.addEntry("generic");
        System.out.println(message2);
        assertEquals(message2,"Record added\n");

        // Fill GUI with data to delete.
        instance.fillDisplay(sprint);
        String delMessage2 = instance.removeEntry();
        System.out.println(delMessage2);
        assertEquals("Entry has been successfully deleted.",delMessage2);

        // Add entry to be deleted first.
        Cycle cycle = new Cycle("Dorris",2,3,2021,5,3,2,30.78f,"asphalt","moderate");
        instance.setDropDownValue(1);
        instance.fillDisplay(cycle);
        String message3 = instance.addEntry("generic");
        System.out.println(message3);
        assertEquals(message3,"Record added\n");

        // Fill GUI with data to delete.
        instance.fillDisplay(cycle);
        String delMessage3 = instance.removeEntry();
        System.out.println(delMessage3);
        assertEquals("Entry has been successfully deleted.",delMessage3);

        // Add entry to be deleted first.
        SwimEntry swim = new SwimEntry("John",15,12,2020,3,12,7,10.34f,"outdoors");
        instance.setDropDownValue(3);
        instance.fillDisplay(swim);
        String message4 = instance.addEntry("generic");
        System.out.println(message4);
        assertEquals(message4,"Record added\n");

        // Fill GUI with data to delete.
        instance.fillDisplay(swim);
        String delMessage4 = instance.removeEntry();
        System.out.println(delMessage4);
        assertEquals("Entry has been successfully deleted.",delMessage4);
    }

    /**
     * Test of the lookUpEntry method, of class TrainingRecordGUI
     */
    @Test
    public void testLookUpByDate() {
        // Add entries for data to be found.
        System.out.println("lookUpByDate");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Sprint sprint = new Sprint("Bob",1,2,2021,3,4,5,12,4,5);
        instance.setDropDownValue(2);
        instance.fillDisplay(sprint);
        String message = instance.addEntry("generic");
        System.out.println(message);
        assertEquals(message,"Record added\n");

        Cycle cycle = new Cycle("Dorris",2,3,2021,5,3,2,30.78f,"asphalt","moderate");
        instance.setDropDownValue(1);
        instance.fillDisplay(cycle);
        String message2 = instance.addEntry("generic");
        System.out.println(message2);
        assertEquals(message2,"Record added\n");

        SwimEntry swim = new SwimEntry("John",15,12,2020,3,12,7,10.34f,"outdoors");
        instance.setDropDownValue(3);
        instance.fillDisplay(swim);
        String message3 = instance.addEntry("generic");
        System.out.println(message3);
        assertEquals(message3,"Record added\n");

        // Add record to test that only one entry is shown.
        SwimEntry swim2 = new SwimEntry("Nick",15,12,2020,3,12,7,10.34f,"outdoors");
        instance.setDropDownValue(3);
        instance.fillDisplay(swim2);
        String message4 = instance.addEntry("generic");
        System.out.println(message4);
        assertEquals(message4,"Record added\n");

        // Find just Nick, and not John and Nick.
        instance.fillDisplay(swim2);
        String findMessageDuplicate = instance.lookupEntry();
        System.out.println(findMessageDuplicate);
        assertEquals("NICK swam 10.34 km outdoors in 3:12:7 on 15/12/2020\n",findMessageDuplicate);

        // Find Bob.
        instance.fillDisplay(sprint);
        String findMessage = instance.lookupEntry();
        System.out.println(findMessage);
        assertEquals("BOB sprinted 4x12m in 3:4:5 with 5 minutes recovery on 1/2/2021\n",findMessage);

        // Find Dorris.
        instance.fillDisplay(cycle);
        String findMessage2 = instance.lookupEntry();
        System.out.println(findMessage2);
        assertEquals("DORRIS cycled 30.78 km in 5:3:2 on 2/3/2021 on asphalt at moderate tempo\n",findMessage2);

        // Don't find John (As Nick was the most recently added, so will be shown first).
        instance.fillDisplay(swim);
        String findMessage3 = instance.lookupEntry();
        System.out.println(findMessage3);
        assertNotEquals("JOHN swam 10.34 km outdoors in 3:12:7 on 15/12/2020\n",findMessage3);

        // Find no entries.
        instance.fillDisplay(new SwimEntry("Tom",1,2,3,4,5,6,32,"pool"));
        String findMessage4 = instance.lookupEntry();
        System.out.println(findMessage4);
        assertEquals("No entries found...",findMessage4);
    }

    /**
     * Test of the lookUpAllEntries method, of class TrainingRecordGUI
     */
    @Test
    public void testLookUpAllByDate() {
        // Add entries for data to be found.
        System.out.println("lookUpAllByDate");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Sprint sprint = new Sprint("Bob",1,2,2021,3,4,5,12,4,5);
        instance.setDropDownValue(2);
        instance.fillDisplay(sprint);
        String message = instance.addEntry("generic");
        System.out.println(message);
        assertEquals(message,"Record added\n");

        Cycle cycle = new Cycle("Dorris",2,3,2021,5,3,2,30.78f,"asphalt","moderate");
        instance.setDropDownValue(1);
        instance.fillDisplay(cycle);
        String message2 = instance.addEntry("generic");
        System.out.println(message2);
        assertEquals(message2,"Record added\n");

        SwimEntry swim = new SwimEntry("John",15,12,2020,3,12,7,10.34f,"outdoors");
        instance.setDropDownValue(3);
        instance.fillDisplay(swim);
        String message3 = instance.addEntry("generic");
        System.out.println(message3);
        assertEquals(message3,"Record added\n");

        // Add record to test multiple entries are shown.
        SwimEntry swim2 = new SwimEntry("Nick",15,12,2020,3,12,7,10.34f,"outdoors");
        instance.setDropDownValue(3);
        instance.fillDisplay(swim2);
        String message4 = instance.addEntry("generic");
        System.out.println(message4);
        assertEquals(message4,"Record added\n");

        // Find Nick and John.
        instance.fillDisplay(swim2);
        String findMessageDuplicate = instance.lookUpAllEntries();
        System.out.println(findMessageDuplicate);
        assertEquals("JOHN swam 10.34 km outdoors in 3:12:7 on 15/12/2020\nNICK swam 10.34 km outdoors in 3:12:7 on 15/12/2020\n",findMessageDuplicate);

        // Find Bob.
        instance.fillDisplay(sprint);
        String findMessage = instance.lookUpAllEntries();
        System.out.println(findMessage);
        assertEquals("BOB sprinted 4x12m in 3:4:5 with 5 minutes recovery on 1/2/2021\n",findMessage);

        // Find Dorris.
        instance.fillDisplay(cycle);
        String findMessage2 = instance.lookUpAllEntries();
        System.out.println(findMessage2);
        assertEquals("DORRIS cycled 30.78 km in 5:3:2 on 2/3/2021 on asphalt at moderate tempo\n",findMessage2);

        // Find no entries.
        instance.fillDisplay(new SwimEntry("Tom",1,2,3,4,5,6,32,"pool"));
        String findMessage4 = instance.lookUpAllEntries();
        System.out.println(findMessage4);
        assertEquals("No entries found...",findMessage4);
    }

    /**
     * Test of the findAllEntriesByName method, of class TrainingRecordGUI
     */
    @Test
    public void testFindAllEntriesByName() {
        // Add entries for data to be found.
        System.out.println("findAllEntriesByName");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Sprint sprint = new Sprint("Bob",1,2,2021,3,4,5,12,4,5);
        instance.setDropDownValue(2);
        instance.fillDisplay(sprint);
        String message = instance.addEntry("generic");
        System.out.println(message);
        assertEquals(message,"Record added\n");

        Cycle cycle = new Cycle("Dorris",2,3,2021,5,3,2,30.78f,"asphalt","moderate");
        instance.setDropDownValue(1);
        instance.fillDisplay(cycle);
        String message2 = instance.addEntry("generic");
        System.out.println(message2);
        assertEquals(message2,"Record added\n");

        SwimEntry swim = new SwimEntry("John",15,12,2020,3,12,7,10.34f,"outdoors");
        instance.setDropDownValue(3);
        instance.fillDisplay(swim);
        String message3 = instance.addEntry("generic");
        System.out.println(message3);
        assertEquals(message3,"Record added\n");

        // Add record to test multiple entries are shown.
        SwimEntry swim2 = new SwimEntry("Dorris",15,12,2020,3,12,7,10.34f,"outdoors");
        instance.setDropDownValue(3);
        instance.fillDisplay(swim2);
        String message4 = instance.addEntry("generic");
        System.out.println(message4);
        assertEquals(message4,"Record added\n");

        // Find all records of Dorris.
        instance.fillDisplay(swim2);
        String findMessageDuplicate = instance.findAllEntriesByName();
        System.out.println(findMessageDuplicate);
        assertEquals("DORRIS cycled 30.78 km in 5:3:2 on 2/3/2021 on asphalt at moderate tempo\n" +
                "DORRIS swam 10.34 km outdoors in 3:12:7 on 15/12/2020\n",findMessageDuplicate);

        // Find Bob.
        instance.fillDisplay(sprint);
        String findMessage = instance.findAllEntriesByName();
        System.out.println(findMessage);
        assertEquals("BOB sprinted 4x12m in 3:4:5 with 5 minutes recovery on 1/2/2021\n",findMessage);

        // Find no entries.
        instance.fillDisplay(new SwimEntry("Tom",1,2,3,4,5,6,32,"pool"));
        String findMessage2 = instance.findAllEntriesByName();
        System.out.println(findMessage2);
        assertEquals("No entries found...",findMessage2);

        // Find all entries or check for Empty String as input.
        instance.blankDisplay();
        String findMessage3 = instance.findAllEntriesByName();
        System.out.println(findMessage3);
        assertEquals("--------------------------------------------------------------\n" +
                "An empty string was input, so here is a list of all records:\n" +
                "--------------------------------------------------------------\n" +
                "BOB sprinted 4x12m in 3:4:5 with 5 minutes recovery on 1/2/2021\n" +
                "DORRIS cycled 30.78 km in 5:3:2 on 2/3/2021 on asphalt at moderate tempo\n" +
                "JOHN swam 10.34 km outdoors in 3:12:7 on 15/12/2020\n" +
                "DORRIS swam 10.34 km outdoors in 3:12:7 on 15/12/2020\n",findMessage3);
    }

    /**
     * Test to see if all display requirements have been met
     */
    @Test
    public void testButtonsPresentInGUI() throws IllegalAccessException, IllegalArgumentException{
        System.out.println("Check if you have added the buttons"); 
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Class<?> instanceClass = instance.getClass();
        String[] expectedFields = {"findAllByDate","lookUpByDate","remove"}; // add RemoveEntry when it is ready
        Field fields[] = instanceClass.getDeclaredFields();
        int found = 0;
        for (Field field : fields) {
            if (Arrays.asList(expectedFields).contains(field.getName())){
                found += 1;
                field.setAccessible(true);
                assertTrue(field.get(instance) instanceof JButton);
            }
        }
        assertEquals(found,expectedFields.length,"Have you added all required buttons?");
    }
}
