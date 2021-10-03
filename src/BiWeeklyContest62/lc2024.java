package BiWeeklyContest62;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/2
 */
public class lc2024 {
    public int longestOnes(char[] c, int K, char s) {
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < c.length) {
            if (c[right++] != s) {
                K--;
                while (K < 0) {
                    if (c[left++] != s) K++;
                }
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(longestOnes(answerKey.toCharArray(), k, 'T'),
                longestOnes(answerKey.toCharArray(), k, 'F'));
    }
}
