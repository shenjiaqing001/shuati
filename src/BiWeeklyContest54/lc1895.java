package BiWeeklyContest54;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/12
 */
public class lc1895 {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] hori = new int[n + 1][m + 1];
        int[][] vert = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                hori[i][j] = hori[i][j - 1] + grid[i - 1][j - 1];
                vert[i][j] = vert[i - 1][j] + grid[i - 1][j - 1];
            }
        }
        int k = Math.min(n, m);
        while (k >= 2) {


            for (int i = k; i <= n; ++i) {
                for (int j = k; j <= m; ++j) {
                    int sum = hori[i][j] - hori[i][j - k];
                    boolean flag = true;
                    int ltrb = 0;
                    int lbrt = 0;
                    for (int l = 0; l < k; ++l) {
                        if (flag) {
                            if (hori[i - l][j] - hori[i - l][j - k] != sum) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            if (vert[i][j - l] - vert[i - k][j - l] != sum) {
                                flag = false;
                                break;
                            }
                        }
                        ltrb += grid[i - l - 1][j - l - 1];
                        lbrt += grid[i - k + l][j - l - 1];
                    }
                    System.out.println(i + " " + j + " " + " " + sum);
                    if (ltrb != sum || lbrt != sum) flag = false;
                    if (flag)
                        return k;
                }
            }
            k--;
        }


        return 1;
    }
}
