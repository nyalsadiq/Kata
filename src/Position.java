import java.util.Objects;

public class Position {

    private Integer x;
    private Integer y;
    private Direction direction;
    private Integer maxX;
    private Integer maxY;

    public Position(Integer x, Integer y, Direction direction, Integer maxX, Integer maxY) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    // Consturctor for positions that don't need a direction or max values.
    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
        this.direction = Direction.NORTH;
        this.maxX = 100;
        this.maxY = 100;
    }

    public void setX(Integer x) {
        this.x = Math.floorMod(x, maxX);
    }

    public void setY(Integer y) {
        this.y = Math.floorMod(y, maxY);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }



    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    // Auto generated equals method (IntelliJ!)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return Objects.equals(x, position.x) &&
                Objects.equals(y, position.y);
    }


    // Auto generated hashCode method (IntelliJ!)
    // Used for collision detection.
    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}
