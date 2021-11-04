package entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Elevator {

    public int id;
    public int currentFloor;
    public int maxWeight;
    public List<Passenger> passengers;

    public Elevator(int id, int currentFloor, int maxWeight) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.maxWeight = maxWeight;
        this.passengers = new ArrayList<>();
    }
}
