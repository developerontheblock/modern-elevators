package repository;

import entity.Elevator;
import interfaces.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElevatorRepository implements Repository<Elevator> {

    public List<Elevator> elevators;

    public ElevatorRepository() {
        this.elevators = new ArrayList<>();
    }

    public List<Elevator> getElevators() {
        return Collections.unmodifiableList(this.elevators);
    }

    @Override
    public void add(Elevator model) {
        this.elevators.add(model);
    }

    @Override
    public Elevator find(Elevator data) {
        return this.elevators.stream().filter(e -> e.getId() == data.getId())
                .findFirst().orElse(null);
    }
}
