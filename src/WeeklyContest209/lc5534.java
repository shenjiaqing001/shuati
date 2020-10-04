package WeeklyContest209;

import CSCI761.FairDivision;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/4
 */
public class lc5534 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        ArrayList<Double> degrees = new ArrayList<>();
        int plus = 0;
        for (int i = 0; i < points.size(); ++i) {
            if (location.get(1) == points.get(i).get(1) && points.get(i).get(0) == location.get(0))
                plus++;
            else {
                degrees.add(calDegrees(points, location, i));
            }
        }

        degrees.sort((o1, o2) -> o1 > o2 ? 1 : -1);

        int size = degrees.size();
        for (int i = 0; i < size; ++i) {
            if (degrees.get(i) < angle) degrees.add(degrees.get(i) + 360);
        }
        System.out.println(points.size());

        int max = 1;
        int hi = 0;
        for (int i = 0; i < degrees.size(); ++i) {
            while (hi < degrees.size() && degrees.get(hi) <= degrees.get(i) + angle) hi++;
            max = Math.max(hi - i, max);
        }
        return max + plus;
    }

    public double calDegrees(List<List<Integer>> points, List<Integer> location, int i) {
        double x = points.get(i).get(0) - location.get(0);
        double y = points.get(i).get(1) - location.get(1);
        if (x == 0 && y == 0) return 0;

        if (x == 0) return y > 0 ? 90 : 270;
        if (y == 0) return x > 0 ? 0 : 180;

        double degree = tanToDegree(y / x);

        if (degree > 0)
            return x > 0 ? degree : 180 + degree;
        else
            return x > 0 ? 360 + degree : 180 + degree;
    }

    public double tanToDegree(double x) {
        return Math.toDegrees(Math.atan(x));
    }
}
