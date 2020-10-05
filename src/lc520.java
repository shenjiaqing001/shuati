/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/6
 */
public class lc520 {
    public boolean detectCapitalUse(String word) {
        int lower = 0;
        int upper = 0;
        for (char c : word.toCharArray()) {
            if (c <= 'z' && c >= 'a') lower++;
            else upper++;
        }

        if (upper == 0 || upper == word.length()) return true;
        if (upper == 1 && word.charAt(0) <= 'Z' && word.charAt(0) >= 'A') return true;
        else return false;
    }
}
