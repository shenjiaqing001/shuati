/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/4/22
 */
public class lc1009 {
    public int bitwiseComplement(int n) {
        String s = Integer.toBinaryString(n);
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; ++i) {
            if (c[i] == '0') c[i] = '1';
            else c[i] = '0';
        }
        // System.out.println(String.valueOf(c));
        return Integer.parseInt(new String(c), 2);
    }
}
