package ecs.component.direction.impl;

import com.google.common.collect.ImmutableMap;
import ecs.component.direction.DirectionComponent;
import ecs.impl.enums.ElevatorDirection;

import java.util.Map;

/**
 * Created by Leonid_Shabalkin on 3/11/2016.
 */
public class DirectionButtonComponent implements DirectionComponent {
    private static final Map<ElevatorDirection, String> defaultAnswer = ImmutableMap.<ElevatorDirection, String>builder()
            .put(ElevatorDirection.ELEVATOR_UP, "Show elevator up")
            .put(ElevatorDirection.ELEVATOR_DOWN, "Show elevator down")
            .put(ElevatorDirection.ELEVATOR_HOLD, "Show elevator stop")
            .build();

    private void showMessage(ElevatorDirection elevatorDirection) {
        System.out.println(defaultAnswer.get(elevatorDirection));
    }

    @Override
    public synchronized void showInformation(ElevatorDirection elevatorDirection) {
        showMessage(elevatorDirection);
    }
}
