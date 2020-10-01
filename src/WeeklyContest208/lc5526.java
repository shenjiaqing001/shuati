package WeeklyContest208;

import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/27
 */
public class lc5526 {
    int res = 0;

    public int maximumRequests(int n, int[][] requests) {
        int[][] map = new int[n][n];
        for (int i = 0; i < requests.length; ++i) {
            if (requests[i][0] == requests[i][1]) res++;
            else map[requests[i][0]][requests[i][1]]++;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (map[i][j] > 0) {
                    map[i][j] -= 1;


                }
            }
        }
        return res;
    }
//
//    public int dfs(List<Integer> transfer, int[][] map, int now, int end) {
//
//    }
}
