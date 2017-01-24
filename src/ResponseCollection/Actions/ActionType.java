/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponseCollection.Actions;

/**
 *
 * @author alvian
 */
public enum ActionType {
    DIRECTION_LEFT(1),
    DIRECTION_RIGHT(2),
    DIRECTION_BACKWARD(3),
    DIRECTION_FORWARD(4),
    DIRECTION_STOP(5);

    private final int type;

    ActionType(int type) {
        this.type = type;
    }

    public int id() {
        return type;
    }

    public static void runAction(int type) {
        if(type == ActionType.DIRECTION_LEFT.id()){new Direction("left");}
        if(type == ActionType.DIRECTION_RIGHT.id()){new Direction("right");}
        if(type == ActionType.DIRECTION_BACKWARD.id()){new Direction("backward");}
        if(type == ActionType.DIRECTION_FORWARD.id()){new Direction("forward");}
        if(type == ActionType.DIRECTION_STOP.id()){new Direction("null direction, stopping");}
    }
}
