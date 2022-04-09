package com.company;

public class Airport {
    private Flight[] _flightSchedule;
    private int _noOfFlights;
    private String _city;
    private static final int MAX_FLIGHTS=200;

    /**
     * Constructs an Airport object.
     * @param city The city of the Airport.
     */
    public Airport(String city){
        _city = city;
        _flightSchedule = new Flight[MAX_FLIGHTS];
        _noOfFlights = 0;
    }

    public boolean AddFlight(Flight flight){
        if(_noOfFlights==0)
            return false;
        if(!flight.getOrigin().equals(_city) && !flight.getDestination().equals(_city))
            return false;
        _flightSchedule[_noOfFlights] = new Flight(flight);
        return true;

    }
}
