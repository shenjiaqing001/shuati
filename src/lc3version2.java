/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/17
 */
public class lc3version2 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        char[] c = new char[256];
        int max = 0;
        while (right < s.length()) {
            c[s.charAt(right)]++;
            if (c[s.charAt(right)] == 2) {
                while (c[s.charAt(right)] > 1) {
                    c[s.charAt(left++)]--;
                }
            }
            right++;
            max = Math.max(max, right - left);
        }
        return max;
    }
}
