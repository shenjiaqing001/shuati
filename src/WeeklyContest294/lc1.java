package WeeklyContest294;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/21/22
 */
public class lc1 {
    public int percentageLetter(String s, char letter) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        return count[letter - 'a'] * 100 / s.length();
    }
}
