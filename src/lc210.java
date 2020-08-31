import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/25/20
 */
public class lc210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] pre = new List[numCourses];
        int[] preCount = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            pre[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; ++i) {
            pre[prerequisites[i][0]].add(prerequisites[i][1]);
            preCount[prerequisites[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (preCount[i] == 0)
                q.add(i);
        }
        int now = 0;
        int[] res = new int[numCourses];
        while (!q.isEmpty()) {
            int tmp = q.poll();
            res[now++] = tmp;
            for (int i = 0; i < pre[tmp].size(); ++i) {
                preCount[pre[tmp].get(i)]--;
                if (preCount[pre[tmp].get(i)] == 0)
                    q.add(pre[tmp].get(i));
            }
        }

        if (now == numCourses) return res;
        else return new int[]{};
    }
}
