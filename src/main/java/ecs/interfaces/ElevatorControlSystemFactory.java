package ecs.interfaces;

/**
 * Created by Leonid_Shabalkin on 11/10/2016.
 */
public interface ElevatorControlSystemFactory {
    void pickUp(Integer pickUpFloor);

    void destination(Integer elevatorId, Integer destinationFloor);

    void step();
}
