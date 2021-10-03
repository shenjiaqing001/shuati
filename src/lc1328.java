/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/24
 */
public class lc1328 {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) return "";
        StringBuilder sb = new StringBuilder(palindrome);
        int mid = (palindrome.length() / 2);
        for (int i = 0; i < mid; i++) {
            if (sb.charAt(i) == 'a') continue;
            sb.setCharAt(i, 'a');
            return sb.toString();
        }

        sb.setCharAt(palindrome.length() - 1, 'b');
        return sb.toString();
    }
}
