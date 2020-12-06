package BiWeeklyContest39;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/14
 */
public class lc5550 {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (k == 0) return res;
        int[] sum = new int[2 * code.length];
        sum[0] = code[0];
        for (int i = 1; i < sum.length; ++i) {
            sum[i] = sum[i - 1] + code[i % code.length];
        }

        if (k > 0) {
            for (int i = 0; i < res.length; ++i) {
                res[i] = sum[i + k] - sum[i];
            }
            return res;
        } else {
            //2 4 9 3
            //2 6 15 18 20 24 33 36

            int total = sum[2 * code.length - 1] / 2;
            for (int i = 0; i < res.length; ++i) {
                res[i] = 0 - sum[i + code.length + k - 1] + sum[i + code.length - 1];
            }
            return res;
        }
    }
}
