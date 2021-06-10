/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/18
 */
public class lc1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] map = new int[10][10];
        for (int[] domino : dominoes) {
            map[domino[0]][domino[1]]++;
        }
        int res = 0;
        for (int i = 1; i <= 9; ++i) {
            for (int j = i; j <= 9; ++j) {
                int sum = map[i][j] + map[j][i];
                if (i == j) sum /= 2;
                res += sum * (sum - 1) / 2;
            }
        }
        return res;
    }
}
