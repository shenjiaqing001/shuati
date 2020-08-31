/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/27/20
 */
public class lc340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        char[] str = s.toCharArray();
        int max = 0;
        int left = 0;
        int dif = 0;
        for (int i = 0; i < str.length; ++i) {
            if (count[str[i]]++ == 0) {
                dif++;
            }

            while (dif > k) {
                count[str[left]]--;
                if (count[str[left]] == 0)
                    dif--;
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
