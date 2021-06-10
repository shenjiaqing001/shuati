/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/19
 */
public class lc52 {

    public int totalNQueens(int n) {
        int[][] map = new int[n + 1][n + 1];
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            res += dfs(map, 1, i);
        }
        return res;
    }

    public int dfs(int[][] map, int x, int y) {
        for (int i = 1; i < x; ++i) {
            if (map[i][y] == 1) return 0;
            if (y - i > 0 && map[x - i][y - i] == 1) return 0;
            if (y + i <= map.length - 1 && map[x - i][y + i] == 1) return 0;
        }
        if (x == map.length - 1) return 1;
        else {
            int sum = 0;
            map[x][y] = 1;
            for (int i = 1; i < map.length; ++i) {
                sum += dfs(map, x + 1, i);
            }
            map[x][y] = 0;
            return sum;
        }
    }


}
