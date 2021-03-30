// This class holds information about a single training session
package com.stir.cscu9t4practical1;

import java.util.Calendar;
public class Entry {
  private String name;
  private Calendar dateAndTime;
  private float distance;

  /**
   * This is the constructor for Entry.
   * @param n is a string value of a name.
   * @param d is an integer value of a day.
   * @param m is an integer value of a month.
   * @param y is an integer value of a year.
   * @param h is an integer value of an hour.
   * @param min is an integer value of a minute.
   * @param s is an integer value of a second.
   * @param dist is a float value of a distance.
   */
  public Entry (String n, int d, int m, int y, int h, int min, int s, float dist) {
    name = n;
    Calendar inst = Calendar.getInstance();
    inst.set(y,m-1,d,h,min,s);
    dateAndTime = inst;
    distance = dist;
  } //constructor

  /**
   * This method gets the name of the athlete for this entry.
   * @return a string value of the athlete's name.
   */
  public String getName () {
    return name;
  } //getName

  /**
   * This method gets the day that the entry occurred.
   * @return an integer value of the day that the entry occurred.
   */
  public int getDay () {
    return dateAndTime.get(Calendar.DATE);
  } //getDay

  /**
   * This method gets the month that the entry occurred.
   * @return an integer value of the month that the entry occurred.
   */
  public int getMonth () {
    int month =  dateAndTime.get(Calendar.MONTH) + 1;
    return month;
  } //getMonth

  /**
   * This method gets the year that the entry occurred.
   * @return an integer value of the year that the entry occurred.
   */
  public int getYear () {
    return dateAndTime.get(Calendar.YEAR);
  } //getYear

  /**
   * This method gets the full date that the entry occurred.
   * @return a string value of the date that the entry occurred.
   */
  public String getDate () {return getDay()+"/"+getMonth()+"/"+getYear(); } //getDate

  /**
   * This method gets the hours of the length of time that it took to complete the entry.
   * @return an integer value of the hours of the length of time that it took to complete the entry.
   */
  public int getHour () {
    return dateAndTime.get(Calendar.HOUR);
  } //getHour

  /**
   * This method gets the minutes of the length of time that it took to complete the entry.
   * @return an integer value of the minutes of the length of time that it took to complete the entry.
   */
  public int getMin () {
    return dateAndTime.get(Calendar.MINUTE);
  } //getMin

  /**
   * This method gets the seconds of the length of time that it took to complete the entry.
   * @return an integer value of the seconds of the length of time that it took to complete the entry.
   */
  public int getSec () {
    return dateAndTime.get(Calendar.SECOND);
  } //getSec

  /**
   * This method gets the distance that the entry covered.
   * @return a float value of the distance that the entry covered.
   */
  public float getDistance () {
    return distance;
  } //getYear

  /**
   * This method gets the details of the current entry.
   * @return a string value of the details of this entry.
   */
  public String getEntry () {
   String result = getName()+" ran " + getDistance() + " km in "
             +getHour()+":"+getMin()+":"+ getSec() + " on "
             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
   return result;
  } //getEntry
   
} // Entry