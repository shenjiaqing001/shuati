package WeeklyContest240;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/8
 */
public class lc1 {
    public int maximumPopulation(int[][] logs) {
        int[] map = new int[3000];
        for (int i = 0; i < logs.length; ++i) {
            for (int j = logs[i][0]; j < logs[i][1]; ++j) {
                map[j]++;
            }
        }
        int max = 0;
        int tmp = -1;
        for (int i = 2050; i >= 1950; --i) {
            if (map[i] >= max) {
                max = map[i];
                tmp = i;
            }
        }
        return tmp;
    }
}
