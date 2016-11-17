package ecs.control;

import ecs.component.elevator.ElevatorSystem;
import ecs.interfaces.ElevatorControlSystem;
import ecs.strategy.ElevatorSelectionStrategy;

/**
 * Created by Leonid_Shabalkin on 17/11/2016.
 */
public class ElevatorController {
    //я не стал прикручивать сюда spring, но задатки для di сделал
    private ElevatorControlSystem elevatorControlSystem;
    private ElevatorSelectionStrategy strategy;

    public void dispatchElevator(ElevatorSystem e, ElevatorRequest request) {
        elevatorControlSystem.destination(e.elevatorId(), request.getDestinationFloor());
    }

    public void processRequest(ElevatorRequest request) {
        ElevatorSystem targetElevator = strategy.selectElevator(elevatorControlSystem.getElevators(), request);
        dispatchElevator(targetElevator, request);
    }

}
