public class Point implements ObjectWithCoordinates {

    private String name;
    private int x;
    private int y;

    Point(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Object getData() {
        return this.name;
    }

    public boolean is_Equal(Point p2) {
        boolean checkX = this.x == p2.getX();
        boolean checkY = this.y == p2.getY();
        return checkY && checkX;
    }

    public String toString() {
        return name;
    }

}
