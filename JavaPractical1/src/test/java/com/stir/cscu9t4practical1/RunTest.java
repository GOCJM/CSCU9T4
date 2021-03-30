package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.*;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunTest {

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    private String name, weather;
    private int day, month, year, hours, minutes, seconds;
    private float distance;
    private LocalTime startTime, endTime;
    @BeforeEach
    public void setUp() {
        name = "Alan Turing";
        weather = "dry";
        day = 23;
        month = 06;
        year = 1912;
        hours = 05;
        minutes = 32;
        seconds = 54;
        distance = 15.2f;
        startTime = LocalTime.NOON;
        endTime = LocalTime.MIDNIGHT;

    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getWeather method, of class Run.
     */
    @Test
    public void testGetWeather() {
        System.out.println("getWeather");
        Run instance = new Run(name,day,month,year,hours,minutes,seconds,distance,weather,startTime,endTime);
        String expResult = "dry";
        String result = instance.getWeather();
        assertEquals(expResult,result);
    }

    /**
     * Test of setWeather method, of class Run.
     */
    @Test
    public void testSetWeather() {
        System.out.println("setWeather");
        Run instance = new Run(name,day,month,year,hours,minutes,seconds,distance,weather,startTime,endTime);
        String expResult = "wet";
        instance.setWeather("wet");
        String result = instance.getWeather();
        assertEquals(expResult,result);
    }

    /**
     * Test of getDistance method, of class Run extending Entry.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        Entry instance = new Run(name,day,month,year,hours,minutes,seconds,distance,weather,startTime,endTime);
        // The 'f' is due to the method returning a float and not a double.
        double expResult = 15.2f;
        double result = instance.getDistance();
        assertEquals(expResult,result);
    }


    /**
     * Test of getStartTime method, of class Run.
     */
    @Test
    public void testGetStartTime() {
        System.out.println("getStartTime");
        Run instance = new Run(name,day,month,year,hours,minutes,seconds,distance,weather,startTime,endTime);
        LocalTime expResult = LocalTime.NOON;
        LocalTime result = instance.getStartTime();
        // Expected of 0 means there is no difference (hence, the same).
        assertEquals(0,expResult.compareTo(result));
    }

    /**
     * Test of setStartTime method, of class Run.
     */
    @Test
    public void testSetStartTime() {
        System.out.println("setStartTime");
        Run instance = new Run(name,day,month,year,hours,minutes,seconds,distance,weather,startTime,endTime);
        LocalTime expResult = LocalTime.MIN;
        instance.setStartTime(LocalTime.MIN);
        LocalTime result = instance.getStartTime();
        // Expected of 0 means there is no difference (hence, the same).
        assertEquals(0,expResult.compareTo(result));
    }

    /**
     * Test of getEndTime method, of class Run.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        Run instance = new Run(name,day,month,year,hours,minutes,seconds,distance,weather,startTime,endTime);
        LocalTime expResult = LocalTime.MIDNIGHT;
        LocalTime result = instance.getEndTime();
        // Expected of 0 means there is no difference (hence, the same).
        assertEquals(0,expResult.compareTo(result));
    }

    /**
     * Test of setEndTime method, of class Run.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        Run instance = new Run(name,day,month,year,hours,minutes,seconds,distance,weather,startTime,endTime);
        LocalTime expResult = LocalTime.MIDNIGHT;
        instance.setEndTime(LocalTime.MIDNIGHT);
        LocalTime result = instance.getEndTime();
        // Expected of 0 means there is no difference (hence, the same).
        assertEquals(0,expResult.compareTo(result));
    }

    /**
     * Test of getRun method, of class Run.
     */
    @Test
    public void testGetRun() {
        System.out.println("getRun");
        Run instance = new Run(name,day,month,year,hours,minutes,seconds,distance,weather,startTime,endTime);
        String expResult = "The run had dry weather.\n" +
                "It covered a distance of 15.2km.\n" +
                "The date was: 23/6/1912\n" +
                "Start time: 12:00\n" +
                "Finishing time: 00:00";
        String result = instance.getRun();
        assertEquals(expResult,result);
    }
}