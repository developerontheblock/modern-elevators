package com.modern.elevators.ModernElevators;

import contoller.DriveUnitController;
import interfaces.RunEngine;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModernElevatorsApplication {

    public static void main(String[] args) {
        RunEngine engine = new DriveUnitController();
        engine.run();
    }
}
