package CSCI761;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/2/20
 */
public class FairDivision {
    public static class Point {
        int x, y;
        int index;

        Point(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }

    public static class Line implements Comparable<Line> {
        double degree;
        int index;

        Line(int index, double degree) {
            this.index = index;
            this.degree = degree;
        }

        @Override
        public int compareTo(Line o) {
            if (this.degree == o.degree) return 0;
            return this.degree - o.degree > 0 ? 1 : -1;
        }
    }

    public static Map<Integer, Set<Integer>> map = new HashMap<>();

    public static void division(Point[] points, int id) {
        int num = (points.length + 1) / 2;
        Line[] lines = new Line[points.length - 1];
        int now = 0;
        for (int i = 0; i < points.length; ++i) {
            if (i == id) continue;
            lines[now++] = new Line(i, calDegrees(points, id, i));
        }
        Arrays.sort(lines);
        int left = 0;
        int right = 0;
        int hi = -1;
        double loBound = lines[0].degree;
        int loIndex = 0;
        for (int i = 1; i < lines.length; ++i) {
            if (lines[i].degree < loBound + 180) left++;
            else {
                if (hi == -1) hi = i;
                right++;
            }
        }
        while (loBound < 180) {
            if (left < num && right < num) {
                addLine(points, lines[loIndex].index, id);
            }
            loIndex++;
            if (loIndex >= lines.length) break;
            loBound = lines[loIndex].degree;
            left--;
            right++;

            if (hi != -1) {
                while (hi < lines.length && lines[hi].degree < loBound + 180) {
                    right--;
                    left++;
                    hi++;
                }
            }
        }
        left = 0;
        right = 0;
        int lo = -1;
        double hiBound = lines[lines.length - 1].degree;
        int hiIndex = lines.length - 1;
        for (int i = lines.length - 1; i >= 0; --i) {
            if (lines[i].degree > hiBound - 180) right++;
            else {
                if (lo == -1) lo = i;
                left++;
            }
        }
        while (hiBound >= 180) {
            if (left < num && right < num) {
                addLine(points, lines[hiIndex].index, id);
            }
            hiIndex--;
            if (hiIndex < 0) break;
            hiBound = lines[hiIndex].degree;
            right--;
            left++;
            if (lo != -1) {
                while (lo >= 0 && lines[lo].degree > hiBound - 180) {
                    left--;
                    right++;
                    lo--;
                }
            }
        }
    }

    public static double calDegrees(Point[] points, int n, int m) {
        double x = points[m].x - points[n].x;
        double y = points[m].y - points[n].y;

        if (x == 0) return y > 0 ? 90 : 270;
        if (y == 0) return x > 0 ? 0 : 180;

        double degree = tanToDegree(y / x);

        if (degree > 0)
            return x > 0 ? degree : 180 + degree;
        else
            return x > 0 ? 360 + degree : 180 + degree;
    }

    public static void addLine(Point[] points, int m, int n) {
        int xDis = points[m].x - points[n].x;
        int yDis = points[m].y - points[n].y;

        if (yDis == 0) {
            if (map.containsKey(1)) {
                Set<Integer> set = map.get(1);
                set.add(0);
                map.put(1, set);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(0);
                map.put(1, set);
            }
            return;
        }
        if (xDis == 0) {
            if (map.containsKey(0)) {
                return;
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(1);
                map.put(0, set);
            }
        }

        int gcd = generateGCD(xDis, yDis);
        if (gcd != 0) {
            xDis /= gcd;
            yDis /= gcd;
        }

        Set<Integer> set = map.getOrDefault(xDis, new HashSet<>());
        set.add(yDis);
        map.put(xDis, set);
    }

    public static double tanToDegree(double x) {
        return Math.toDegrees(Math.atan(x));
    }

    public static int generateGCD(int a, int b) {
        if (b == 0) return a;
        else return generateGCD(b, a % b);
    }

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(bf.readLine());
            Point[] points = new Point[n];
            for (int i = 0; i < n; ++i) {
                String[] str = bf.readLine().split(" ");
                points[i] = new Point(i, Integer.parseInt(str[0]), Integer.parseInt(str[1]));
            }

            if (n == 0 || n == 2) {
                System.out.println(n);
                return;
            }
            if (n % 2 == 1) {
                System.out.println(0);
                return;
            }
            for (int i = 0; i < points.length; ++i) {
                division(points, i);
            }
            int res = 0;
            for (Set set : map.values()) {
                res += set.size();
            }
            System.out.println(res * 2);
        } catch (Exception e) {

        }
    }
}