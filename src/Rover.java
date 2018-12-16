import java.awt.event.MouseEvent;

public class Rover {

    private Position position;

    public Rover(Integer initialX, Integer initialY, Direction direction, Integer maxX, Integer maxY) {
        this.position = new Position(initialX, initialY, direction, maxX, maxY);
    }

    public Position getPosition() {
        return position;
    }

    public void move(Movement movement) {
        int move = 1;

        if (movement.equals(Movement.BACKWARD)) move = -1;

        switch (position.getDirection()) {
            case NORTH:
                position.setY(position.getY() + move);
                break;
            case EAST:
                position.setX(position.getX() + move);
                break;
            case SOUTH:
                position.setY(position.getY() - move);
                break;
            case WEST:
                position.setX(position.getX() - move);
                break;
            default:
                return;
        }
    }

    public void turn(Movement movement) {

        switch (position.getDirection()) {
            case NORTH:
                if (movement.equals(Movement.LEFT)) {
                    position.setDirection(Direction.WEST);
                    break;
                }
                position.setDirection(Direction.EAST);
                break;
            case EAST:
                if (movement.equals(Movement.LEFT)) {
                    position.setDirection(Direction.NORTH);
                    break;
                }
                position.setDirection(Direction.SOUTH);
                break;
            case SOUTH:
                if (movement.equals(Movement.LEFT)) {
                    position.setDirection(Direction.EAST);
                    break;
                }
                position.setDirection(Direction.WEST);
                break;
            case WEST:
                if (movement.equals(Movement.LEFT)) {
                    position.setDirection(Direction.SOUTH);
                    break;
                }
                position.setDirection(Direction.NORTH);
                break;
            default:
                return;
        }
    }

    public void executeCommand(String commandList) {
        for (int i = 0; i < commandList.length(); i++) {
            switch (commandList.charAt(i)) {
                case 'F':
                    move(Movement.FORWARD);
                    break;
                case 'B':
                    move(Movement.BACKWARD);
                    break;
                case 'L':
                    turn(Movement.LEFT);
                    break;
                case 'R':
                    turn(Movement.RIGHT);
                    break;
                default:
                    return;
            }
        }
    }
}
