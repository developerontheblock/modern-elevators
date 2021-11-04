package entity;

import interfaces.ElevatorDirection;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Elevator implements ElevatorDirection {

    public int id;
    public List<Passenger> passengers;
    public int currentFloor;
    public int currentWeight;
    public int maxWeight;
//  public int speed;
//  public double temperature;
//  public int buttons;


    public Elevator(int id, int currentFloor, int maxWeight) {
        this.id = id;
        this.passengers = new ArrayList<>();
        this.currentFloor = currentFloor;
        this.currentWeight = 0;
        this.maxWeight = maxWeight;
    }

    public Elevator(int id) {
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

}
