import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/26/20
 */
public class lc438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] hash = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            hash[p.charAt(i) - 'a']++;
        }
        int count = p.length();
        int left = 0;
        int right = 0;
        List<Integer> res = new LinkedList<>();
        while (right < s.length()) {
            if (hash[s.charAt(right) - 'a'] >= 1) {
                count--;
            }
            hash[s.charAt(right) - 'a']--;
            if (count == 0) {
                res.add(left);
            }
            right++;

            if (right - left == p.length()) {
                if (hash[s.charAt(left - 'a')] >= 0)
                    count++;
                hash[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return res;
    }
}
