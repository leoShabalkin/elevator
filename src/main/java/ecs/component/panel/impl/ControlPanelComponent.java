package ecs.component.panel.impl;

import ecs.component.elevator.ElevatorSystem;
import ecs.component.panel.ControlPanel;
import ecs.interfaces.ElevatorControlSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonid_Shabalkin on 7/11/2016.
 */
public class ControlPanelComponent implements ControlPanel {
    List<Integer> panel = new ArrayList<>();
    private ElevatorControlSystem controlSystem;
    private ElevatorSystem elevator;

    public ControlPanelComponent(ElevatorControlSystem controlSystem, ElevatorSystem elevator) {
        this.controlSystem = controlSystem;
        this.elevator = elevator;
    }

    @Override
    public void action(int numberFloat) {
        controlSystem.destination(elevator.elevatorId(), numberFloat);
    }
}
