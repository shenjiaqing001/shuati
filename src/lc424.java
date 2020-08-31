import java.security.Key;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/28/20
 */
public class lc424 {
    public int characterReplacement(String s, int k) {
        char[] str = s.toCharArray();
        int[] count = new int[26];
        int maxCount = 0;
        int left = 0;
        int max = 0;
        for (int i = 0; i < str.length; ++i) {
            count[str[i] - 'A']++;
            maxCount = Math.max(maxCount, count[str[i] - 'A']);
            while (i - left + 1 - maxCount > k) {
                count[str[left] - 'A']--;
                left++;
            }
            max = Math.max(i - left + 1, max);
        }
        return max;
    }
}
