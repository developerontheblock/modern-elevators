package interfaces;

import entity.Elevator;
import entity.Passenger;

public interface Actions {

    String addPassenger(Passenger passenger);
    String addElevator(Elevator elevator);
}
