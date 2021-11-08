package service;

import entity.Elevator;
import entity.Passenger;
import interfaces.ElevatorServiceInterface;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ElevatorService implements ElevatorServiceInterface {

    public Queue<Passenger> requests;

    public ElevatorService() {
        this.requests = new ArrayDeque<>();
    }


    @Override
    public String getBestElevatorForPassenger(Elevator elevator) {
        StringBuilder result = new StringBuilder();

        if (requests.isEmpty()) {
            return "No requests.";
        }

        for (Passenger passenger : requests) {
            if (passenger.getCurrentFloor() == elevator.getCurrentFloor()) {
                if (elevator.getCurrentWeight() + passenger.getWeight() <= elevator.getMaxWeight()) {
                    result.append("Passenger ").append(passenger.getName()).append(" get up with elevator with Id -> ")
                            .append(elevator.id).append(". ");

                    this.requests.poll();

                    elevator.addPassengerToElevator(passenger);
                    elevator.setCurrentWeight(passenger.getWeight() + elevator.getCurrentWeight());
                } else {
                    result.append("Elevator with id ").append(elevator.getId())
                            .append(" cannot pick up passenger with name ").append(passenger.getName()).append(". ");
                }
            }
        }
//        if (result.isEmpty()) {
//            return "No passenger on this floor! ";
//        }

        return result.toString();
    }

    @Override
    public void makeRequest(Passenger passenger) {
        requests.offer(passenger);

    }

    @Override
    public String checkForPassengerToLeave(Elevator elevator) {

        List<Passenger> passengersToRemove = new ArrayList<>();
        int count = 0;

        for (Passenger passenger : elevator.getPassengers()) {
            if (elevator.getCurrentFloor() == passenger.getTargetFloor()) {
                passengersToRemove.add(passenger);
            }
        }

        for (Passenger passenger : passengersToRemove) {
            elevator.removePassenger(passenger);
            elevator.setCurrentWeight(elevator.getCurrentWeight() - passenger.getWeight());
            count++;
        }

        return String.format("On this floor %d, %d passengers leaves elevator. ", elevator.getCurrentFloor(), count);
    }
}
