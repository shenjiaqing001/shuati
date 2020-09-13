package WeeklyContest206;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/13/20
 */
public class lc5512 {


    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Integer>[] map = new Map[n];
        for (int i = 0; i < n; ++i) {
            map[i] = new HashMap<>();
            for (int j = 0; j < n - 1; ++j) {
                map[i].put(preferences[i][j], j);
            }
        }

        int[] pair = new int[n];
        boolean[] flag = new boolean[n];
        for (int i = 0; i < pairs.length; ++i) {
            pair[pairs[i][0]] = pairs[i][1];
            pair[pairs[i][1]] = pairs[i][0];
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (check(i, map, pair, flag, preferences))
                res++;
        }
        return res;
    }

    public boolean check(int x, Map<Integer, Integer>[] map, int[] pair, boolean[] flag,
                         int[][] preferences) {
        int y = pair[x];
        int yPosinXmap = map[x].get(y);
        for (int i = 0; i < yPosinXmap; ++i) {
            int z = preferences[x][i];
            int zNow = pair[z];
            int zNowPosInZMap = map[z].get(zNow);
            int xPosInZMap = map[z].get(x);
            if (xPosInZMap < zNowPosInZMap) {
                flag[x] = true;
                return true;
            }
        }
        return false;
    }

}
