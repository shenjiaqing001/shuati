package WeeklyContest226;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/31
 */
public class lc3 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long[] sum = new long[n];
        sum[0] = candiesCount[0];
        for (int i = 1; i < n; ++i) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int type = queries[i][0];
            int day = queries[i][1];
            int cap = queries[i][2];
            if (sum[type] <= day || (type != 0 && sum[type - 1] >= (long) (day + 1) * (long) cap))
                res[i] = false;
            else res[i] = true;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println( (long)(1000000000 + 1) * (long) 1000000000);
    }
}
