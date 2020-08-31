/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/26/20
 */
public class lc680 {

    public boolean validPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1)
            return true;

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return valid(s, left + 1, right) || valid(s, left, right - 1);
            }
        }
        return true;
    }

    public boolean valid(String s, int left, int right) {
        if (left == right) return true;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
