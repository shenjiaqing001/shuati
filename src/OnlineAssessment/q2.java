package OnlineAssessment;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/29
 */
public class q2 {
    public int[] analysisHistogram(int[] heights, int cnt) {
        Arrays.sort(heights);
        int[] res = new int[cnt];
        int min = Integer.MAX_VALUE / 2;
        for (int i = 0; i <= heights.length - cnt; ++i) {
            if (heights[i + cnt - 1] - heights[i] < min) {
                min = heights[i + cnt - 1] - heights[i];
                for (int j = 0; j < cnt; ++j) {
                    res[j] = heights[i + j];
                }
            }
        }

        return res;
    }
}
