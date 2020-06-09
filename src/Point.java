public class Point implements ObjectWithCoordinates {

    // fields
    private String name;
    private int x;
    private int y;

    //constructor
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

    public String toString() {
        return name + " X=" + this.getX() + " Y=" + this.getY();
    }
}