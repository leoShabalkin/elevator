package ecs.control;

import ecs.impl.exceptions.InvalidRequest;

import java.util.UUID;

/**
 * Created by Leonid_Shabalkin on 17/11/2016.
 */
public class ElevatorRequest implements Comparable {
    /**
     * Этаж конечной остановки лифта
     */
    private int destinationFloor;
    /**
     * Этаж с которого осуществляется движение
     */
    private int originFloor;
    /**
     * Время, когда запросили лифт
     */
    private long requestTime = 0;
    /**
     * Уникальный идентифиуатор запроса
     */
    private UUID requestId = null;

    public ElevatorRequest(int destinationFloor) {
        this.destinationFloor = destinationFloor;
        this.requestId = UUID.randomUUID();
        this.requestTime = System.currentTimeMillis();
    }

    public String toString() {
        return String.format("request id: %s, at: %d, to destinationFloor %d", requestId.toString(), requestTime, destinationFloor);
    }

    public UUID getRequestId() {
        return requestId;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof ElevatorRequest)) {
            throw new InvalidRequest("Invalid ElevatorRequest comparison");
        }
        if (this.requestTime > ((ElevatorRequest) o).requestTime) {
            return 1;
        }
        return -1;

    }

    public int getDestinationFloor() {
        return destinationFloor;
    }
}
