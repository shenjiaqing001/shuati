package CSCI761;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/4/20
 */
public class FairDivision2 {
    public static class Point {
        int x, y;
        int index;

        Point(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }

    public static Map<Integer, Set<Integer>> map = new HashMap<>();


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
                for (int j = i + 1; j < points.length; ++j) {
                    addLine(points, i, j);
                }
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
