/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/27
 */
public class lc383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] num = new int[26];
        for (char c : magazine.toCharArray()) {
            num[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (num[c - 'a'] == 0) return false;
            num[c - 'a']--;
        }
        return true;
    }
}
