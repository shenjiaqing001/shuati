import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/9
 */
public class lc848 {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            shifts[n - i - 1] %= 26;
            sum[n - i - 1] = sum[n - i] + shifts[n - i - 1];
            sum[n - i - 1] %= 26;
        }
        System.out.println(Arrays.toString(sum));
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; ++i) {
            int cc = c[i] + sum[i];
            if (cc > 'z') cc -= 26;
            sb.append((char) cc);
        }
        return sb.toString();
    }
}
