import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/8
 */
public class lc336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPalindrome(words[i] + words[j])) {
                    res.add(new ArrayList(Arrays.asList(i, j)));
                }
                if (isPalindrome(words[j] + words[i])) {
                    res.add(new ArrayList(Arrays.asList(j, i)));
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String str) {
        int length = str.length();
        for (int i = 0, j = length - 1; i < j; i++, j--)
            if (str.charAt(i) != str.charAt(j))
                return false;
        return true;
    }
}
