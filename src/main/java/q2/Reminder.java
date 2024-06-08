/*
 * @package javafx.maman14q2
 *
 * Represents an application for managing reminders associated with different dates.
 *
 * @author Elad Reuveny
 */
package q2;

import java.io.Serializable;
import java.util.HashMap;

public class Reminder implements Serializable {
    private HashMap <Date, String> reminders;

    /**
     * Constructs a new Reminder object.
     */
    public Reminder() {
        reminders = new HashMap<Date, String>();
    }

    /**
     * Adds a reminder for the specified date.
     *
     * @param date the date for the reminder
     * @param s the reminder text
     */
    public void addReminder(Date date, String s) {
        reminders.put(date, s);
    }

    /**
     * Retrieves the reminder for the specified date.
     *
     * @param date the date to retrieve the reminder for
     * @return the reminder text for the specified date, or a message indicating no reminder is found
     */
    public String getReminder(Date date) {
        if (reminders.containsKey(date))
            return reminders.get(date);
        return " ";
    }

    /**
     * Updates the reminder for the specified date.
     *
     * @param date the date to update the reminder for
     * @param s the updated reminder text
     */
    public void updateReminder(Date date, String s) {
        if(reminders.containsKey(date)) {
            reminders.put(date, s);
            System.out.println("Reminder has been updated successfully at " + date.toString());
        }
        else
            System.out.println("No reminder found for the specified date " + date.toString());
    }
}
