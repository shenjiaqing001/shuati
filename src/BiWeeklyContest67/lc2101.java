package BiWeeklyContest67;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/11/21
 */
public class lc2101 {


    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] list = new List[n];
        for (int i = 0; i < n; ++i) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                long distance =
                        (long) (bombs[i][0] - bombs[j][0]) * (bombs[i][0] - bombs[j][0]) +
                                (long) (bombs[i][1] - bombs[j][1]) * (bombs[i][1] - bombs[j][1]);
                if (distance <= (long) bombs[i][2] * bombs[i][2]) {
                    list[i].add(j);
                }
                if (distance <= (long) bombs[i][2] * bombs[i][2]) {
                    list[j].add(i);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, dfs(i, list, new boolean[n]));
        }
        return max;
    }

    public int dfs(int i, List<Integer>[] list, boolean[] flag) {
        Queue<Integer> q = new ArrayDeque<>();
        int size = 0;
        q.add(i);
        flag[i] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            size += 1;
            for (int num : list[now]) {
                if (!flag[num]) {
                    q.add(num);
                    flag[num] = true;
                }
            }
        }
        return size;
    }


}
