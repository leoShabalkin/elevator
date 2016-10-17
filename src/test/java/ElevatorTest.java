import ecs.impl.Elevator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Leonid_Shabalkin on 14/10/2016.
 */
public class ElevatorTest {
    public static final int TENTH_FLOOR = 10;
    public static final int SECOND_FLOOR = 2;
    public static final int BASEMENT_TWO = -2;

    private Elevator elevator;

    @Before
    public void initializeElevator() {
        elevator = new Elevator(0);
    }

    @Test
    public void testAddingDestination() {
        elevator.addNewDestinatoin(TENTH_FLOOR);
        assertEquals(TENTH_FLOOR, elevator.nextDestination());
    }

    @Test
    public void checkCurrentFloor() {
        // Move to floor 2
        elevator.moveUp();
        elevator.moveUp();
        assertEquals(SECOND_FLOOR, elevator.currentFloor());
    }

    @Test
    public void checkMoveDown() {
        elevator.moveDown();
        elevator.moveDown();
        assertEquals(BASEMENT_TWO, elevator.currentFloor());
    }
}