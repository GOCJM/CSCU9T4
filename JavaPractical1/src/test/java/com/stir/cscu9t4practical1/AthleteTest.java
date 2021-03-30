package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AthleteTest {

    private String forename;
    private String surname;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    @BeforeEach
    public void setUp() {
        forename = "Alan";
        surname = "Turing";
        dayOfBirth = 23;
        monthOfBirth = 06;
        yearOfBirth = 1912;
    }

    @Test
    public void getForename() {
        System.out.println("getForename");
        Athlete instance = new Athlete(forename,surname,dayOfBirth,monthOfBirth,yearOfBirth);
        String expResult = "Alan";
        String result = instance.getForename();
        assertEquals(expResult,result);
    }

    @Test
    public void setForename() {
        System.out.println("setForename");
        Athlete instance = new Athlete(forename,surname,dayOfBirth,monthOfBirth,yearOfBirth);
        String expResult = "Dorris";
        instance.setForename("Dorris");
        String result = instance.getForename();
        assertEquals(expResult,result);
    }

    @Test
    public void getSurname() {
        System.out.println("getSurname");
        Athlete instance = new Athlete(forename,surname,dayOfBirth,monthOfBirth,yearOfBirth);
        String expResult = "Turing";
        String result = instance.getSurname();
        assertEquals(expResult,result);
    }

    @Test
    public void setSurname() {
        System.out.println("setSurname");
        Athlete instance = new Athlete(forename,surname,dayOfBirth,monthOfBirth,yearOfBirth);
        String expResult = "Ramsay";
        instance.setSurname("Ramsay");
        String result = instance.getSurname();
        assertEquals(expResult,result);
    }

    @Test
    public void getFullName() {
        System.out.println("getFullName");
        Athlete instance = new Athlete(forename,surname,dayOfBirth,monthOfBirth,yearOfBirth);
        String expResult = "Alan Turing";
        String result = instance.getFullName();
        assertEquals(expResult,result);
    }

    @Test
    public void getDayOfBirth() {
        System.out.println("getDayOfBirth");
        Athlete instance = new Athlete(forename,surname,dayOfBirth,monthOfBirth,yearOfBirth);
        int expResult = 23;
        int result = instance.getDayOfBirth();
        assertEquals(expResult,result);
    }

    @Test
    public void setDayOfBirth() {
        System.out.println("setDayOfBirth");
        Athlete instance = new Athlete(forename,surname,dayOfBirth,monthOfBirth,yearOfBirth);
        int expResult = 04;
        instance.setDayOfBirth(04);
        int result = instance.getDayOfBirth();
        assertEquals(expResult,result);
    }

    @Test
    public void getMonthOfBirth() {
        System.out.println("getMonthOfBirth");
        Athlete instance = new Athlete(forename,surname,dayOfBirth,monthOfBirth,yearOfBirth);
        int expResult = 06;
        int result = instance.getMonthOfBirth();
        assertEquals(expResult,result);
    }

    @Test
    public void setMonthOfBirth() {
        System.out.println("setMonthOfBirth");
        Athlete instance = new Athlete(forename,surname,dayOfBirth,monthOfBirth,yearOfBirth);
        int expResult = 11;
        instance.setMonthOfBirth(11);
        int result = instance.getMonthOfBirth();
        assertEquals(expResult,result);
    }

    @Test
    public void getYearOfBirth() {
        System.out.println("getYearOfBirth");
        Athlete instance = new Athlete(forename,surname,dayOfBirth,monthOfBirth,yearOfBirth);
        int expResult = 1912;
        int result = instance.getYearOfBirth();
        assertEquals(expResult,result);
    }

    @Test
    public void setYearOfBirth() {
        System.out.println("setYearOfBirth");
        Athlete instance = new Athlete(forename,surname,dayOfBirth,monthOfBirth,yearOfBirth);
        int expResult = 2000;
        instance.setYearOfBirth(2000);
        int result = instance.getYearOfBirth();
        assertEquals(expResult,result);
    }

    @Test
    public void getAthlete() {
        System.out.println("getAthlete");
        Athlete instance = new Athlete(forename,surname,dayOfBirth,monthOfBirth,yearOfBirth);
        String expResult = "This athlete is called Alan Turing.\n" +
                "They were born on 23/6/1912";
        String result = instance.getAthlete();
        assertEquals(expResult,result);
    }
}