package CSCI761;

import java.math.BigInteger;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/26/20
 */
public class AnagramCounting {

    public String counting(String str) {
        BigInteger bg = BigInteger.ONE;
        int length = str.length();
        while (length > 0) {
            bg = bg.multiply(BigInteger.valueOf(length));
            length--;
        }
        int[] map = new int[52];
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; ++i) {
            if (c[i] >= 'a' && c[i] <= 'z') {
                map[c[i] - 'a']++;
            } else {
                map[c[i] - 'A' + 26]++;
            }
        }

        for (int i = 0; i < 52; ++i) {
            if (map[i] <= 1) continue;
            int tmp = map[i];
            while (tmp > 1) {
                bg = bg.divide(BigInteger.valueOf(tmp));
                tmp--;
            }
        }
        return bg.toString();
    }

    public static void main(String[] args) {
        AnagramCounting ac = new AnagramCounting();
        System.out.println(ac.counting("at"));
        System.out.println(ac.counting("ordeals"));
        System.out.println(ac.counting("abcdefghijklmnopqrstuvwxyz"));
        System.out.println(ac.counting("abcdefghijklmabcdefghijklm"));
        System.out.println(ac.counting("abcdABCDabcd"));
    }
}
