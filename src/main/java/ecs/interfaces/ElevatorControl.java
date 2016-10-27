package ecs.interfaces;

/**
 * Created by Leonid_Shabalkin on 27/10/2016.
 */
public interface ElevatorControl {
    /**
     *Задать место назначения
     * @param destination этаж
     */
    void addNewDestination(Integer destination);
}
