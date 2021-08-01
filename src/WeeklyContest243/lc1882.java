package WeeklyContest243;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/29
 */
public class lc1882 {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        PriorityQueue<int[]> taskpq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> serverpq = new PriorityQueue<>((o1, o2) ->
                o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        for (int i = 0; i < n; ++i) {
            serverpq.add(new int[]{servers[i], i});
        }

        int m = tasks.length;
        int[] res = new int[m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            q.add(new int[]{i, tasks[i]});
        }
        int time = 0;
        while (!q.isEmpty()) {
            while (!taskpq.isEmpty() && taskpq.peek()[0] <= time) {
                int[] tmp = taskpq.poll();
                int id = tmp[1];
                serverpq.add(new int[]{servers[id], id});

            }
            if (!serverpq.isEmpty()) {
                int[] task = q.poll();
                int[] server = serverpq.poll();
                int id = server[1];
                taskpq.add(new int[]{time + task[1], server[1]});
                res[task[0]] = server[1];
                if (time <= task[0]) {
                    time = task[0] + 1;
                }
            } else {
                time = taskpq.peek()[0];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc1882 t = new lc1882();
        t.assignTasks(new int[]{3, 3, 2}, new int[]{1, 2, 3, 2, 1, 2});
    }
}
