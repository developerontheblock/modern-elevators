package interfaces;

import entity.Elevator;
import entity.Passenger;

public interface Actions {

    // Access modifier 'public' is redundant for interface methods
    String addPassenger(Passenger passenger);

    String addElevator(Elevator elevator);

    String moveElevator(String position, Integer elevatorId);

}
