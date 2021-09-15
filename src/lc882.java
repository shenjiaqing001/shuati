import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/12
 */
public class lc882 {
    public static void main(String[] args) {
        lc882 test = new lc882();
        test.reachableNodes(new int[][]{{1, 2, 5}, {0, 3, 3}, {1, 3, 2}, {2, 3, 4}, {0, 4, 1}}, 7,
                5);
    }

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<Integer>[] adjList = new List[n];
        int[][] adjArray = new int[n][n];
        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
            adjArray[edge[0]][edge[1]] = edge[2];
            adjArray[edge[1]][edge[0]] = edge[2];
        }
        int res = 0;
        boolean[] isVisited = new boolean[n];
        int[] leftMoves = new int[n];
        Arrays.fill(leftMoves, 0);

        // node movesLeft from
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o2[1] - o1[1]));
        pq.add(new int[]{0, maxMoves, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (leftMoves[now[0]] > now[1]) continue;
            leftMoves[now[0]] = now[1];
            isVisited[now[0]] = true;
            res += adjArray[now[0]][now[2]];
            adjArray[now[0]][now[2]] = 0;
            adjArray[now[2]][now[0]] = 0;
            for (Integer adj : adjList[now[0]]) {
                if (isVisited[adj]) continue;
                if (leftMoves[adj] > now[1] - adjArray[now[0]][adj] - 1) continue;
                pq.add(new int[]{adj, now[1] - adjArray[now[0]][adj] - 1, now[0]});
            }
        }
        for (int i = 0; i < n; ++i) {
            if (isVisited[i]) res++;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                res += Math.min(leftMoves[i] + leftMoves[j], adjArray[i][j]);
            }
        }

        return res;
    }
}
