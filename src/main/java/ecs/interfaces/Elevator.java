package ecs.interfaces;

import ecs.component.elevator.ElevatorSystem;
import ecs.impl.enums.ElevatorStatus;

/**
 * Интерфейс управления лифтом
 */
public interface Elevator extends ElevatorSystem {
    /**
     * Переместить вверх
     */
    void moveUp();

    /**
     * Перемистить вниз
     */
    void moveDown();

    /**
     * Запрос состояния занятости лифта
     * @return {@link ecs.impl.enums.ElevatorStatus}
     */
    ElevatorStatus status();

    int currentFloor();
}
