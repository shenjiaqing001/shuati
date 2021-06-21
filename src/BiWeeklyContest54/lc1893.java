package BiWeeklyContest54;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/12
 */
public class lc1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] flag = new boolean[51];
        for (int i = 0; i < ranges.length; ++i) {
            int l = ranges[i][0];
            int r = ranges[i][1];
            for (int j = l; j <= r; ++j) {
                flag[j] = true;
            }
        }
        for (int i = left; i <= right; ++i) {
            if (!flag[i]) return false;
        }
        return true;
    }
}
