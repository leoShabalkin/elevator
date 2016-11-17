package ecs.impl;

import ecs.impl.enums.ElevatorDirection;
import ecs.impl.exceptions.InvalidNumber;
import ecs.interfaces.ElevatorControlSystem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by Leonid_Shabalkin on 11/10/2016.
 */
public class ElevatorControlSystemImpl implements ElevatorControlSystem {
    Integer numberOfElevators = 0;
    Integer numberOfFloors = 0;
    ArrayList<ElevatorImpl> elevators;
    Queue<Integer> pickupLocations;

    public ElevatorControlSystemImpl(Integer numberOfElevators, Integer numberOfFloors) throws InvalidNumber {
        if (numberOfElevators < 0) throw new InvalidNumber("ElevatorImpl number must be positive");
        this.numberOfElevators = (numberOfElevators > MAX_ELEVATORS) ? MAX_ELEVATORS : numberOfElevators;
        this.numberOfFloors = numberOfFloors;
        initializeElevators();
        pickupLocations = new ArrayDeque<>();
    }

    private void initializeElevators() {
        elevators = new ArrayList<>();
        for (int idx = 0; idx < this.numberOfElevators; idx++) {
            elevators.add(new ElevatorImpl(1, idx));
        }
    }

    public ArrayList<ElevatorImpl> getElevators() {
        return elevators;
    }

    @Override
    public void pickUp(Integer pickUpFloor) {
        pickupLocations.add(pickUpFloor);
    }

    @Override
    public void destination(Integer elevatorId, Integer destinationFloor) {
        elevators.get(elevatorId).addNewDestination(destinationFloor);
    }

    @Override
    public void step() {
        for (ElevatorImpl currElevator : elevators) {
            switch (currElevator.status()) {
                case ELEVATOR_EMPTY:
                    if (!pickupLocations.isEmpty())
                        currElevator.addNewDestination(pickupLocations.poll());
                    break;
                case ELEVATOR_OCCUPIED:
                    switch (currElevator.direction()) {
                        case ELEVATOR_UP:
                            currElevator.moveUp();
                            break;
                        case ELEVATOR_DOWN:
                            currElevator.moveDown();
                            break;
                        case ELEVATOR_HOLD:
                            currElevator.popDestination();
                            break;
                    }
                    if (currElevator.direction() == ElevatorDirection.ELEVATOR_UP)
                        break;
            }
        }
    }
}