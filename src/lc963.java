import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/29/20
 */
public class lc963 {
    public double minAreaFreeRect(int[][] points) {
        if (points.length <= 1) return 0;
        Map<Long, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < points.length; ++i) {
            for (int j = i + 1; j < points.length; ++j) {
                long length = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +
                        (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                List<int[]> list = map.getOrDefault(length, new ArrayList<>());
                list.add(new int[]{points[i][0], points[i][1], points[j][0], points[j][1]});
                map.put(length, list);
            }
        }

        double min = Double.MAX_VALUE;
        for (List<int[]> list : map.values()) {

            if (list.size() <= 1)
                continue;
            for (int i = 0; i < list.size(); ++i) {
                for (int j = i + 1; j < list.size(); ++j) {
                    int[] line1 = list.get(i);
                    int[] line2 = list.get(j);

                    double[] mid1 = new double[]{
                            (double) (line1[0] + line1[2]) / 2.0,
                            (double) (line1[1] + line1[3]) / 2.0};
                    double[] mid2 = new double[]{
                            (double) (line2[0] + line2[2]) / 2.0,
                            (double) (line2[1] + line2[3]) / 2.0};
                    if (mid1[0] != mid2[0] || mid1[1] != mid2[1])
                        continue;


                    double side1 = Math.sqrt(
                            (double) ((line1[0] - line2[0]) * (line1[0] - line2[0]) +
                                    (line1[1] - line2[1]) * (line1[1] - line2[1])));
                    double side2 = Math.sqrt(
                            (double) ((line1[0] - line2[2]) * (line1[0] - line2[2]) +
                                    (line1[1] - line2[3]) * (line1[1] - line2[3])));

                    double size = side1 * side2;
                    min = Math.min(size, min);
                }
            }
        }
        return min == Double.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        double i = 3 / 2;
        System.out.println(Math.sqrt((double) 3 / 2));
    }
}
