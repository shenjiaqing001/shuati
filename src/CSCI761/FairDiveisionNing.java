package CSCI761;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/**
 * @author Yuyao Ning (yn1106@rit.edu)
 * @date 8/31/20
 */
public class FairDiveisionNing {

    static Set<Integer> finalSet = new HashSet<>();

    public static void tryToDivide(int[][] points, int startPoint,
                                   int endPoint) {

        int[] lineV = new int[]{points[endPoint][0] - points[startPoint][0],
                points[endPoint][1] - points[startPoint][1]};

        Set<int[]> positiveSet = new HashSet<>();
        Set<int[]> negativeSet = new HashSet<>();

        for (int[] point : points) {
            if (point[0] == points[startPoint][0] && point[1] == points[startPoint][1] ||
                    point[0] == points[endPoint][0] && point[1] == points[endPoint][1]) {
            } else {
                int[] pointV = new int[]{
                        point[0] - points[startPoint][0], point[1] - points[startPoint][1]};
                int crossProduct = lineV[0] * pointV[1] - lineV[1] * pointV[0];

//                if ( crossProduct == 0 ) break;

                if (crossProduct > 0) {
                    positiveSet.add(point);
                } else if (crossProduct < 0) {
                    negativeSet.add(point);
                }
            }
        }

        if (positiveSet.size() == points.length / 2 || negativeSet.size() == points.length / 2) {
            if (positiveSet.size() > negativeSet.size()) {

                for (int[] point : points) {
                    if (!positiveSet.contains(point)) {
                        negativeSet.add(point);
                    }
                }
//                for ( int[] point:negativeSet) {
//                    System.out.println( Arrays.toString( point )  );
//                }
            } else {
                for (int[] point : points) {
                    if (!negativeSet.contains(point)) {
                        positiveSet.add(point);
                    }
                }
//                for ( int[] point:positiveSet ) {
//                    System.out.println( Arrays.toString( point ) );
//                }
            }

            finalSet.add(negativeSet.hashCode());
            finalSet.add(positiveSet.hashCode());
//            System.out.println(negativeSet.hashCode());
//            System.out.println(positiveSet.hashCode());
//            System.out.println(finalSet.size());
        }
    }

    public static void main(String[] args) {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(bf.readLine());
            int[][] points = new int[n][1];

            int num = 0;

            String line = "";

            while ((line = bf.readLine()) != null && !"".equals(line)) {

                points[num] =
                        new int[]{Integer.parseInt(line.split(" ")[0]),
                                Integer.parseInt(line.split(" ")[1])};
                num++;

            }

            if (n == 0 || n == 2) {
                System.out.println(n);
                return;
            }

            if (n % 2 == 1) {
                System.out.println(0);
                return;
            }

            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    tryToDivide(points, i, j);
                }
            }

        } catch (Exception e) {

        }

        if (finalSet.size() == 0) {
            System.out.println(2);
        } else {
            System.out.println(finalSet.size());
        }
    }
}
