package entity;

import lombok.Data;

@Data
public class Passenger {

    public String name;
    public int currentFloor;
    public int targetFloor;
    public int weight;

    public Passenger(String name, int currentFloor, int targetFloor, int weight) {
        this.name = name;
        this.currentFloor = currentFloor;
        this.targetFloor = targetFloor;
        this.weight = weight;
    }

    public Passenger(String name) {
        this.name = name;
    }

}
