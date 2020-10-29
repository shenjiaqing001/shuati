import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/25
 */
public class lc948 {
    public int bagOfTokensScore(int[] tokens, int P) {
        int score = 0;
        int left = 0;
        int right = tokens.length - 1;
        int max = 0;
        Arrays.sort(tokens);
        while (left <= right) {
            if (P >= tokens[left]) {
                P -= tokens[left];
                score++;
                left++;
                max = Math.max(score, max);
            } else if (score > 0) {
                score--;
                P += tokens[right];
                right--;
            } else {
                break;
            }
        }

        return max;
    }
}
