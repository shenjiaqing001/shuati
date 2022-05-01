package WeeklyContest277;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/22/22
 */
public class lc4 {
    int max = 0;
    int n;

    public int maximumGood(int[][] statements) {
        n = statements.length;
        for (int i = 0; i < (1 << n); ++i) {
            if (Integer.bitCount(i) > max) {
                if (checkState(i, statements)) {
                    max = Integer.bitCount(i);
                }
            }
        }
        return max;
    }

    public boolean checkState(int state, int[][] statements) {

        for (int i = 0; i < n; ++i) {
            if ((state & (1 << i)) == 0) continue;
            for (int j = 0; j < n; ++j) {
                if (statements[i][j] == 2) continue;
                if (statements[i][j] == 0 && (state & (1 << j)) != 0) return false;
                if (statements[i][j] == 1 && (state & (1 << j)) == 0) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(Integer.bitCount(3));
    }
}
