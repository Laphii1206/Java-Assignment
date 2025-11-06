public abstract class AF1G8_Car implements AF1G8_Movable {

    public enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    public enum Movement {
        FORWARD, BACKWARD, STOP
    }

    private boolean isOn;
    private boolean isMoving;
    private Direction currentDirection;
    private Movement movement;

    public AF1G8_Car() {
        this.isOn = false;
        this.isMoving = false;
        this.currentDirection = Direction.NORTH;
        this.movement = Movement.STOP;
    }

    public boolean isIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    public boolean isIsMoving() {
        return isMoving;
    }

    public void setIsMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    @Override
    public String toString() {
        String state = "\n========== TOY CAR STATE ==========\n";

        if (isOn) {
            state += "Power: ON\n";
            if (isMoving) {
                state += "Status: MOVING " + movement + "\n";
                state += "Direction of Travel: " + currentDirection + "\n";
            } else {
                state += "Status: STOPPED\n";
                state += "Facing Direction: " + currentDirection + "\n";
            }
        } else {
            state += "Power: OFF\n";
            state += "Facing Direction: " + currentDirection + "\n";
        }

        state += "===================================\n";
        return state;
    }
}
