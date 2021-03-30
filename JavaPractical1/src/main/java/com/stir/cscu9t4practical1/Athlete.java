// This class holds information about a single Athlete.
package com.stir.cscu9t4practical1;

public class Athlete {
    private String forename;
    private String surname;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    /**
     * This is the constructor for Athlete.
     * @param fn is a string value of a first name.
     * @param sn is a string value of a second name.
     * @param dayOB is an integer value of the day of birth.
     * @param monthOB is an integer value of the month of birth.
     * @param yearOB is an integer value of the year of birth.
     */
    public Athlete(String fn, String sn, int dayOB, int monthOB, int yearOB) {
        forename = fn;
        surname = sn;
        dayOfBirth = dayOB;
        monthOfBirth = monthOB;
        yearOfBirth = yearOB;
    }

    /**
     * This method will get the forename of an athlete.
     * @return a string value of the forename of the athlete.
     */
    public String getForename() {
        return forename;
    }

    /**
     * This method will set the forename of an athlete.
     * @param forename a string value of the forename of the athlete.
     */
    public void setForename(String forename) {
        this.forename = forename;
    }

    /**
     * This method will get the surname of an athlete.
     * @return a string value of the surname of the athlete.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * This method will set the surname of an athlete.
     * @param surname a string value of the surname of the athlete.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * This method will get the full name of an athlete.
     * @return a string value of the full name of the athlete.
     */
    public String getFullName() { return forename + " " + surname;}

    /**
     * This method will get the day of birth of an athlete.
     * @return an integer value of the day of birth of the athlete.
     */
    public int getDayOfBirth() {
        return dayOfBirth;
    }

    /**
     * This method will set the day of birth of an athlete.
     * @param dayOfBirth an integer value of the day of birth of the athlete.
     */
    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    /**
     * This method will get the month of birth of an athlete.
     * @return an integer value of the month of birth of the athlete.
     */
    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    /**
     * This method will set the month of birth of an athlete.
     * @param monthOfBirth an integer value of the month of birth of the athlete.
     */
    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    /**
     * This method will get the year of birth of an athlete.
     * @return an integer value of the year of birth of the athlete.
     */
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    /**
     * This method will set the year of birth of an athlete.
     * @param yearOfBirth\ an integer value of the year of birth of the athlete.
     */
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    /**
     * This method overrides the get entry method in the Entry class.
     * @return a string value of the details of this athlete entry.
     */
    public String getAthlete() {
        return "This athlete is called " + forename + " " + surname +
                ".\nThey were born on " + dayOfBirth + "/" + monthOfBirth + "/" + yearOfBirth;
    }
}
