package ecs.impl.exceptions;

/**
 * Created by Leonid_Shabalkin on 17/11/2016.
 */
public class InvalidRequest extends RuntimeException {
    public InvalidRequest(String msg) {
        super(msg);
    }
}
