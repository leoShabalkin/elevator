package ecs.impl;

import ecs.impl.enums.ElevatorDirection;
import ecs.impl.exceptions.InvalidNumber;
import ecs.interfaces.ElevatorControlSystemFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Leonid_Shabalkin on 11/10/2016.
 */
public class ElevatorControlSystem implements ElevatorControlSystemFactory {

    public static final int MAX_ELEVATORS = 16;
    Integer numberOfElevators = 0;
    Integer numberOfFloors = 0;
    ArrayList<Elevator> elevators;
    Queue<Integer> pickupLocations;

    public ElevatorControlSystem(Integer numberOfElevators, Integer numberOfFloors) throws InvalidNumber {
        if (numberOfElevators < 0) throw new InvalidNumber("Elevator number must be positive");
        this.numberOfElevators = (numberOfElevators > MAX_ELEVATORS) ? MAX_ELEVATORS : numberOfElevators;
        this.numberOfFloors = numberOfFloors;
        initializeElevators();
        pickupLocations = new LinkedList<>();
    }

    private void initializeElevators() {
        elevators = new ArrayList<Elevator>();
        for (int idx = 0; idx < this.numberOfElevators; idx++) {
            elevators.add(new Elevator(1));
        }
    }

    public ArrayList<Elevator> getElevators() {
        return elevators;
    }

    @Override
    public void pickUp(Integer pickUpFloor) {
        pickupLocations.add(pickUpFloor);
    }

    @Override
    public void destination(Integer elevatorId, Integer destinationFloor) {
        elevators.get(elevatorId).addNewDestinatoin(destinationFloor);
    }

    @Override
    public void step() {
        for (Elevator currElevator : elevators) {
            switch (currElevator.status()) {
                case ELEVATOR_EMPTY:
                    if (!pickupLocations.isEmpty())
                        currElevator.addNewDestinatoin(pickupLocations.poll());
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