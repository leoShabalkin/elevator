package ecs.component.panel.impl;

import ecs.component.elevator.ElevatorSystem;
import ecs.component.panel.ControlPanel;
import ecs.control.ElevatorController;
import ecs.control.ElevatorRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonid_Shabalkin on 7/11/2016.
 */
public class ControlPanelComponent implements ControlPanel {
    List<Integer> panel = new ArrayList<>();
    private ElevatorSystem elevator;
    private ElevatorController controller;

    public ControlPanelComponent(ElevatorController controlSystem, ElevatorSystem elevator) {
        this.controller = controlSystem;
        this.elevator = elevator;
    }

    @Override
    public void action(int numberFloat) {
        ElevatorRequest request = new ElevatorRequest(numberFloat);
        controller.dispatchElevator(elevator, request);
    }
}
