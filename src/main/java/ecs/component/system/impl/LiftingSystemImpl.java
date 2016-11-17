package ecs.component.system.impl;

import ecs.component.system.LiftingSystem;
import ecs.interfaces.Elevator;

/**
 * Created by Leonid_Shabalkin on 7/11/2016.
 */
public class LiftingSystemImpl implements LiftingSystem {
    private Elevator elevator;

    public LiftingSystemImpl(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void stop() {
        elevator.stop();
    }

    @Override
    public void moveDown() {
        elevator.moveDown();
    }

    @Override
    public void moveUp() {
        elevator.moveUp();
    }

}
