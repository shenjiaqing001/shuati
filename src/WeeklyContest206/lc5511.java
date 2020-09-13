package WeeklyContest206;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/13/20
 */
public class lc5511 {
    public int numSpecial(int[][] mat) {
        int[] countrow = new int[mat.length];
        int[] countcolumn = new int[mat[0].length];
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                if (mat[i][j] == 1) {
                    countrow[i]++;
                    countcolumn[j]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                if (mat[i][j] == 1) {
                    if (countrow[i] == 1 && countcolumn[j] == 1)
                        res++;
                }
            }
        }

        return res;
    }
}
