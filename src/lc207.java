import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/21/20
 */
public class lc207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        int[] pre = new int[numCourses];
        for (int i = 0; i < adj.length; ++i) {
            adj[i] = new LinkedList<>();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < prerequisites.length; ++i) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            pre[prerequisites[i][0]]++;
        }
        int take = 0;

        for (int i = 0; i < numCourses; ++i) {
            if (pre[i] == 0) {
                pq.add(i);
            }
        }

        while (pq.size() > 0) {
            take++;
            int now = pq.poll();
            for (Integer course : adj[now]) {
                System.out.println(course);
                pre[course]--;
                if (pre[course] == 0)
                    pq.add(course);
            }
        }
        return take == numCourses;
    }

    public static void main(String[] args) {
        lc207 t = new lc207();
        System.out.println(t.canFinish(2, new int[][]{{1, 0}}));
    }
}
