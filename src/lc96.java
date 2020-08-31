import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/25/20
 */
public class lc96 {
    public int numTrees(int n) {
        int[][] dp = new int[25][25];
        if(n == 0) return  0;
        return recursive(dp,1,n);
    }

    public int recursive(int[][] dp,int start, int end) {
        if (start >= end) {
           return 1;
        }

        int res = 0;
        for (int i = start; i <= end; ++i) {
            if(dp[start][i-1] == 0)
                dp[start][i-1] = recursive(dp,start, i - 1);
            if(dp[i+1][end] == 0)
                dp[i+1][end] = recursive(dp,i + 1, end);
            res += dp[start][i-1] * dp[i+1][end];
        }
        return res;
    }
}
