package WeeklyContest272;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/18/21
 */
public class lc1 {

    public boolean isPad(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length / 2; ++i) {
            if (c[i] != c[c.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public String firstPalindrome(String[] words) {
        for (String s : words) {
            if (isPad(s)) return s;
        }
        return "";
    }


}
