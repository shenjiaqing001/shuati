package WeeklyContest286;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/26/22
 */
public class lc3 {
    long nthPalindrome(long n, long k) {
        long temp = (k & 1) != 0 ? (k / 2) : (k / 2 - 1);
        long palindrome = (long) Math.pow(10, temp);
        palindrome += n - 1;
        StringBuilder sb = new StringBuilder();
        sb.append(palindrome);

        if ((k & 1) > 0)
            palindrome /= 10;

        // print the last half digits of palindrome
        while (palindrome > 0) {
            sb.append(palindrome % 10);
            palindrome /= 10;
        }
        if(sb.length() > k) return -1;
        return Long.valueOf(sb.toString());
    }

    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] res = new long[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            res[i] = nthPalindrome(queries[i], intLength);
        }
        return res;
    }
}
