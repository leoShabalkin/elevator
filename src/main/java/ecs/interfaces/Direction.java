package ecs.interfaces;

import ecs.impl.enums.ElevatorDirection;

/**
 * Created by Leonid_Shabalkin on 27/10/2016.
 */
public interface Direction {
    /**
     * Запрос направления движения
     * @return {@link ecs.impl.enums.ElevatorDirection}
     */
    ElevatorDirection direction();
}
