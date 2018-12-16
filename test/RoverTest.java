import org.junit.Test;

import static org.junit.Assert.*;

public class RoverTest {

    @Test
    public void moveForwardWithoutWrapTest() {
        int initialX = 0;
        int initialY = 0;

        Rover rover = new Rover(initialX, initialY, Direction.NORTH, 100, 100);
        rover.move(Movement.FORWARD);

        Integer expected = 1;

        assertEquals(expected, rover.getPosition().getY());
    }

    @Test
    public void moveBackwardWithoutWrapTest() {
        int initialX = 0;
        int initialY = 1;

        Rover rover = new Rover(initialX, initialY, Direction.NORTH, 100, 100);
        rover.move(Movement.BACKWARD);

        Integer expected = 0;

        assertEquals(expected, rover.getPosition().getY());
    }

    @Test
    public void moveForwardWithWrapTest() {
        Integer initialX = 1;
        Integer initialY = 99;

        Rover rover = new Rover(initialX, initialY, Direction.NORTH, 100, 100);
        rover.move(Movement.FORWARD);

        Integer expected = 0;

        assertEquals(expected, rover.getPosition().getY());
    }

    @Test
    public void moveBackwardWithWrapTest() {
        Integer initialX = 0;
        Integer initialY = 0;

        Rover rover = new Rover(initialX, initialY, Direction.NORTH, 100, 100);
        rover.move(Movement.BACKWARD);

        Integer expected = 99;

        assertEquals(expected, rover.getPosition().getY());
    }

    @Test
    public void turnTest() {
        Rover rover = new Rover(0, 0, Direction.SOUTH, 100, 100);
        rover.turn(Movement.RIGHT);

        assertEquals(Direction.WEST, rover.getPosition().getDirection());
    }

    @Test
    public void testXCoordinateAfterCommands() {
        Rover rover = new Rover(99, 99, Direction.NORTH, 100, 100);
        rover.executeCommand("FFRFF");

        Position expected = new Position(1, 1, Direction.EAST, 100, 100);

        assertEquals(expected.getX(), rover.getPosition().getX());
    }

    @Test
    public void testYCoordinateAfterCommands() {
        Rover rover = new Rover(99, 99, Direction.NORTH, 100, 100);
        rover.executeCommand("FFRFF");

        Position expected = new Position(1, 1, Direction.EAST, 100, 100);

        assertEquals(expected.getY(), rover.getPosition().getY());
    }

    @Test
    public void testDirectionAfterCommands() {
        Rover rover = new Rover(99, 99, Direction.NORTH, 100, 100);
        rover.executeCommand("FFRFF");

        Position expected = new Position(1, 1, Direction.EAST, 100, 100);

        assertEquals(expected.getDirection(), rover.getPosition().getDirection());
    }


    @Test
    public void testObstacleDetection() {
        Rover rover = new Rover(0, 0, Direction.NORTH, 100, 100);
        Map map = Map.getInstance();

        map.addObstacle(new Position(0,2));
        rover.executeCommand("FFRFF");

        Integer expectedY = 1;
        assertEquals(expectedY, rover.getPosition().getY());
    }
}