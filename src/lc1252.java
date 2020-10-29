/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/24
 */
public class lc1252 {
    public int oddCells(int n, int m, int[][] indices) {
        int[] column = new int[m];
        int[] rows = new int[n];
        for (int i = 0; i < indices.length; ++i) {
            rows[indices[i][0]]++;
            column[indices[i][1]]++;
        }

        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if ((rows[i] + column[j]) % 2 == 1) res++;
            }
        }
        return res;
    }
}
