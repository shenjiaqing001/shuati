package WeeklyContest285;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/19/22
 */
public class lc3 {

    int max = 0;
    int[] res = new int[12];

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        dfs(aliceArrows, new int[12], 11, numArrows, 0);
        return res;
    }

    public void dfs(int[] aliceArrows, int[] now, int index, int left, int score) {
        if (index == -1) {
            if (score > max) {
                for (int i = 0; i < 12; ++i) {
                    res[i] = now[i];
                }
                res[0] += left;
            }
            return;
        }

        if (left > aliceArrows[index]) {
            now[index] = aliceArrows[index] + 1;
            dfs(aliceArrows, now, index - 1, left - now[index], score + index);
            now[index] = 0;
        }
        dfs(aliceArrows, now, index - 1, left, score);
    }

}
