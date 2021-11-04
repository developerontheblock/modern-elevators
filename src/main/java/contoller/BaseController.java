package contoller;

import entity.Elevator;
import entity.Passenger;
import interfaces.Actions;
import repository.ElevatorRepository;
import repository.PassengerRepository;


public class BaseController implements Actions {

    public PassengerRepository passengerRepository;
    public ElevatorRepository elevatorRepository;

    public BaseController() {
        this.passengerRepository = new PassengerRepository();
        this.elevatorRepository = new ElevatorRepository();
    }

    @Override
    public String addPassenger(Passenger passenger) {
        this.passengerRepository.add(passenger);
        return "Successful added passenger with name: " + passenger.getName();
    }

    @Override
    public String addElevator(Elevator elevator) {
        StringBuilder result = new StringBuilder();

        Elevator elevatorToCheck = elevatorRepository.find(new Elevator(elevator.getId()));

        if (elevatorToCheck != null) {
            return String.format("Already exist elevator with id: %d ", elevator.getId());
        }

        this.elevatorRepository.add(elevator);
        result.append(String.format("Successful added elevator with id: %d ", elevator.getId()));

        return result.toString();
    }
    @Override
    public String moveElevator(String position, Integer elevatorId) {
        // to concatenate a large number of strings
        StringBuilder result = new StringBuilder();
        Elevator elevator = elevatorRepository.find(new Elevator(elevatorId));

        if (elevator == null) {
            return "There is no elevator with this id.";
        }

        switch (position.toLowerCase()) {
            case "up":
                elevator.moveUp();
                break;
            case "down":
                if (elevator.getCurrentFloor() - 1 <= 0) {
                    result.append("There is no floor under floor 1. ");
                } else {
                    elevator.moveDown();
                }
                break;
            default:
                return "Please, enter the correct destination goal!";
        }
        result.append(String.format("Elevator with id: %d is on %d floor now",
                elevator.getId(), elevator.getCurrentFloor())).append(System.lineSeparator());
        return result.toString();
    }
}
