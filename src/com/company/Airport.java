package com.company;

public class Airport {
    private static final int MAX_FLIGHTS = 200;
    private Flight[] _flightSchedule;
    private int _noOfFlights;
    private String _city;

    /**
     * Constructs an Airport object which represent flights in a day.
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
    public boolean addFlight(Flight flight) {
        if (_noOfFlights == MAX_FLIGHTS) // if flight schedule is empty.
            return false;
        if (!flight.getOrigin().equals(_city) && !flight.getDestination().equals(_city)) // if neither origin/destination equal to airport city
            return false;
        _flightSchedule[_noOfFlights] = new Flight(flight);
        _noOfFlights++;
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

    //TODO: COMMENT firstFlightFromORigin
    public Time1 firstFlightFromOrigin(String origin) {
        Time1 first = new Time1(23, 59);
        boolean cityIsFound = false;
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightSchedule[i].getOrigin().equals(origin))
                if (_flightSchedule[i].getDeparture().before(first)) {
                    first = new Time1(_flightSchedule[i].getDeparture());
                    cityIsFound = true;
                }

        }
        if (!cityIsFound) return null;
        else return new Time1(first);
    }

    /**
     * Return the number of full flights.0
     *
     * @return Number of full flight.
     */
    public int howManyFullFlights() {
        int fullFlights = 0;
        for (int i = 0; i < _noOfFlights; i++)
            if (_flightSchedule[i].getIsFull())
                fullFlights++;
        return fullFlights;
    }

    /**
     * Check how many flight depart from Airport to place and vice versa.
     *
     * @param place to check flights between
     * @return Number of flight between place and Airport city and vice versa.
     */
    public int howManyFlightsBetween(String place) {
        int flightsBetween = 0;
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightSchedule[i].getOrigin().equals(place) && _flightSchedule[i].getDestination().equals(_city))
                flightsBetween++;
            if (_flightSchedule[i].getOrigin().equals(_city) && _flightSchedule[i].getDestination().equals(place))
                flightsBetween++;
        }
        return flightsBetween;
    }


    //TODO: COMPLETE mostPopularDestination

    /**
     * @return
     */
    public String mostPopularDestination() {
        String[] destinations = new String[MAX_FLIGHTS];
        int[] count = new int[MAX_FLIGHTS];
        String mostPopular;
        boolean flag = false;
        int j = 0;
        for (int i = 0; i < _noOfFlights; i++) {
            for (j = 0; j < destinations.length; j++) {

                //System.out.println(destinations[j]);

                if (destinations[j] != null && destinations[j].equals(_flightSchedule[i].getDestination())) {

                    count[j]++;
                    flag = true;
                }
                if(destinations[j] == null)
                    break;

            }
            if (!flag) {
                destinations[j] = _flightSchedule[i].getDestination();
                count[j]++;
            }
            j = 0;
            flag = false;
        }
        /*
        System.out.println(destinations);
        System.out.println(count);*/
        int highestNum=0,highestIndex=0;
        int a=0;
        for(a=0;a<count.length;a++) {
            if (count[a] > highestNum) {
                highestIndex = a;
                highestNum=count[a];
            }
            if (count[a] == 0)
                break;
        }

        return destinations[highestIndex];
        //return destinations + "\n" + count;
    }

    /**
     * Returns the most and first expensive flight ticket in this airport schedule
     *
     * @return The most and first expensive flight ticket in this airport schedule
     */
    public Flight mostExpensiveTicket() {
        if (_noOfFlights == 0) return null;
        //int mostExpensive = _flightSchedule[0].getPrice();
        Flight mostExpensiveFlight = _flightSchedule[0];
        for (int i = 0; i < _noOfFlights; i++)
            if (_flightSchedule[i].getPrice() > mostExpensiveFlight.getPrice())
                mostExpensiveFlight = _flightSchedule[i];
        return new Flight(mostExpensiveFlight);
    }

    /**
     * Returns the most and first longest flight in this airport schedule
     *
     * @return The most and first longest flight in this airport schedule
     */
    public Flight longestFlight() {
        if (_noOfFlights == 0) return null;
        Flight longestFlight = _flightSchedule[0];
        for (int i = 0; i < _noOfFlights; i++)
            if (_flightSchedule[i].getFlightDuration() > longestFlight.getFlightDuration())
                longestFlight = _flightSchedule[i];
        return new Flight(longestFlight);
    }

    @Override
    public String toString() {
        if (_noOfFlights == 0) return null;
        String string = "";
        for (int i = 0; i < _noOfFlights; i++)
            string = string + "\n" + _flightSchedule[i].toString();
        return "The flights for airport " + _city + " today are:" + string;
    }
}

