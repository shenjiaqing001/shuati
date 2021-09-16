package BiWeeklyContest59;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/21
 */
public class lc1977 {
    public static void main(String[] args) {
        System.out.println("84".compareTo("83"));
    }

    public int numberOfCombinations(String num) {
        int n = num.length();
        char[] c = num.toCharArray();
        if (c[0] == '0') return 0;
        int mod = 1_000_000_007;

        int[][] accum = new int[n + 2][n + 2];
        int[][] lcs = new int[n + 2][n + 2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (c[i] == c[j])
                    lcs[i][j] = lcs[i + 1][j + 1] + 1;
                else
                    lcs[i][j] = 0;
            }
        }


        for (int i = 0; i < n; i++)
            for (int len = 1; len <= i + 1; len++) {
                int j = i - len + 1;
                int dp = 0;

                if (c[j] == '0')
                    dp = 0;
                else if (len == i + 1)
                    dp = 1;
                else {
                    int maxLen2 = Math.min(len, j);

                    if (len == maxLen2 && lcs[j - maxLen2][j] < len &&
                            c[j - maxLen2 + lcs[j - maxLen2][j]] > c[j + lcs[j - maxLen2][j]])
                        maxLen2--;
                    while (maxLen2 >= 1 && c[j - maxLen2] == '0')
                        maxLen2--;

                    if (maxLen2 >= 1)
                        dp = accum[j - 1][maxLen2];
                }

                accum[i][len] = (accum[i][len - 1] + dp) % mod;
            }

        return accum[n - 1][n];
    }

}
