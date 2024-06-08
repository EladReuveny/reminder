/*
 * @package javafx.maman14q2
 *
 * Represents a date consisting of a day, month, and year.
 *
 * @author Elad Reuveny
 */
package q2;

import java.io.Serializable;
import java.util.Objects;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    /**
     * Constructs a new javafx.maman14q2.Date object with the specified day, month, and year.
     *
     * @param day   the day of the month
     * @param month the month
     * @param year  the year
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Returns the day of the month.
     *
     * @return the day of the month
     */
    public int getDay() {
        return day;
    }

    /**
     * Returns the month.
     *
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Returns the year.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Calculates and returns the hash code for the javafx.maman14q2.Date object.
     *
     * @return the hash code value for the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    /**
     * Compares this date with the specified object for equality.
     *
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Date date = (Date) o;
        return day == date.day && month == date.month && year == date.year;
    }

    /**
     * Returns a string representation of this date in the format "day.month.year".
     *
     * @return a string representation of this date
     */
    @Override
    public String toString() {
        return getDay() + "." + getMonth() + "." + getYear();
    }
}
