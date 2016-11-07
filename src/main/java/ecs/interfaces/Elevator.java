package ecs.interfaces;

import ecs.impl.enums.ElevatorStatus;

/**
 * Интерфейс управления лифтом
 */
public interface Elevator {
    /**
     *Переместить вверх
     */
    void moveUp();

    /**
     *Перемистить вниз
     */
    void moveDown();

    /**
     * Запрос состояния занятости лифта
     * @return {@link ecs.impl.enums.ElevatorStatus}
     */
    ElevatorStatus status();
}
