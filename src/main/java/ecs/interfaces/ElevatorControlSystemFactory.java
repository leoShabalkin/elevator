package ecs.interfaces;

/**
 * Интерфейс управления лифтами
 */
public interface ElevatorControlSystemFactory {
    int MAX_ELEVATORS = 16;

    /**
     *Задание лифту переместиться на заданный этаж
     * @param pickUpFloor этаж, на который нужно переместиться
     */
    void pickUp(Integer pickUpFloor);

    /**
     * Указание лифту о перемещении
     * @param elevatorId идентификатор лифта
     * @param destinationFloor номер этажа
     */
    void destination(Integer elevatorId, Integer destinationFloor);

    /**
     * Сделать шаг, переместиться на этаж ниже/выше
     */
    void step();
}
