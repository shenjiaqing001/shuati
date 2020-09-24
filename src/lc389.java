/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/25
 */
public class lc389 {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        for (char c : t.toCharArray()) {
            if (count[c - 'a'] == 0) return c;
            count[c - 'a']--;
        }
        return 'a';
    }
}
