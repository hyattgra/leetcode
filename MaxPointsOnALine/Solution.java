package MaxPointsOnALine;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alan on 5/8/2016.
 */
public class Solution {

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0)
            return 0;
        if (points.length <= 2)
            return points.length;

        int ret = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            int samxX = 0;
            int samePoint = 0;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    if (points[i].x == points[j].x && points[i].y == points[j].y) {
                        samePoint++;
                        samxX++;
                        continue;
                    }
                    if (points[i].x == points[j].x) {
                        samxX++;
                        continue;
                    }
                    double slope = (double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x);
                    int count = map.containsKey(slope) ? map.get(slope) + 1 : 2;
                    map.put(slope, count);
                    //ret = Math.max(ret, map.get(slope) + samePoint);
                }
            }
            for (Double k : map.keySet()) {
                ret = Integer.max(ret, map.get(k) + samePoint);
            }
            ret = Integer.max(ret, samxX + 1);

        }
        return ret;
    }


    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
