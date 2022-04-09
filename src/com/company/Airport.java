package com.company;

public class Airport {
    private static final int MAX_FLIGHTS = 200;
    private Flight[] _flightSchedule;
    private int _noOfFlights;
    private String _city;

    /**
     * Constructs an Airport object.
     *
     * @param city The city of the Airport.
     */
    public Airport(String city) {
        _city = city;
        _flightSchedule = new Flight[MAX_FLIGHTS];
        _noOfFlights = 0;
    }

    /**
     * Add flight to the airport schedule.
     *
     * @param flight The flight to add to this airport
     * @return True if flight is added otherwise, false.
     */
    public boolean AddFlight(Flight flight) {
        if (_noOfFlights == 0) // if flight schedule is empty.
            return false;
        if (!flight.getOrigin().equals(_city) && !flight.getDestination().equals(_city)) // if neither origin/destination equal to airport city
            return false;
        _flightSchedule[_noOfFlights] = new Flight(flight);
        return true;
    }

    /**
     * Remove flight from Airport.
     *
     * @param other The flight we wish to remove
     * @return True if flight is found and removed from this airport otherwise, False.
     */
    public boolean removeFlight(Flight other) {
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightSchedule[i].equals(other)) {
                _flightSchedule[i] = null;
                for (int j = i; j < _noOfFlights; j++)
                    _flightSchedule[j] = _flightSchedule[j + 1];
                _flightSchedule[_noOfFlights - 1] = null;
                _noOfFlights--;
                return true;
            }
        }
        return false;
    }

    public Time1 firstFlightFromOrigin(String origin) {
        Time1 first = new Time1(23, 59);
        int flightsFrom = 0;
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightSchedule[i].getOrigin().equals(origin))
                if (_flightSchedule[i].getDeparture().before(first)) {
                    first = _flightSchedule[i].getDeparture();
                    flightsFrom++;
                }

        }
        if (flightsFrom == 0) return null;
        else return first;
    }
}

