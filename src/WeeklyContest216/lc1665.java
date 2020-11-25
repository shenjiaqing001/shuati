package WeeklyContest216;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/26
 */
public class lc1665 {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] - o1[0]) - (o2[1] - o2[0]);
            }
        });
        int res = 0;
        for (int i = 0; i < tasks.length; ++i) {
            res = Math.max(res + tasks[i][0], tasks[i][1]);
        }

        return res;
    }
}
