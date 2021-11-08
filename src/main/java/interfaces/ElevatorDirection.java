package interfaces;

import entity.Passenger;

public interface ElevatorDirection {

    // Access modifier 'public' is redundant for interface methods
    void moveUp();

    void moveDown();

    void addPassengerToElevator(Passenger passenger);

    void removePassenger(Passenger passenger);
}
