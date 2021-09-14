package 秋季赛;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/11
 */
public class lc1 {
    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int[] count = new int[10001];
        for (int i = 0; i < source.length; ++i) {
            for (int j = 0; j < source[0].length; ++j) {
                count[source[i][j]]++;
            }
        }
        int res = 0;
        for (int i = 0; i < source.length; ++i) {
            for (int j = 0; j < source[0].length; ++j) {
                if (count[target[i][j]] > 0)
                    count[target[i][j]]--;
                else {
                    res++;
                }
            }
        }
        return res;
    }
}
