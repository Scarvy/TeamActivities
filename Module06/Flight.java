import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Set;

public class Flight implements Comparable<Flight> {
    private String airline;
    private int flightNumber;
    private String airlineCode;

    public Flight(String airline, int flightNumber, String airlineCode) { 
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.airlineCode = airlineCode;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getFlightID() {
        return airlineCode + flightNumber;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    @Override
    public int compareTo(Flight o) {
        return getFlightID().compareTo(o.getFlightID());
    }

    @Override
    public String toString() {
        return "Flight{" + "airline='" + airline + '\'' + ", flightNumber=" + flightNumber
                + ", airlineCode='" + airlineCode + '\'' + '}';
    }

    @Override
    public boolean equals(Object other) {
        if (this==other) {
            return true;
        }

        if (!(other instanceof Flight f)) {
            return false;
        }

        return (
            (this.airline.equals(f.airline)) && 
            (this.airlineCode.equals(f.airlineCode)) && 
            (this.flightNumber == f.flightNumber)
        );

    }

    
    @Override
    public int hashCode() {
        return getFlightID().hashCode();
    }


    public static void main(String[] args) {
        Flight f1 = new Flight("Delta", 123, "DL");
        Flight f2 = new Flight("American", 456, "AA");
        Flight f3 = new Flight("United", 789, "UA");

        System.out.println(f1.compareTo(f2)); //  flight 1 > flight 2
        System.out.println(f2.compareTo(f3)); // flight 2 < flight 3
        System.out.println(f3.compareTo(f1)); // flight 3 > flight 1

        List<Flight> flights = new ArrayList<>();
        // can't use list.of() only, as it returns an immutable list, so we add one to new list
        flights.addAll(List.of(f1, f2, f3));
        System.out.println(); // for formatting
        System.out.println("preSorted");
        System.out.println(flights);

        flights.sort(null); //if null is passed as parameter, it will sort the lst in place using the compareTo        
        System.out.println();
        System.out.println("postSorted");
        System.out.println(flights);

        // Create a lambda expression to sort the flights by flight number
        System.out.println();
        System.out.println("Printing using lambda expressions, sorting by flight number");
        flights.sort((flight1, flight2) -> flight1.getFlightNumber() - flight2.getFlightNumber());
        System.out.println(flights);

        // Create a lambda expression to sort the flights by flight code
        System.out.println();
        System.out.println("Printing using lambda expressions, sorting by flight code");
        flights.sort((flight1, flight2) -> flight1.getAirlineCode().compareTo(flight2.getAirlineCode()));
        System.out.println(flights);


        // Add code using a TreeSet to store the flights in order
        System.out.println();
        System.out.println("Adding a TreeSet");
        Set<Flight> flightSet = new TreeSet<>(flights);
        System.out.println(flightSet);

        // Add code to store the flights in a TreeMap
        // use the flight as key, and Integer as value - storing the number of seats on the flight
        System.out.println();
        System.out.println("Adding a TreeMap");
        TreeMap<Flight, Integer> flightSeats = new TreeMap<>();

        // assuming F1, F2, F3 are already created
        flightSeats.put(f1, 100);
        flightSeats.put(f2, 200);
        flightSeats.put(f3, 300);

        System.out.println(flightSeats);
    }
}
