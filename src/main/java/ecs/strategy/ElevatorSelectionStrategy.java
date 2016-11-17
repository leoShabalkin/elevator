package ecs.strategy;

import ecs.component.elevator.ElevatorSystem;
import ecs.control.ElevatorRequest;
import ecs.impl.ElevatorImpl;
import ecs.interfaces.Elevator;

import java.util.Collection;
import java.util.List;

/**
 * Created by Leonid_Shabalkin on 17/11/2016.
 */
public interface ElevatorSelectionStrategy {
    ElevatorSystem selectElevator(List<ElevatorImpl> elevators, ElevatorRequest call);
}
