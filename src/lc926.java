/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/10
 */
public class lc926 {
    public int minFlipsMonoIncr(String s) {
        char[] c = s.toCharArray();
        int n = c.length;

        int count0 = 0;
        for (char c1 : c) if (c1 == '0') count0++;
        int count1 = 0;
        int min = Math.min(count0 + count1, n);
        for (char c1 : c) {
            if (c1 == '1') {
                count1++;
            } else {
                count0--;
            }
            min = Math.min(min, count0 + count1);
        }
        return min;
    }
}
