package LeetCodeContest.Fall2021.个人赛;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/11
 */
public class lc4 {
    public int circleGame(int[][] toys, int[][] circles, int r) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] circle : circles) {
            map.putIfAbsent(circle[0], new HashSet<>());
            map.get(circle[0]).add(circle[1]);
        }
        int res = 0;
        for (int[] toy : toys) {
            if (check(toy, map, r)) res++;
        }
        return res;
    }

    public boolean check(int[] toy, Map<Integer, Set<Integer>> map, int r) {
        if (toy[2] > r) return false;
        toy[2] = r - toy[2];

        for (int i = toy[0] - toy[2]; i <= toy[0] + toy[2]; ++i) {
            if (!map.containsKey(i)) continue;
            for (int j = toy[1] - toy[2]; j <= toy[1] + toy[2]; ++j) {
                int dis = (i - toy[0]) * (i - toy[0]) + (j - toy[1]) * (j - toy[1]);
                if (dis <= toy[2] * toy[2]) {
                    if (map.get(i).contains(j)) return true;
                }
            }
        }
        return false;
    }
}
