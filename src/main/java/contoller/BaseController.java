package contoller;

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
    public String add(Passenger passenger){
        this.passengerRepository.addPassenger(passenger);
        return "Successfull " + passenger.getName();
    }

}
