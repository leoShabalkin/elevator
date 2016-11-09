package ecs.component.direction.impl;

import ecs.component.direction.DirectionComponent;
import ecs.impl.enums.ElevatorDirection;

/**
 * Created by Leonid_Shabalkin on 3/11/2016.
 */
public class DirectionButtonComponent implements DirectionComponent {

    public void showUp(ElevatorDirection elevatorDirection) {
        if (elevatorDirection == ElevatorDirection.ELEVATOR_UP) {
            System.out.println("Show elevator up");
        }
    }

    public void showDown(ElevatorDirection elevatorDirection) {
        //Если делать полную симуляцию, то в данном случаи необходим блок else в котором гаситься лампочка
        if (elevatorDirection == ElevatorDirection.ELEVATOR_DOWN) {
            System.out.println("Show elevator down");
        }
    }

    public void showStop(ElevatorDirection elevatorDirection) {
        if (elevatorDirection == ElevatorDirection.ELEVATOR_HOLD) {
            System.out.println("Show elevator stop");
        }
    }


    @Override
    public synchronized void showInformation(ElevatorDirection elevatorDirection) {
        showDown(elevatorDirection);
        showUp(elevatorDirection);
        showStop(elevatorDirection);
    }
}
