import contoller.DriveUnitController;
import interfaces.RunEngine;

public class ModernElevatorsApplication {

    public static void main(String[] args) {
        RunEngine engine = new DriveUnitController();
        engine.run();
    }
}
