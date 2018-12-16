import org.junit.Test;

import static org.junit.Assert.*;

public class MapTest {

    @Test
    public void testCollision() {
        Position ourPosition = new Position(25, 25);

        Map map = Map.getInstance();

        map.addObstacle(new Position(25, 25));

        assertEquals(true, map.collisionCheck(ourPosition));
    }
}
