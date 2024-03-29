/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author saemundur
 */
public class SprintEntryTest {

    public SprintEntryTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Sprint.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Sprint instance = new Sprint("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        String expResult = "Alice";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class Sprint.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        Sprint instance = new Sprint("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 1;
        int result = instance.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonth method, of class Sprint.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        Sprint instance = new Sprint("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 2;
        int result = instance.getMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class Sprint.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Sprint instance = new Sprint("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 2003;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHour method, of class Sprint.
     */
    @Test
    public void testGetHour() {
        System.out.println("getHour");
        Sprint instance = new Sprint("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 0;
        int result = instance.getHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMin method, of class Sprint.
     */
    @Test
    public void testGetMin() {
        System.out.println("getMin");
        Sprint instance = new Sprint("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 16;
        int result = instance.getMin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSec method, of class Sprint.
     */
    @Test
    public void testGetSec() {
        System.out.println("getSec");
        Sprint instance = new Sprint("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 7;
        int result = instance.getSec();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistance method, of class Sprint.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        Sprint instance = new Sprint("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        float expResult = 300;
        float result = instance.getDistance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getRepetitions method of class Sprint
     */
    @Test
    public void testGetRepetitions() {
        System.out.println("getRepetitions");
        Sprint instance = new Sprint("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 4;
        int result = instance.getRepetitions();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRepetitions method of class Sprint
     */
    @Test
    public void testSetRepetitions() {
        System.out.println("setRepetitions");
        Sprint instance = new Sprint("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 10;
        instance.setRepetitions(10);
        int result = instance.getRepetitions();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRecovery method of class Sprint
     */
    @Test
    public void testGetRecovery() {
        System.out.println("getRecovery");
        Sprint instance = new Sprint("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 2;
        int result = instance.getRecovery();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRecovery method of class Sprint
     */
    @Test
    public void testSetRecovery() {
        System.out.println("setRecovery");
        Sprint instance = new Sprint("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 5;
        instance.setRecovery(5);
        int result = instance.getRecovery();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntry method, of class Sprint.
     */
    @Test
    public void testGetEntry() {
        System.out.println("getEntry");
        Sprint instance = new Sprint("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        String expResult = "Alice sprinted 4x300m in 0:16:7 with 2 minutes recovery on 1/2/2003\n";
        String result = instance.getEntry();
        assertEquals(expResult, result);
    }

}