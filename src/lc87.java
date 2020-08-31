import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/24/20
 */
public class lc87 {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;

        int s1Array[] = new int[26];
        int s2Array[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Array[s1.charAt(i) - 'a']++;
            s2Array[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++)
            if (s1Array[i] != s2Array[i])
                return false;


        for (int i = 1; i < s1.length(); ++i) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) &&
                    isScramble(s1.substring(i),
                            s2.substring(0, s1.length() - i)))
                return true;
        }
        return false;


    }
}
