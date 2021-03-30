// This class holds information about a single Running session.
package com.stir.cscu9t4practical1;

import java.time.LocalTime;

public class Run extends Entry{

    private String weather;
    private LocalTime startTime;
    private LocalTime endTime;

    /**
     * This is the constructor for Run.
     * @param n is a string value of a name.
     * @param d is an integer value of a day.
     * @param m is an integer value of a month.
     * @param y is an integer value of a year.
     * @param h is an integer value of an hour.
     * @param min is an integer value of a minute.
     * @param s is an integer value of a second.
     * @param dist is a float value of a distance.
     * @param w is a string value of the weather during the activity.
     * @param sTime is a localtime value which indicates the start time of the run.
     * @param eTime is a localtime value which indicates the end time of the run.
     */
    public Run (String n, int d, int m, int y, int h, int min, int s, float dist, String w, LocalTime sTime, LocalTime eTime) {
        super(n,d,m,y,h,min,s,dist);
        weather = w;
        startTime = sTime;
        endTime = eTime;
    }

    /**
     * This method gets what the weather was like during the run.
     * @return a string of what the weather was like.
     */
    public String getWeather() {
        return weather;
    }

    /**
     * This method sets what the weather was like during the run.
     * @param weather is a string of what the weather was like.
     */
    public void setWeather(String weather) {
        this.weather = weather;
    }

    /**
     * This method gets what the start time of the run is.
     * @return a localtime value of the start time for the run.
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * This method sets the start time of the run.
     * @param startTime is a localtime value of the start time for the run.
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /**
     * This method gets what the end time of the run is.
     * @return a localtime value of the end time for the run.
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * This method sets what the end time of the run is.
     * @param endTime a localtime value of the end time for the run.
     */
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    /**
     * This method overrides the get entry method in the Entry class.
     * @return a string value of the details of this run entry.
     */
    public String getRun() {
        return "The run had " + weather + " weather.\n" +
                "It covered a distance of " + super.getDistance() + "km.\n" +
                "The date was: " + super.getDate() +
                "\nStart time: " + startTime +
                "\nFinishing time: " + endTime;
    }
}
