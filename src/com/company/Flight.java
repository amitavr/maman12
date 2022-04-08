package com.company;

/**
 * @author Amit Avramovich
 * @version final version
 */
public class Flight {
    private static final int MINIMUM_VALUE = 0;
    private static final int MAX_CAPACITY = 250;
    private String _origin;
    private String _destination;
    private Time1 _departure;
    private int _flightDuration;
    private int _noOfPassengers;
    private boolean _isFull;
    private int _price;

    /**
     * Constructor for a Flight object.
     * If the number of passengers exceeds the maximum capacity the number of passengers will be set to the maximum capacity
     * If the number of passengers is negative the number of passengers will be set to zero.
     * If the flight duration is negative the flight duration will be set to zero.
     * If the price is negative the price will be set to zero.
     *
     * @param origin         The city the flight lands at.
     * @param destination    The city the flight leaves from.
     * @param depHour        The departure hour (should be between 0-23).
     * @param depMinute      The departure minute (should be between 0-59).
     * @param flightDuration The duration time in minutes (should not be negative).
     * @param noOfPassengers The number of passengers (should be between 0-maximum capacity)
     * @param price          The price (should not be negative).
     */
    public Flight(String origin, String destination, int depHour, int depMinute, int flightDuration, int noOfPassengers, int price) {
        _origin = origin;
        _destination = destination;
        _departure = new Time1(depHour, depMinute);
        _noOfPassengers = noOfPassengers;
        _price = price;
        _isFull = false;
        _flightDuration = flightDuration;
        if (noOfPassengers >= MAX_CAPACITY) {
            _noOfPassengers = MAX_CAPACITY;
            _isFull = true;
        }
        if (flightDuration < MINIMUM_VALUE) _flightDuration = MINIMUM_VALUE;
        if (noOfPassengers < MINIMUM_VALUE) _noOfPassengers = MINIMUM_VALUE;
        if (price < MINIMUM_VALUE) _price = MINIMUM_VALUE;
    }

    /**
     * Copy construction for a Flight object. Construct a Flight object with the same attributes as Flight other.
     *
     * @param other The Flight object from which to construct the new Flight.
     */
    public Flight(Flight other) {
        _origin = other._origin;
        _destination = other._destination;
        _departure = new Time1(other._departure);
        _noOfPassengers = other._noOfPassengers;
        _price = other._price;
        _isFull = other._isFull;
        _flightDuration = other._flightDuration;
    }

    /**
     * Returns the flight origin.
     *
     * @return The flight origin.
     */
    public String getOrigin() {
        return _origin;
    }

    /**
     * Changes the flight's origin.
     *
     * @param origin - The flight's new origin.
     */
    public void setOrigin(String origin) {
        _origin = origin;
    }

    /**
     * Returns the flight destination.
     *
     * @return The flight destination.
     */
    public String getDestination() {
        return _destination;
    }

    /**
     * Changes the flight's destination.
     *
     * @param destination - The flight's new destination.
     */
    public void setDestination(String destination) {
        _destination = destination;
    }

    /**
     * Returns the flight departure time
     *
     * @return A copy of the flight departure time.
     */
    public Time1 getDeparture() {
        return new Time1(_departure);
    }

    /**
     * Changes the flight's departure time.
     *
     * @param departure The flight's new departure time.
     */
    public void setDeparture(Time1 departure) {
        _departure = new Time1(departure);
    }

    /**
     * Returns the flight duration time in minutes
     *
     * @return The flight duration.
     */
    public int getFlightDuration() {
        return _flightDuration;
    }

    /**
     * Changes the flight's duration time. If the parameter is negative the duration time will remain unchanged.
     *
     * @param flightDuration The flight's new duration time.
     */
    public void setFlightDuration(int flightDuration) {
        if (!(flightDuration < MINIMUM_VALUE)) _flightDuration = flightDuration;
    }

    /**
     * Returns the number of passengers on the flight
     *
     * @return The number of passengers
     */
    public int getNoOfPassengers() {
        return _noOfPassengers;
    }

    /**
     * Changes the number of passengers.
     * If the parameter is negative or larger than the maximum capacity the number of passengers will remain unchanged.
     *
     * @param noOfPassengers - The new number of passengers
     */
    public void setNoOfPassengers(int noOfPassengers) {
        if (!(noOfPassengers < MINIMUM_VALUE || noOfPassengers > MAX_CAPACITY)) _noOfPassengers = noOfPassengers;
        _isFull = noOfPassengers == MAX_CAPACITY;
    }

    /**
     * Returns whether the flight is full or not.
     *
     * @return True if the flight is full otherwise, False
     */
    public boolean getIsFull() {
        return _isFull;
    }

    /**
     * Returns the price of the flight.
     *
     * @return flight price.
     */
    public int getPrice() {
        return _price;
    }

    /**
     * Changes the flight price. If the parameter is negative the price will remain unchanged.
     *
     * @param price The new price.
     */
    public void setPrice(int price) {
        if (!(price < MINIMUM_VALUE)) _price = price;
    }

    /**
     * Return a string representation of this flight (for example: "Flight from London to Paris departs at 09:24.Flight is full.").
     *
     * @return String representation of this flight (for example: "Flight from London to Paris departs at 09:24.Flight is full.").
     */
    public String toString() {
        String full = (_isFull) ? "Flight is full." : "Flight is not full.";
        return "Flight from " + _origin + " to " + _destination + " departs at " + _departure + ". " + full;
    }

    /**
     * Check if the received flight is equal to this flight.
     * Flights are considered equal if the origin, destination and departure times are the same.
     *
     * @param other The flight to be compared with this flight.
     * @return True if the received flight is equal to this flight.
     */
    public boolean equals(Flight other) {
        return (_destination.equals(other._destination) && _origin.equals(other._origin) && _departure.equals(other._departure));
    }

    /**
     * Returns the arrival time of the flight.
     *
     * @return The arrival time of this flight.
     */
    public Time1 getArrivalTime() {
        return new Time1(_departure.addMinutes(_flightDuration));
    }

    /**
     * Add passengers to this flight. If the number of passengers exceeds the maximum capacity,
     * no passengers are added and False is returned. Otherwise, num will be added to passengers and
     * if the flight becomes full, the boolean attribute isFull becomes true
     *
     * @param num - The number of passengers to be added to this flight.
     * @return True if the passengers were added to this flight.
     */
    public boolean addPassengers(int num) {
        if (_noOfPassengers + num > MAX_CAPACITY) return false;
        else if (_noOfPassengers + num == MAX_CAPACITY) _isFull = true;
        return true;
    }

    /**
     * Check if this flight is cheaper than another flight.
     *
     * @param other The flight whose price is to be compared with this flight's price.
     * @return True if this flight ticket price is cheaper than other flight ticket price.
     */
    public boolean isCheaper(Flight other) {
        return (_price < other._price);
    }

    /**
     * Calculate the total price of the flight.
     *
     * @return The total price of the flight.
     */
    public int totalPrice() {
        return (_noOfPassengers * _price);
    }

    /**
     * Check if this flight lands before another flight.
     * Note - the flights may land on different days, the method checks which flight lands first.
     *
     * @param other The flight whose arrival time to be compared with this flight's arrival time.
     * @return True if this flight arrives before the received flight.
     */
    public boolean landsEarlier(Flight other) {
        return (_departure.minFromMidnight() + _flightDuration < other._departure.minFromMidnight() + other._flightDuration);
    }
}
