package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry{

    private String where;

    /**
     * This is the constructor for SwimEntry.
     * @param n is a string value of a name.
     * @param d is an integer value of a day.
     * @param m is an integer value of a month.
     * @param y is an integer value of a year.
     * @param h is an integer value of an hour.
     * @param min is an integer value of a minute.
     * @param s is an integer value of a second.
     * @param dist is a float value of a distance.
     * @param w is a string value of where the activity took place.
     */
    public SwimEntry (String n, int d, int m, int y, int h, int min, int s, float dist, String w) {
        super(n,d,m,y,h,min,s,dist);
        where = w;
    }

    /**
     * This method gets where the swim took place.
     * @return a string value of where the swim took place.
     */
    public String getWhere() {
        return where;
    }

    /**
     * This method sets where the swim took place.
     * @param where is a string value of where the swim took place.
     */
    public void setWhere(String where) {
        this.where = where;
    }

    /**
     * This method overrides the get entry method in the Entry class.
     * @return a string value of the details of this swim entry.
     */
    @Override
    public String getEntry() {
        return getName() + " swam " + getDistance() + " km " +
                getWhere() + " in " +
                getHour()+":"+getMin()+":"+ getSec() + " on "
                +getDate() + "\n";
    }
}
