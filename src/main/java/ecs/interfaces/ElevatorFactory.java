package ecs.interfaces;

import ecs.impl.enums.ElevatorDirection;
import ecs.impl.enums.ElevatorStatus;

/**
 * Интерфейс управления лифтом
 */
public interface ElevatorFactory {
    /**
     *Переместить вверх
     */
    void moveUp();

    /**
     *Перемистить вниз
     */
    void moveDown();

    /**
     *Задать место назначения
     * @param destination этаж
     */
    void addNewDestination(Integer destination);

    /**
     * Запрос направления движения
     * @return {@link ecs.impl.enums.ElevatorDirection}
     */
    ElevatorDirection direction();

    /**
     * Запрос состояния занятости лифта
     * @return {@link ecs.impl.enums.ElevatorStatus}
     */
    ElevatorStatus status();
}
