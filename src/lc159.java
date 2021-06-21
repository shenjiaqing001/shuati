/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/13/20
 */
public class lc159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2) return s.length();

        char[] c = s.toCharArray();
        int[] count = new int[256];
        int n = 0;

        int left = 0;
        int max = 0;
        int right = 0;
        while (right < s.length()) {
            if (count[c[right]] == 0) {
                n++;
            }
            count[c[right]]++;
            while (n > 2) {
                count[c[left]]--;
                if (count[c[left]] == 0) n--;
                left++;
            }
            right++;
            max = Math.max(max, right - left);
        }

        return max;
    }


    public static void main(String[] args) {
        lc159 t = new lc159();
        System.out.println(t.lengthOfLongestSubstringTwoDistinct("ccaaccbbb"));
    }
}
