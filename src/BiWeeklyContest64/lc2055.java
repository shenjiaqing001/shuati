package BiWeeklyContest64;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/30
 */
public class lc2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] preSum = new int[n];
        boolean flag = false;
        int count = 0;
        int last = 0;
        for (int i = 0; i < c.length; ++i) {
            if (c[i] == '|') {
                flag = true;
                preSum[i] = count;
                last = count;
            } else {
                if (flag) count++;
                preSum[i] = last;
            }
        }

        int[] dp = new int[n];
        int lastPlace = n - 1;
        for (int i = n - 1; i >= 0; --i) {
            if (c[i] == '|') {
                lastPlace = i;
            }
            dp[i] = lastPlace;
        }

        int[] res = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int num = preSum[query[1]] - preSum[dp[query[0]]];
            res[index++] = Math.max(num, 0);
        }
        return res;
    }
}
