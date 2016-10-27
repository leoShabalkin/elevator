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
     * Запрос состояния занятости лифта
     * @return {@link ecs.impl.enums.ElevatorStatus}
     */
    ElevatorStatus status();
}
