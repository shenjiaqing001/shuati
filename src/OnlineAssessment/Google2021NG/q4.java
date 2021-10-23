package OnlineAssessment.Google2021NG;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/21
 */
public class q4 {
    public static void main(String[] args) {
        q4 test = new q4();
        System.out.println(test.solution("B2R5G2R2"));
    }

    public int solution(String s) {
        int[] dp = new int[10];
        char[] c = s.toCharArray();
        // RGB
        for (int i = 0; i < c.length; i += 2) {
            char light = c[i];
            int pos = c[i + 1] - '0';
            if (light == 'R') dp[pos] |= (1 << 2);
            if (light == 'G') dp[pos] |= (1 << 1);
            if (light == 'B') dp[pos] |= (1);
        }
        int res = 0;
        for (int i = 0; i < 10; ++i) {
            if (dp[i] == 7)
                res++;
        }
        return res;
    }
}
