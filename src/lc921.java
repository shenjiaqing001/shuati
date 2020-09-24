/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/25
 */
public class lc921 {
    public int minAddToMakeValid(String S) {
        int count = 0;
        int res = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') count++;
            else {
                if (count == 0) res++;
                else count--;
            }
        }
        res += count;
        return res;
    }
}
