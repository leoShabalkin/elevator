package ecs.component.system;

/**
 * Created by Leonid_Shabalkin on 7/11/2016.
 */
public class LiftingSystemImpl implements LiftingSystem {
    @Override
    public void stop() {
        System.out.print("Stop elevator");
    }

    @Override
    public void moveDown() {
        System.out.print("Move down elevator");
    }

    @Override
    public void moveUp() {
        System.out.print("Move up elevator");
    }

}
