import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/8
 */
public class lc940 {
    public int distinctSubseqII(String s) {
        int n = s.length();
        int mod = 1_000_000_007;
        int res = 0;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) != s.charAt(i)) {
                    dp[i] += dp[j];
                    dp[i] %= mod;
                }
            }
            res += dp[i];
            res %= mod;
        }
        return res;
    }

    // a b c
    // 1 0 0 sum = 1
    // 1 2 0 sum = 3
    // 1 2 4 sum = 7

    // a a a
    // 1 0 0 sum = 1
    // 2 0 0 sum = 2
    // 3 0 0 sum = 3
    public int distinctSubseqII2(String s) {
        long mod = 1_000_000_007;
        long[] count = new long[26];
        long sum = 0;
        for (char c : s.toCharArray()) {
            count[c - 'a'] = sum + 1;
            sum = Arrays.stream(count).sum();
            sum %= mod;
        }
        return (int) sum;
    }

    // a b c
    // 1 0 0 sum = 1
    // 1 2 0 sum = 3
    // 1 2 4 sum = 7


    public int distinctSubseqII3(String s) {
        long mod = 1_000_000_007;
        long[] count = new long[26];
        long sum = 0;
        for (char c : s.toCharArray()) {
            long tmp = count[c - 'a'];
            count[c - 'a'] = sum + 1;
            count[c - 'a'] %= mod;
            sum = sum + count[c - 'a'] - tmp + mod;
            sum %= mod;
        }
        return (int) sum;
    }


}
