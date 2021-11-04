package contoller;

import entity.Operations;
import entity.Passenger;
import interfaces.Actions;
import interfaces.RunEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DriveUnit implements RunEngine {

    private Actions actions;
    // used to read the stream of characters from the specified source (character-input stream)
    private BufferedReader reader;

    public DriveUnit() {
        this.actions = new BaseController();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.println("CONSOLE LEGEND: AP -> Add passenger");
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
            System.out.println();
        }
    }

    private String[] parseCommand() throws IOException {
        return reader.readLine().split("\\s+");
    }

    private String processInput() throws IOException {
        System.out.println("Please enter 2 letter operation.(see the console legend for more information) ");

        String input = this.reader.readLine();

        Operations operation = Operations.valueOf(input);
        String result = null;

        switch (operation) {
            case AP:
                System.out.println("passenger name:");
                String[] data = parseCommand();
                result = addPassenger(data);
                break;
            default:
                // code block
        }
        return result;
    }
    private String addPassenger(String[] data) {
        return actions.addPassenger(new Passenger(data[0], Integer.parseInt(data[1]),
                Integer.parseInt(data[2]), Integer.parseInt(data[3])));
    }



}
