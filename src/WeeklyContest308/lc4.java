package WeeklyContest308;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/27/22
 */
public class lc4 {
    public int[] getTopo(int k, int[][] conditions) {
        int[] indegree = new int[k + 1];
        Map<Integer, List<Integer>> outDegree = new HashMap<>();
        for (int[] rc : conditions) {
            outDegree.putIfAbsent(rc[0], new ArrayList<>());
            outDegree.get(rc[0]).add(rc[1]);
            indegree[rc[1]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= k; ++i) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] rRes = new int[k + 1];
        for (int i = 1; i <= k; ++i) {
            if (q.isEmpty()) return null;
            int now = q.poll();
            rRes[now] = i;
            if (outDegree.containsKey(now)) {
                for (int child : outDegree.get(now)) {
                    indegree[child]--;
                    if (indegree[child] == 0) {
                        q.add(child);
                    }
                }
            }
        }
        return rRes;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rRes = getTopo(k, rowConditions);
        int[] cRes = getTopo(k, colConditions);
        if (rRes == null || cRes == null) {
            return new int[0][0];
        }
        int[][] res = new int[k][k];
        for (int i = 1; i <= k; ++i) {
            res[rRes[i] - 1][cRes[i] - 1] = i;
        }
        return res;
    }
}
