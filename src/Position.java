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

    public void setX(Integer x) {
        this.x = Math.floorMod(x, maxX);
    }

    public void setY(Integer y) {
        this.y = Math.floorMod(y, maxY);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Integer getMaxX() {
        return maxX;
    }

    public Integer getMaxY() {
        return maxY;
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
}
