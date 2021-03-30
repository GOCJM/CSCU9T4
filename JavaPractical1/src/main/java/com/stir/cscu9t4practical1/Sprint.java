package com.stir.cscu9t4practical1;

public class Sprint extends Entry{

    private int repetitions;
    private int recovery;

    /**
     * This is the constructor for Sprint.
     * @param n is a string value of a name.
     * @param d is an integer value of a day.
     * @param m is an integer value of a month.
     * @param y is an integer value of a year.
     * @param h is an integer value of an hour.
     * @param min is an integer value of a minute.
     * @param s is an integer value of a second.
     * @param dist is a float value of a distance.
     * @param reco is an integer value of the repetitions of the sprint.
     * @param reps is an integer value of the recovery time during the sprint exercise.
     */
    public Sprint(String n, int d, int m, int y, int h, int min, int s, float dist, int reps, int reco) {
        super(n,d,m,y,h,min,s,dist);
        repetitions = reps;
        recovery = reco;
    }

    /**
     * This method gets how many repetitions occurred for the sprinting activity.
     * @return an integer value of how many repetitions occurred.
     */
    public int getRepetitions() {
        return repetitions;
    }

    /**
     * This method sets how many repetitions occurred for the sprinting activity.
     * @param repetitions an integer value of how many repetitions occurred.
     */
    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    /**
     * This method gets how many minutes of recovery occurred for the sprinting activity.
     * @return an integer value of how many minutes of recovery occurred.
     */
    public int getRecovery() {
        return recovery;
    }

    /**
     * This method sets how many minutes of recovery occurred for the sprinting activity.
     * @param recovery an integer value of how many minutes of recovery occurred.
     */
    public void setRecovery(int recovery) {
        this.recovery = recovery;
    }

    /**
     * This method overrides the get entry method in the Entry class.
     * @return a string value of the details of this sprint entry.
     */
    @Override
    public String getEntry() {
        return getName() + " sprinted " +
                getRepetitions() + "x" + (int)getDistance() + "m" +
                " in " +  getHour() + ":" + getMin() + ":" + getSec() +
                " with " + getRecovery() +  " minutes recovery on " +
                getDate() + "\n";
    }
}
