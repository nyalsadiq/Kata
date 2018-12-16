public class Rover {

    private Position position;

    public Rover(Integer initialX, Integer initialY, Direction direction, Integer maxX, Integer maxY) {
        this.position = new Position(initialX, initialY, direction, maxX, maxY);
    }

    public Position getPosition() {
        return position;
    }

    public boolean move(Movement movement) {

        int move = 1;

        // if we're given BACKWARD we can set move to -1,
        // so we add -1 to coordinates.
        if (movement.equals(Movement.BACKWARD)) move = -1;


        // Bit of a long winded way of doing things.
        switch (position.getDirection()) {
            case NORTH:
                int nextY = position.getY() + move;
                if (scanForCollision(position.getX(), nextY)) return false;
                position.setY(nextY);
                return true;

            case EAST:
                int nextX = position.getX() + move;
                if (scanForCollision(nextX, position.getY())) return false;
                position.setX(nextX);
                return true;

            case SOUTH:
                nextY = position.getY() - move;
                if (scanForCollision(position.getX(), nextY)) return false;
                position.setY(nextY);
                return true;

            case WEST:
                nextX = position.getX() - move;
                if (scanForCollision(nextX, position.getY())) return false;
                position.setX(nextX);
                return true;

            default:
                return false;
        }
    }

    // Check if our map has an obstacle at (x, y)
    public boolean scanForCollision(int x, int y) {
        Map map = Map.getInstance();
        if (map.collisionCheck(new Position(x, y))) {
            return true;
        }
        return false;
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


    // Takes a string of commands and completes them, stopping
    // if the rover comes across an obstacle.
    public void executeCommand(String commandList) {
        for (int i = 0; i < commandList.length(); i++) {
            switch (commandList.charAt(i)) {
                case 'F':
                    if (move(Movement.FORWARD)) break;
                    System.out.println("Found obstacle at " + position.toString());
                    return;
                case 'B':
                    if (move(Movement.BACKWARD)) break;
                    System.out.println("Found obstacle at " + position.toString());
                    return;
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
