import java.util.ArrayList;

public class ClosestPair {
    private final ArrayList<Point> points;
    private final ArrayList<Point> sortedX;
    private final ArrayList<Point> sortedY;

    public ClosestPair(ArrayList<Point> points) {
        this.points = points;
        sortedX = new ArrayList<>(points);
        sortedY = new ArrayList<>(points);
        sortedX.sort(Point.sortByX());
        sortedY.sort(Point.sortByY());
    }

    public PairOfPoints findSecondClosestPair() {
        PairOfPoints closest = findClosestPair(sortedX, sortedY);
        ArrayList<Point> sortedXCopy = new ArrayList<>(sortedX);
        ArrayList<Point> sortedYCopy = new ArrayList<>(sortedY);
        sortedX.remove(closest.p1);
        sortedY.remove(closest.p1);
        sortedXCopy.remove(closest.p2);
        sortedYCopy.remove(closest.p2);
        PairOfPoints secondClosest1 = findClosestPair(sortedX, sortedY);
        PairOfPoints secondClosest2 = findClosestPair(sortedXCopy, sortedYCopy);
        return (secondClosest1.dist <= secondClosest2.dist) ? secondClosest1 : secondClosest2;
    }

    private PairOfPoints findClosestPair(ArrayList<Point> sortedX, ArrayList<Point> sortedY) {
        assert sortedX.size() == sortedY.size();
        if (sortedX.size() == 1)
            return new PairOfPoints(null, null, Integer.MAX_VALUE);
        else if (sortedX.size() == 2)
            return new PairOfPoints(sortedX.get(0), sortedX.get(1), Point.sqrDist(sortedX.get(0), sortedX.get(1)));
        else if (sortedX.size() == 3)
            return closestAmongstThree(sortedX);
        int mid = sortedX.size() / 2;
        ArrayList<Point> leftSortedX = new ArrayList<>(sortedX.subList(0, mid));
        ArrayList<Point> leftSortedY = new ArrayList<>(sortedY.subList(0, mid));
        ArrayList<Point> rightSortedX = new ArrayList<>(sortedX.subList(mid, sortedX.size()));
        ArrayList<Point> rightSortedY = new ArrayList<>(sortedY.subList(mid, sortedY.size()));
        PairOfPoints leftBest = findClosestPair(leftSortedX, leftSortedY);
        PairOfPoints rightBest = findClosestPair(rightSortedX, rightSortedY);
        PairOfPoints best = (leftBest.dist <= rightBest.dist ? leftBest : rightBest);
        PairOfPoints bestFromSplit = findSplitPair(sortedX, sortedY, best);
        if (best.dist <= bestFromSplit.dist) return best;
        return bestFromSplit;
    }

    private PairOfPoints findSplitPair(ArrayList<Point> sortedX, ArrayList<Point> sortedY, PairOfPoints best) {
        int midX = sortedX.get(sortedX.size() / 2).x;
        int delta = best.dist;
        ArrayList<Point> strip = new ArrayList<>();
        for (Point p : sortedY) {
            if (p.x >= (midX - delta) && p.x <= (midX + delta)) strip.add(p);
        }
        PairOfPoints splitBest = new PairOfPoints(null, null, Integer.MAX_VALUE);
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j <= Integer.min(i + 7, strip.size() - 1); j++) {
                Point a = strip.get(i);
                Point b = strip.get(j);
                int dist = Point.sqrDist(a, b);
                if (dist < splitBest.dist) {
                    splitBest.dist = dist;
                    splitBest.p1 = a;
                    splitBest.p2 = b;
                }
            }
        }
        return splitBest;
    }

    private PairOfPoints closestAmongstThree(ArrayList<Point> points) {
        Point p1, p2, p3;
        p1 = points.get(0);
        p2 = points.get(1);
        p3 = points.get(2);
        int dist12 = Point.sqrDist(p1, p2);
        int dist13 = Point.sqrDist(p1, p3);
        int dist23 = Point.sqrDist(p2, p3);
        if (dist12 <= dist13 && dist12 <= dist23) return new PairOfPoints(p1, p2, dist12);
        else if (dist13 <= dist12 && dist13 <= dist23) return new PairOfPoints(p1, p3, dist13);
        return new PairOfPoints(p2, p3, dist23);
    }
}
