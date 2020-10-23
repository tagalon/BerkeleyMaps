package bearmaps;
import java.util.List;

public class NaivePointSet implements PointSet {
    private List<Point> pointList;

    public NaivePointSet(List<Point> points) {
        pointList = points;
    }

    @Override
//    public Point nearest(double x, double y) {
//        double bestDistance = distance(pointList.get(0), new Point(x, y));
//        int bestIndex = 0;
//        for (int index = 1; index < pointList.size(); index ++) {
//            double testDistance = distance(pointList.get(index), new Point(x, y));
//            if (testDistance <= bestDistance) {
//                bestIndex = index;
//                bestDistance = testDistance;
//            }
//        }
//        return pointList.get(bestIndex);
//    }
    public Point nearest(double x, double y) {
        Point bestPoint = pointList.get(0);
        Point testPoint = new Point(x, y);
        for (int index = 1; index < pointList.size(); index++) {
            if (distance(pointList.get(index), testPoint) <= distance(bestPoint, testPoint)) {
                bestPoint = pointList.get(index);
            }
        }
        return bestPoint;
    }

    private double distance(Point p1, Point p2) {
        double x = p1.getX() - p2.getX();
        double y = p1.getY() - p2.getY();
        return Math.sqrt(x * x + y * y);
    }
}