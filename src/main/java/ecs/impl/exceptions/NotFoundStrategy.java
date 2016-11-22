package ecs.impl.exceptions;

/**
 * Created by Leonid_Shabalkin on 22/11/2016.
 */
public class NotFoundStrategy extends RuntimeException {
    public NotFoundStrategy(String msg) {
        super(msg);
    }
}