package WeeklyContest320;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/19/22
 */
public class lc4 {

    Long[][] dp;
    long mod = 1_000_000_007;

    public boolean isPrime(char c) {
        return c == '2' || c == '3' || c == '5' || c == '7';
    }

    public long dfs(char[] c, int index, int k, int minLength) {
        if(k < 0) return 0;
        if (index == c.length) {
            if (k == 0) return 1;
            else return 0;
        }
        if (dp[index][k] != null) return dp[index][k];
        if (c.length - index < k * minLength) return 0;
        if (!isPrime(c[index])) return 0;
        long res = 0;
        for (int i = index + minLength - 1; i < c.length; i++) {
            if (!isPrime(c[i])) {
                res += dfs(c, i + 1, k - 1, minLength);
            }
        }
        res %= 1_000_000_007;
        dp[index][k] = res;
        return res;
    }

    public int beautifulPartitions(String s, int k, int minLength) {
        char[] c = s.toCharArray();
        dp = new Long[c.length][k + 1];
        long res =dfs(c, 0, k, minLength);;
        return (int) (res % mod);
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
        System.out.println(test.beautifulPartitions("23542185131", 3, 2));
    }
}
