package contoller;

import entity.Operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DriveUnit implements Runnable {

    private BaseController controller;
    // used to read the stream of characters from the specified source (character-input stream)
    private BufferedReader reader;

    public DriveUnit() {
        this.controller = new BaseController();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.println("Inside");
    }

    private String processInput() throws IOException {
        System.out.println("processInput ");
        System.out.println("Please enter value ");

        String input = this.reader.readLine();

        Operations operation = Operations.valueOf(input);
        String result = null;

        switch (operation) {
            case addPassenger:
                System.out.println("passenger name:");
                String[] data = parseCommand();
                result = addPassenger(data);
                break;
        }

        return result;
    }

    private String[] parseCommand() throws IOException {
        return reader.readLine().split("\\s+");
    }
}
