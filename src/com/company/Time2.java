package com.company;

/**
 * Represents time - hours:minutes. Values must represent a proper time.
 */
public class Time2 {
    private static final int MINIMUM_VALUE = 0;
    private static final int MAXIMUM_HOUR = 23;
    private static final int MAXIMUM_MINUTES = 59;
    private static final int MINUTES_IN_HOUR = 60;
    private static final int MINUTES_IN_DAY = 1440;
    private int _minFromMid;

    /**
     * Constructs a Time2 object. Construct a new time instance with the specified hour and minute
     * . hour should be between 0-23,
     * otherwise it should be set to 0.
     * minute should be between 0-59,
     * otherwise they should be set to 0.
     *
     * @param h hour
     * @param m minute
     */
    public Time2(int h, int m) {
        if (h > MAXIMUM_HOUR || h < MINIMUM_VALUE)
            _minFromMid += MINIMUM_VALUE;
        else
            _minFromMid += h * MINUTES_IN_HOUR;
        if (m > MAXIMUM_MINUTES || m < MINIMUM_VALUE)
            _minFromMid += MINIMUM_VALUE;
        else
            _minFromMid += m;
    }

    /**
     * Copy constructor for Time2. Constructs a time with the same variables as another time.
     *
     * @param other The time object from which to construct the new time
     */
    public Time2(Time2 other) {
        _minFromMid = other._minFromMid;
    }

    /**
     * Returns the hour of the time.
     *
     * @return The hour of the time
     */
    public int getHour() {
        return _minFromMid / MINUTES_IN_HOUR;
    }

    /**
     * Changes the hour of the time. If an illegal number is received hour will remain unchanged.
     *
     * @param num The new hour
     */
    public void setHour(int num) {
        if (!(num < MINIMUM_VALUE || MAXIMUM_HOUR < num)) _minFromMid = _minFromMid % 60 + num * 60;
    }

    /**
     * Returns the minute of the time.
     *
     * @return The minute of the time
     */
    public int getMinute() {
        return _minFromMid % MINUTES_IN_HOUR;
    }

    /**
     * Changes the minute of the time. If an illegal number is received minute will remain unchanged.
     *
     * @param num The new minute
     */
    public void setMinute(int num) {
        if (!(num < MINIMUM_VALUE || num > MAXIMUM_MINUTES)) _minFromMid = (_minFromMid - _minFromMid % 60) + num;
    }

    /**
     * Return the amount of minutes since midnight.
     *
     * @return amount of minutes since midnight.
     */
    public int minFromMidnight() {
        return _minFromMid;
    }

    /**
     * Checks if the recieved time is equal to this time.
     *
     * @param other The time to be compared with this time
     * @return True if the received time is equal to this time
     */
    public boolean equals(Time2 other) {
        return (other._minFromMid == _minFromMid);
    }

    /**
     * Checks if this time is before a received time.
     *
     * @param other The time to check if this time is before
     * @return True if this time is before other time
     */
    public boolean before(Time2 other) {
        return (_minFromMid < other._minFromMid);
    }

    /**
     * Checks if this time is after a received time
     *
     * @param other The time to check if this time is after
     * @return True if this time is after other time
     */
    public boolean after(Time2 other) {
        return other.before(this);
    }

    /**
     * Calculates the difference (in minutess) between two times.
     *
     * @param other The time to check the difference with. Assumption: this time is after other time
     * @return int difference in minutes
     */
    public int difference(Time2 other) {
        return (Math.abs(other._minFromMid - _minFromMid));
    }

    /**
     * Returns a string representation of this time(hh:mm).
     *
     * @return String representation of this time(hh:mm).
     */
    public String toString() {
        String hour = String.format("%02d", _minFromMid / MINUTES_IN_HOUR);
        String minute = String.format("%02d", _minFromMid % MINUTES_IN_HOUR);
        return hour + ":" + minute;
    }

    /**
     * Copy current object and add requested minutes to new object.
     *
     * @param num The minutes need to add.
     * @return new update Time2 object.
     */
    public Time2 addMinutes(int num) {
        int temp = (_minFromMid + num) % MINUTES_IN_DAY;
        if (temp < MINIMUM_VALUE) temp += MINUTES_IN_DAY;
        return (new Time2(temp / MINUTES_IN_HOUR, temp % MINUTES_IN_HOUR));
    }
}
