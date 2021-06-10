package BiWeeklyContest44;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/23
 */
public class lc1733 {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; ++i) map.put(i, new HashSet<>());
        for (int i = 0; i < languages.length; ++i) {
            for (int j = 0; j < languages[i].length; ++j) {
                map.get(languages[i][j]).add(i + 1);
            }
        }

        boolean[] flag = new boolean[friendships.length];
        for (int i = 0; i < friendships.length; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (map.get(j).contains(friendships[i][0]) &&
                        map.get(j).contains(friendships[i][1])) {
                    flag[i] = true;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; ++i) {
            int count = 0;
            for (int j = 0; j < friendships.length; ++j) {
                if (flag[j] == false) {
                    if (!map.get(i).contains(friendships[j][0])) {
                        count++;
                        map.get(i).add(friendships[j][0]);
                    }
                    if (!map.get(i).contains(friendships[j][1])) {
                        count++;
                        map.get(i).add(friendships[j][1]);
                    }
                }
            }
            min = Math.min(min, count);
        }
        System.out.println();
        return min;
    }
}
