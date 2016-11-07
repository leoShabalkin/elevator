import ecs.impl.ElevatorImpl;
import ecs.impl.ElevatorControlSystemImpl;
import ecs.impl.exceptions.InvalidNumber;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Leonid_Shabalkin on 19/10/2016.
 */
public class ElevatorControlSystemTest {
    public static final int ELEVATOR_ID_ZERO = 0;
    public static final int ELEVATOR_ID_ONE = 1;
    public static final int TENTH_FLOOR = 10;
    public static final int FIRST_FLOOR = 1;
    public static final int SEVENTH_FLOOR = 8;
    private ElevatorControlSystemImpl elevatorControlSystemImpl;
    private ArrayList<ElevatorImpl> elevators;

    @Before
    public void initialize() {
        try {
            elevatorControlSystemImpl = new ElevatorControlSystemImpl(2, 20);
        } catch (InvalidNumber invalidNumber) {
            invalidNumber.printStackTrace();
        }
    }

    @Test
    public void testRequestingOneElevator() {
        elevatorControlSystemImpl.pickUp(TENTH_FLOOR);
        for (int i = 0; i < TENTH_FLOOR; i++) {
            elevatorControlSystemImpl.step();
        }
        elevators = elevatorControlSystemImpl.getElevators();
        assertEquals(TENTH_FLOOR, elevators.get(ELEVATOR_ID_ZERO).currentFloor());
    }

    @Test
    public void testElevatorTwoNotMoving() {
        elevatorControlSystemImpl.pickUp(TENTH_FLOOR);
        for (int i = 0; i < TENTH_FLOOR; i++) {
            elevatorControlSystemImpl.step();
        }
        elevators = elevatorControlSystemImpl.getElevators();
        assertEquals(FIRST_FLOOR, elevators.get(ELEVATOR_ID_ONE).currentFloor());
    }

    @Test
    public void testCallingTwoElevators() {
        elevatorControlSystemImpl.pickUp(TENTH_FLOOR);
        elevatorControlSystemImpl.pickUp(SEVENTH_FLOOR);
        for (int i = 0; i < TENTH_FLOOR; i++) {
            elevatorControlSystemImpl.step();
        }
        elevators = elevatorControlSystemImpl.getElevators();
        assertEquals(TENTH_FLOOR, elevators.get(ELEVATOR_ID_ZERO).currentFloor());
        assertEquals(SEVENTH_FLOOR, elevators.get(ELEVATOR_ID_ONE).currentFloor());
    }

    @Test
    public void testSendingElevatorToDestination() {
        elevatorControlSystemImpl.destination(ELEVATOR_ID_ZERO, TENTH_FLOOR);
        for (int idx = 0; idx < TENTH_FLOOR; idx++) {
            elevatorControlSystemImpl.step();
        }
        elevators = elevatorControlSystemImpl.getElevators();
        assertEquals(TENTH_FLOOR, elevators.get(ELEVATOR_ID_ZERO).currentFloor());
    }

    @Test
    public void testSendingElevatorToMultipleDestinations() {
        elevatorControlSystemImpl.destination(ELEVATOR_ID_ZERO, TENTH_FLOOR);
        elevatorControlSystemImpl.destination(ELEVATOR_ID_ZERO, SEVENTH_FLOOR);
        for (int idx = 0; idx < TENTH_FLOOR; idx++) {
            elevatorControlSystemImpl.step();
        }
        elevators = elevatorControlSystemImpl.getElevators();
        assertEquals(TENTH_FLOOR, elevators.get(ELEVATOR_ID_ZERO).currentFloor());
        for (int idx = 0; idx < TENTH_FLOOR - SEVENTH_FLOOR; idx++) {
            elevatorControlSystemImpl.step();
        }
        elevators = elevatorControlSystemImpl.getElevators();
        assertEquals(SEVENTH_FLOOR, elevators.get(ELEVATOR_ID_ZERO).currentFloor());
    }

}