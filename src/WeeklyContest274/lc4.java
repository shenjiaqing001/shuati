package WeeklyContest274;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/1/22
 */
public class lc4 {

    int maxCircle = 0;
    int[] vis;
    int[] favorite;
    Map<Integer, Integer> tmp;

    void dfs(int index, int level) {
        if (vis[index] == 0 && !tmp.containsKey(index)) {
            tmp.put(index, level);
            vis[index] = 1;
            dfs(favorite[index], level + 1);
        } else {
            if (tmp.containsKey(index))
                maxCircle = Math.max(level - tmp.get(index), maxCircle);
        }
    }

    public int depth(Map<Integer, Set<Integer>> map, int index) {
        if (!map.containsKey(index) || map.get(index).size() == 0) return 0;
        int max = 0;
        for (int child : map.get(index)) {
            max = Math.max(max, depth(map, child));
        }
        return max + 1;
    }

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        vis = new int[n];
        this.favorite = favorite;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                tmp = new HashMap<>();
                dfs(i, 1);
            }
        }
        System.out.println(maxCircle);

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < favorite.length; ++i) {
            map.putIfAbsent(favorite[i], new HashSet<>());
            map.get(favorite[i]).add(i);
        }
        boolean[] flag = new boolean[n];
        int sum = 0;
        for (int i = 0; i < favorite.length; ++i) {
            if (!flag[i]) {
                if (i == favorite[favorite[i]]) {
                    flag[i] = true;
                    flag[favorite[i]] = true;
                    map.get(i).remove(favorite[i]);
                    map.get(favorite[i]).remove(i);
                    sum += depth(map, i) + depth(map, favorite[i]) + 2;
                }
            }

        }
        return Math.max(sum, maxCircle);
    }





}
