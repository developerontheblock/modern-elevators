package interfaces;

import entity.Elevator;
import entity.Passenger;

public interface ElevatorServiceInterface {

     String getBestElevatorForPassenger(Elevator elevator);
     void makeRequest(Passenger passenger);
     String checkForPassengerToLeave(Elevator elevator);
}
