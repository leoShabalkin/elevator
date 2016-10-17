package ecs.interfaces;

import ecs.impl.enums.ElevatorDirection;
import ecs.impl.enums.ElevatorStatus;

/**
 * Created by Leonid_Shabalkin on 11/10/2016.
 */
public interface ElevatorFactory {
    void moveUp();

    void moveDown();

    void addNewDestinatoin(Integer destination);

    ElevatorDirection direction();

    ElevatorStatus status();
}
