import java.util.HashSet;

/**
 * Map Singleton class,
 * just for global access :)
 */
public class Map {

    private static Map ourInstance;
    private HashSet<Position> obstacles;

    public static Map getInstance() {
        if (ourInstance == null) {
            ourInstance = new Map();
            ourInstance.obstacles = new HashSet<>();
        }
        return ourInstance;
    }

    private Map() { }

    public void addObstacle(Position position) {
        obstacles.add(position);
    }

    public boolean collisionCheck(Position position) {
        if (obstacles.contains(position)) {
            return true;
        }
        return false;
    }

}
