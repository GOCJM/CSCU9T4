package com.stir.cscu9t4practical1;

public class Cycle extends Entry{

    private String terrain;
    private String tempo;

    /**
     * This is the constructor for Cycle.
     * @param n is a string value of a name.
     * @param d is an integer value of a day.
     * @param m is an integer value of a month.
     * @param y is an integer value of a year.
     * @param h is an integer value of an hour.
     * @param min is an integer value of a minute.
     * @param s is an integer value of a second.
     * @param dist is a float value of a distance.
     * @param ter is a string value of the terrain.
     * @param temp is a string value of the tempo.
     */
    public Cycle(String n, int d, int m, int y, int h, int min, int s, float dist, String ter, String temp) {
        super(n,d,m,y,h,min,s,dist);
        terrain = ter;
        tempo = temp;
    }

    /**
     * This method gets the terrain for this cycle entry.
     * @return a string value of the terrain for this cycle entry.
     */
    public String getTerrain() {
        return terrain;
    }

    /**
     * This method sets the terrain for this cycle entry.
     * @param terrain a string value of the terrain for this cycle entry.
     */
    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    /**
     * This method gets the tempo for this cycle entry.
     * @return a string value of the tempo for this cycle entry.
     */
    public String getTempo() {
        return tempo;
    }

    /**
     * This method sets the tempo for this cycle entry.
     * @param tempo a string value of the tempo for this cycle entry.
     */
    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    /**
     * This method overrides the get entry method in the Entry class.
     * @return a string value of the details of this cycle entry.
     */
    @Override
    public String getEntry() {
        return getName() + " cycled " +
                getDistance() + " km in "
                + getHour()+":"+getMin()+":"+ getSec() + " on "
                +getDay()+"/"+getMonth()+"/"+getYear()+
                " on "+getTerrain()+" at "+getTempo()+" tempo\n";
    }
}
