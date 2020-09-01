/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/2/20
 */
public class lc1400 {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        if (s.length() == k) return true;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int single = 0;
        for (int i = 0; i < 26; ++i) {
            if (count[i]%2 == 1) single++;
        }
        if (single > k) return false;
        else return true;
    }
}
