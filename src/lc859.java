/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/13
 */
public class lc859 {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            boolean[] count = new boolean[26];
            for (char c : A.toCharArray()) {
                if (count[c - 'a']) return true;
                else count[c - 'a'] = true;
            }
            return false;
        }

        int counter = 0;
        int aChars = 0;
        int bChars = 0;
        for (int i = 0; i < A.length(); i++) {
            aChars += A.charAt(i);
            bChars += B.charAt(i);
            if (A.charAt(i) != B.charAt(i))
                counter++;
            if (counter > 2)
                return false;
        }
        return counter <= 2 && aChars == bChars;
    }
}
