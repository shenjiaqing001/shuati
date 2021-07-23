/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/21
 */
public class lc214 {
    public String shortestPalindrome(String s) {
        if (s.equals("")) return s;
        char[] c = s.toCharArray();
        long base = 26;


        long pow_base = 1;
        int max = 0;
        long left = 0;
        long right = 0;
        for (int i = 0; i < c.length; ++i) {
            left = left * base + c[i] - 'a';
            right = right + pow_base * (c[i] - 'a');
            pow_base *= base;
//            System.out.println(left + " " + right);
            if (left == right) max = i;
        }
        StringBuilder sb = new StringBuilder(s.substring(max + 1));
        sb = sb.reverse();
        return sb.toString() + s;
    }
}
