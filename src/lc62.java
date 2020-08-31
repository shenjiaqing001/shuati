/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/20/20
 */
public class lc62 {
    /***
     1   1   1   1   1
     1   2   3   4   5
     1   3   6   10  15
     1   4   10  20  35
     1   5   15  35  70


     */
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i)
            map[i][1] = 1;
        for (int i = 1; i <= n; ++i)
            map[1][i] = 1;
        for (int i = 2; i <= m; ++i) {
            for (int j = 2; j <= n; ++j) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[m][n];
    }

}
