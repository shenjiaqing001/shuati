import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/9
 */
public class lc853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][3];
        for (int i = 0; i < n; ++i) {
            cars[i][0] = i;
            cars[i][1] = position[i];
            cars[i][2] = speed[i];
        }

        Arrays.sort(cars, (o1, o2) -> (o2[1] - o1[1]));
        int res = 0;
        Double time = 0.0;
        for (int[] car : cars) {
            Double timeUsed = (double) (target - car[1]) / (double) car[2];
            if (timeUsed > time) {
                res += 1;
                time = timeUsed;
            }
        }
        return res;
    }
}
