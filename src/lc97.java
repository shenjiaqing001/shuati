/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/25/20
 */
public class lc97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        if (s1.length() + s2.length() != s3.length()) return false;
        recursive(dp, s1, s2, s3, 0, 0);
        return dp[s1.length()][s2.length()] == 1;
    }


    public int recursive(int[][] dp, String s1, String s2,
                         String s3, int p1, int p2) {
        if (p1 == s1.length() && p2 == s2.length()) {
            dp[p1][p2] = 1;
            return 1;
        }
        if (dp[p1][p2] != 0)
            return dp[p1][p2];

        int go1 = -1;
        if (p1 < s1.length() && s1.charAt(p1) == s3.charAt(p1 + p2)) {
            go1 = recursive(dp, s1, s2, s3, p1 + 1, p2);
        }
        int go2 = -1;
        if (p2 < s2.length() && s2.charAt(p2) == s3.charAt(p1 + p2)) {
            go2 = recursive(dp, s1, s2, s3, p1, p2 + 1);
        }
        if (go1 == 1 || go2 == 1) dp[p1][p2] = 1;
        else dp[p1][p2] = -1;
        return dp[p1][p2];
    }

    public static void main(String[] args) {
        lc97 t = new lc97();
        System.out.println(t.isInterleave("a", "b", "ab"));
    }

}
