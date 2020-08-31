/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/14/20
 */
public class lc409 {
    public int longestPalindrome(String s) {
        int[] count = new int[100];

        int single = 0;
        int dual = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (count[c - 'A'] == 1) {
                single--;
                dual++;
                count[c - 'A'] = 0;
            } else {
                single++;
                count[c - 'A']++;
            }
        }

        return single > 0 ? dual * 2 + 1 : dual * 2;
    }
}
