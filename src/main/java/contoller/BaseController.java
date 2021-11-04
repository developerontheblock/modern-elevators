package contoller;

import entity.Elevator;
import entity.Passenger;
import interfaces.Actions;
import repository.ElevatorRepository;
import repository.PassengerRepository;

import java.util.List;

public class BaseController implements Actions {

    public PassengerRepository passengerRepository;
    public ElevatorRepository elevatorRepository;

    public BaseController() {
        this.passengerRepository = new PassengerRepository();
        this.elevatorRepository = new ElevatorRepository();
    }

    @Override
    public String addPassenger(Passenger passenger){
        this.passengerRepository.add(passenger);
        return "Successfull " + passenger.getName();
    }

    @Override
    public String addElevator(Elevator elevator) {
        StringBuilder result = new StringBuilder();

        Elevator elevatorToCheck = elevatorRepository.find(new Elevator(elevator.getId()));

        if (elevatorToCheck != null) {
            return String.format("Already exist elevator with id: %d. ", elevator.getId());
        }

        this.elevatorRepository.add(elevator);
        result.append(String.format("Successful added elevator with id: %d. ", elevator.getId()));

        return result.toString();
    }



}
