import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/12/20
 */
public class lc149 {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;

        int max = 0;
        int num = points.length;

        for (int i = 0; i < num; ++i) {
            Map<String, Integer> map = new HashMap<>();
            int sameX = 1;
            int sameP = 0;

            for (int j = 0; j < num; ++j) {
                if (i != j) {
                    if (points[i][0] == points[j][0] &&
                            points[i][1] == points[j][1]) {
                        sameP++;
                    }
                    if (points[i][0] == points[j][0]) {
                        sameX++;
                        continue;
                    }

                    int a = points[i][1] - points[j][1];
                    int b = points[i][0] - points[j][0];
                    int c = generateGCD(a, b);
                    a /= c;
                    b /= c;
                    boolean flag = true;
                    if ((a > 0 && b < 0) || (a < 0 && b > 0))
                        flag = false;

                    a = Math.abs(a);
                    b = Math.abs(b);
                    String str = a + ":" + b;
                    if (flag) str = str + "-";

                    if (map.containsKey(str)) {
                        map.put(str, map.get(str) + 1);
                    } else {
                        map.put(str, 2);
                    }
                    System.out.println(str);
                    max = Math.max(max, map.get(str) + sameP);
                }
            }
            max = Math.max(max, sameX);
        }
        return max;
    }

    private int generateGCD(int a, int b) {
        if (b == 0) return a;
        else return generateGCD(b, a % b);
    }
}
