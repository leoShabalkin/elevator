package ecs.strategy.impl;

import ecs.control.ElevatorRequest;
import ecs.impl.ElevatorImpl;
import ecs.impl.exceptions.NotFoundStrategy;
import ecs.interfaces.Elevator;
import ecs.strategy.ElevatorSelectionStrategy;

import java.util.List;

/**
 * Created by Leonid_Shabalkin on 17/11/2016.
 */
public class ElevatorSelectionStrategyImpl implements ElevatorSelectionStrategy {
    @Override
    public Elevator selectElevator(List<ElevatorImpl> elevators, ElevatorRequest call) {
        return elevators.stream().findFirst().orElseThrow(() -> new NotFoundStrategy("Not found Lift in Selection Strategy"));
    }
}
