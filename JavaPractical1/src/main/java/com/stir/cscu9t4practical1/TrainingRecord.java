// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TrainingRecord {
    private List<Entry> tr;

    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor

    // add a record to the list
    public void addEntry(Entry e){
        String message = checkForDuplicates(e.getName(),e.getDay(),e.getMonth(),e.getYear());
        if (message.contains("No entries found...")) {
            tr.add(e);
        }
    } // addClass

    // delete entry of a given name, day, month and year
    public String removeEntry(String n, int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found for deletion...";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getName().equals(n) && current.getDay()==d && current.getMonth()==m && current.getYear()==y) {
                iter.remove();
                result = "Entry has been successfully deleted.";
            }
        }
        return result;
    } // removeEntry

    // look up the entry of a given day and month
    public String lookupEntry (int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found...";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay()==d && current.getMonth()==m && current.getYear()==y)
                result = current.getEntry();
        }
        return result;
    } // lookupEntry

    /**
     * This method will find multiple entries if they exist given a day, month and year.
     * @param d is an integer value of a day.
     * @param m is an integer value of a month.
     * @param y is an integer value of a year.
     * @return a string of multiple matches if they exist or that no entries were found.
     */
    public String lookUpAllEntries (int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found...";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) {
                if (result.equals("No entries found...")){
                    result = "";
                }
                result += current.getEntry();
            }
        }
        return result;
    }

    // Count the number of entries
    public int getNumberOfEntries(){
        return tr.size();
    }
    // Clear all entries
    public void clearAllEntries(){
        tr.clear();
    }

    /**
     * This method will find multiple entries if they exist given a name.
     * @param n is a string value of a name.
     * @return a string of multiple matches if they exist or that no entries were found.
     */
    public String findAllByName(String n) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found...";
        while (iter.hasNext()) {
            Entry current = iter.next();
            // Using regular expressions to match the name partially and/or fully to the given parameter.
            if (current.getName().toLowerCase(Locale.ROOT).matches(".*"+n.toLowerCase(Locale.ROOT)+".*")) {
                if (result.equals("No entries found...")){
                    result = "";
                }
                result += current.getEntry();
            }
        }
        // If the name passed is an empty string then return all results.
        if (n.equals("")) {
            return "--------------------------------------------------------------\n"+
                    "An empty string was input, so here is a list of all records:\n"+
                    "--------------------------------------------------------------\n"+result;
        }
        return result;
    }

    /**
     * This method will check for any current existing records given a name, day, month and year.
     * @param name is a string value of a name.
     * @param day is an integer value of a day.
     * @param month is an integer value of a month.
     * @param year is an integer value of a year.
     * @return a string of a match indicating that a record already exists, or that no entries were found.
     */
    public String checkForDuplicates(String name, int day, int month, int year) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found...";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getName().equals(name) && current.getDay()==day && current.getMonth()==month && current.getYear()==year) {
                if (result.equals("No entries found...")){
                    result = "";
                }
                result += current.getEntry();
            }
        }
        return result;
    }

    /**
     * This method will calculate the weekly distance for a given name and beginning the week on a given date.
     * @param name is a string value of a name.
     * @param day is an integer value of a day.
     * @param month is an integer value of a month.
     * @param year is an integer value of a year.
     * @return a string of the distance covered by an athlete over a weeks period, or that no entries were found.
     * @throws ParseException
     */
    public String getWeeklyDistance(String name, int day, int month, int year) throws ParseException {
        // Ensure that the date given is a valid date.
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        Date date = df.parse(day+"/"+month+"/"+year);
        long millis = date.getTime();
        final long millisOfDay = 1000 * 60 * 60 * 24;

        // Need to sort the array list by date so that looping through will ensure all dates in a weekly period are caught.
        Collections.sort(tr, new Comparator<Entry>() {
            @Override
            public int compare(Entry o1, Entry o2) {
                try {
                    Date compareDate1 = df.parse(o1.getDate());
                    Date compareDate2 = df.parse(o2.getDate());
                    if (compareDate1.before(compareDate2)) {
                        return -1;
                    }
                    if (compareDate1.after(compareDate2)) {
                        return 1;
                    }
                    return 0;
                } catch (ParseException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        });

        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found...";
        double sum = 0;
        int countDay = 0;

        while (iter.hasNext()) {
            Entry current = iter.next();
            long currentMillis = df.parse(current.getDate()).getTime();
                // Checks that a match exists.
                if (current.getName().matches(".*" + name + ".*") && current.getDay() == day+(countDay)  && current.getMonth() == month && current.getYear() == year) {
                    // Checks for the full week (7 days).
                    if ((currentMillis - millis) < millisOfDay * 7 ) {
                        // Keep a note of how many days have been looped through and add that to day variable on the match check.
                        countDay++;
                        sum += current.getDistance();
                        result = name + " covered a total distance of " + sum + "km across 7 days.\nThis began on " + date;
                }
            }
        }
        return result;
    }
}