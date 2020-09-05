/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/5/20
 */
public class lc1066 {
    int min = Integer.MAX_VALUE;

    public int assignBikes(int[][] workers, int[][] bikes) {
        boolean[] visited = new boolean[bikes.length];

        dfs(workers, bikes, visited, 0, 0);
        return min;
    }

    public void dfs(int[][] workers, int[][] bikes, boolean[] visited, int now, int dis) {
        if (now == workers.length) {
            min = Math.min(min, dis);
            return;
        }

        for (int i = 0; i < bikes.length; ++i) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(workers, bikes, visited, now + 1, dis + dis(workers[now], bikes[i]));
                visited[i] = false;
            }
        }

    }

    public int dis(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
