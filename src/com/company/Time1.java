package com.company;

/**
 * The Time1 Class represents a time
 */
public class Time1 {

    private static final int MINIMUM_VALUE = 0;
    private static final int MAXIMUM_HOUR = 23;
    private static final int MAXIMUM_MINUTES = 59;
    private static final int MINUTES_IN_HOUR = 60;
    private static final int MINUTES_IN_DAY = 1440;
    private int _hour;
    private int _minute;

    /**
     * Constructs a Time1 object.
     * Construct a new time instance with the specified hour and minute .
     * hour should be between 0-23,
     * otherwise it should be set to 0. minute should be between 0-59,
     * otherwise it should be set to 0.
     *
     * @param h - the hour of the time
     * @param m - the minute of the time
     */
    public Time1(int h, int m) {
        _hour = (h > MAXIMUM_HOUR || h < MINIMUM_VALUE) ? MINIMUM_VALUE : h;
        _minute = (m > MAXIMUM_MINUTES || m < MINIMUM_VALUE) ? MINIMUM_VALUE : m;
    }

    /**
     * Copy constructor for class Time1
     *
     * @param other constructs Time1 object with
     *              the same values as @param.values
     */
    public Time1(Time1 other) {
        _hour = other._hour;
        _minute = other._minute;
    }

    /**
     * Returns the hour of the time
     *
     * @return _hour
     */
    public int getHour() {
        return _hour;
    }

    /**
     * Changes the hour of the time.
     * If an illegal number is received hour will be unchanged.
     *
     * @param num The new hour
     */
    public void setHour(int num) {
        if (!(num < MINIMUM_VALUE || MAXIMUM_HOUR < num)) _hour = num;
    }

    /**
     * Returns the minute of the time.
     *
     * @return minute
     */
    public int getMinute() {
        return _minute;
    }

    /**
     * Changes the minute of the time.
     * If an illegal number is received minute will be unchanged.
     *
     * @param num The new minute
     */
    public void setMinute(int num) {
        if (!(num < MINIMUM_VALUE || num > MAXIMUM_MINUTES)) _minute = num;
    }

    /**
     * @return String representation of this time (hh:mm).
     */
    public String toString() {
        String hour = String.format("%02d", _hour);
        String minute = String.format("%02d", _minute);
        return hour + ":" + minute;
    }

    /**
     * Return the amount of minutes since midnight.
     *
     * @return amount of minutes since midnight.
     */
    public int minFromMidnight() {
        return _hour * MINUTES_IN_HOUR + _minute;
    }

    /**
     * Check if the received time is equal to this time
     *
     * @param other - The Time1 object to be compared to
     * @return True if the received time is equal to this time.
     * otherwise, return False
     */
    public boolean equals(Time1 other) {
        return (other._minute == _minute && other._hour == _hour);
    }

    /**
     * Check if this time is before a received time.
     *
     * @param other - The time to check if this time is before other time
     * @return Return True if this time is before other time otherwise, return False
     */
    public boolean before(Time1 other) {
        if (_hour < other._hour) return true;
        if (_hour == other._hour) return _minute < other._minute;
        return false;
    }

    /**
     * Check if this time is after a received time.
     *
     * @param other - The time to check if this time is after other time
     * @return Return True if this time is after other time otherwise, Return False;
     */
    public boolean after(Time1 other) {
        return (other.before(this));
    }

    /**
     * Calculates the difference (in minutes) between two times.
     *
     * @param other - The time to check the difference to
     * @return int - difference in minutes
     */
    public int difference(Time1 other) {
        return (Math.abs(other._hour - _hour) * MINUTES_IN_HOUR + Math.abs(other._minute - _minute));
    }

    /**
     * Copy current object and add requested minutes to new object.
     *
     * @param num - The minutes need to add
     * @return new updated Time1 object;
     */
    public Time1 addMinutes(int num) {
        int newTimeInMinutes = (_hour * MINUTES_IN_HOUR + _minute + num) % MINUTES_IN_DAY;
        if (newTimeInMinutes < MINIMUM_VALUE) newTimeInMinutes = MINUTES_IN_DAY + newTimeInMinutes;
        return new Time1(newTimeInMinutes / 60, newTimeInMinutes % 60);
    }

}
