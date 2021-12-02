import java.util.Comparator;

public class Point {
    int x, y;
    int id;

    public Point(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public static Comparator<Point> sortByX() {
        return Comparator.comparingInt(o -> o.x);
    }

    public static Comparator<Point> sortByY() {
        return Comparator.comparingInt(o -> o.y);
    }

    public static int sqrDist(Point p1, Point p2) {
        int dx = (p1.x - p2.x);
        int dy = (p1.y - p2.y);
        return dx * dx + dy * dy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        return id == point.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
