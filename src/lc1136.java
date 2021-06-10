import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/3/30
 */
public class lc1136 {
    public int minimumSemesters(int n, int[][] relations) {
        int[] inDegree = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] relation : relations) {
            inDegree[relation[1]]++;
            map.putIfAbsent(relation[0], new ArrayList<>());
            map.get(relation[0]).add(relation[1]);
        }
        int semester = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            if (inDegree[i] == 0) q.add(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int thisSemester = q.size();
            for (int i = 0; i < thisSemester; ++i) {
                int now = q.poll();
                count++;
                if (map.containsKey(now)) {
                    for (Integer pre : map.get(now)) {
                        inDegree[pre]--;
                        if (inDegree[pre] == 0) q.add(pre);
                    }
                }
            }
            semester++;
        }
        return count == n ? semester : -1;
    }
}
