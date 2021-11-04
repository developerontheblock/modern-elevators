package repository;

import entity.Passenger;
import interfaces.Repository;

import java.util.List;

public class PassengerRepository  implements Repository<Passenger> {

    public List<Passenger> passengers;

    @Override
    public void addPassenger(Passenger model) {
        this.passengers.add(model);
    }


}
