import static org.junit.Assert.*;

import contoller.BaseController;
import entity.Elevator;
import entity.Passenger;
import org.junit.Before;
import org.junit.Test;

public class ModernElevatorsTest {

    private Elevator elevator;
    private Passenger passenger;
    private BaseController controller;

    @Before
    public void setUp() {
        elevator = new Elevator(1, 1, 100);
        passenger = new Passenger("Alex", 1, 3, 60);
        controller = new BaseController();
    }

    @Test
    public void testAddElevatorSuccessful() {
        controller.addElevator(this.elevator);
        assertEquals(1, controller.elevatorRepository.getElevators().size());
    }

    @Test
    public void testAddElevatorWithSameIds() {
        controller.addElevator(this.elevator);
        controller.addElevator(this.elevator);
        assertEquals(1, controller.elevatorRepository.getElevators().size());
    }

    @Test
    public void testAddPassengerSuccessful() {
        controller.addPassenger(this.passenger);
        assertEquals(1, controller.passengerRepository.getPassengers().size());
    }

    @Test
    public void testMakeRequestWithNoPassengers() {
        String makeRequest = controller.makeRequest("Alex");
        assertEquals("There is no passenger with that name.", makeRequest);
    }

    @Test
    public void testMoveUpElevator() {
        controller.addElevator(this.elevator);
        controller.moveElevator("up", 1);

        Elevator elevator = controller.elevatorRepository.find(new Elevator(1));

        assertEquals(2, elevator.getCurrentFloor());
    }

    @Test
    public void testMoveDownElevator() {
        controller.addElevator(new Elevator(2, 2, 100));
        controller.moveElevator("down", 2);

        Elevator elevator = controller.elevatorRepository.find(new Elevator(2));

        assertEquals(1, elevator.getCurrentFloor());
    }

    @Test
    public void testRemovePassengerFromElevatorAtTheTargetFloor() {
        controller.addElevator(this.elevator);
        controller.addPassenger(this.passenger);
        controller.makeRequest(this.passenger.getName());
        controller.moveElevator("up", 1);
        controller.moveElevator("up", 1);

        assertEquals(0, controller.elevatorRepository.find(elevator).getPassengers().size());
    }

}
