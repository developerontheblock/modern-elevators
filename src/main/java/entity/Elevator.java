package entity;

import interfaces.ElevatorDirection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Elevator implements ElevatorDirection {

    public int id;
    public int currentFloor;
    public int maxWeight;
    public int currentWeight;
    public List<Passenger> passengers;

    public Elevator(int id, int currentFloor, int maxWeight) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.maxWeight = maxWeight;
        this.passengers = new ArrayList<>();
        this.currentWeight = 0;
    }

    public Elevator(int id) {
        this.id = id;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(this.passengers);
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void moveUp() {
        this.currentFloor++;
    }

    @Override
    public void moveDown() {
        this.currentFloor--;
    }

    @Override
    public void addPassengerToElevator(Passenger passenger) {
        this.passengers.add(passenger);
    }

    @Override
    public void removePassenger(Passenger passenger) {
        this.passengers.remove(passenger);
    }

}
