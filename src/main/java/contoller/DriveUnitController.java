package contoller;

import entity.Elevator;
import entity.Operations;
import entity.Passenger;
import interfaces.Actions;
import interfaces.RunEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DriveUnitController implements RunEngine {

    private Actions action;
    // used to read the stream of characters from the specified source (character-input stream)
    private BufferedReader reader;

    public DriveUnitController() {
        this.action = new BaseController();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.println("CONSOLE LEGEND(2-letters operations):\n" +
                "AP -> Add passenger\n" +
                "AE -> Add elevator\n" +
                "ME -> Move elevator\n" +
                "MR -> Make request\n" +
                "ST -> Stop\n");
        while (true) {
            String result = null;

            try {
                result = processInput();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (result != null && result.equals("Exit")) {
                break;
            }
            System.out.println(result);
        }
    }

    private String[] parseCommand() throws IOException {
        // the regex '\s+' will match one or more whitespace characters
        return reader.readLine().split("\\s+");
    }

    private String addElevator(String[] data) {
        return action.addElevator(new Elevator(Integer.parseInt(data[0]), Integer.parseInt(data[1]),
                Integer.parseInt(data[2])));
    }

    private String addPassenger(String[] data) {
        return action.addPassenger(new Passenger(data[0], Integer.parseInt(data[1]),
                Integer.parseInt(data[2]), Integer.parseInt(data[3])));
    }

    private String moveElevator(String[] data) {
        return action.moveElevator(data[0], Integer.parseInt(data[1]));
    }

    private String makeRequest(String[] data) {
        return action.makeRequest(data[0]);
    }

    private String processInput() throws IOException {
        System.out.println("Please, enter 2-letter operation.(See the console legend for more information)");

        String input = this.reader.readLine();

        Operations operation = Operations.valueOf(input);
        String result = null;

        switch (operation) {
            case AP:
                System.out.println("Enter name of passenger, " +
                        "passenger's current floor,passenger's target floor and weight of passenger(separated with white space)");
                String[] data = parseCommand();
                result = addPassenger(data);
                break;
            case AE:
                System.out.println("Enter id of elevator, " +
                        "current floor, and max weight of elevator(separated with white space)");
                data = parseCommand();
                result = addElevator(data);
                break;
            case ME:
                System.out.println("Enter position to move(up or down) and id of elevator(separated with white space)");
                data = parseCommand();
                result = moveElevator(data);
                break;
            case MR:
                System.out.println("Now please write name of passenger who want to take elevator.");
                data = parseCommand();
                result = makeRequest(data);
                break;
            case ST:
                result = "Exit";
                break;
        }
        return result;
    }
}
