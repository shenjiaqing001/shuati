/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/12
 */
public class lc1092 {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i < n1; ++i) {
            for (int j = 0; j < n2; ++j) {
                if (c1[i] == c2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        for (int i = 0; i <= n1; ++i) {
            for (int j = 0; j <= n2; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        StringBuilder sb = new StringBuilder();
        int i = n1;
        int j = n2;
        while (i >= 1 && j >= 1) {
            if (dp[i][j] == dp[i - 1][j]) {
                sb.insert(0, c1[i - 1]);
                i--;
                continue;
            }
            if (dp[i][j] == dp[i][j - 1]) {
                sb.insert(0, c2[j - 1]);
                j--;
                continue;
            }
            sb.insert(0, c1[i - 1]);
            i--;
            j--;
        }
        while (i >= 1) {
            sb.insert(0, c1[i - 1]);
            i--;
        }
        while (j >= 1) {
            sb.insert(0, c2[j - 1]);
            j--;
        }

        return sb.toString();
    }
}
