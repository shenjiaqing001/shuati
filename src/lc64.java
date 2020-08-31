/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/20/20
 */
public class lc64 {
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int length = grid[0].length;
        int[][] res = new int[height][length];
        res[0][0] = grid[0][0];
        for (int i = 1; i < length; ++i) {
            res[0][i] = grid[0][i] + res[0][i - 1];
        }
        for (int i = 1; i < height; ++i) {
            res[i][0] = grid[i][0] + res[i - 1][0];
        }

        for (int i = 1; i < height; ++i) {
            for (int j = 1; j < length; ++j) {
                res[i][j] = Math.min(res[i - 1][j] + grid[i][j],
                        res[i][j - 1] + grid[i][j]);
            }
        }
        return res[height - 1][length - 1];
    }

    public static void main(String[] args) {
        lc64 t = new lc64();
        int[][] grid = new int[3][3];
    }
}
