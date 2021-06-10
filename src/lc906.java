/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/8
 */
public class lc906 {

    public int superpalindromesInRange(String L, String R) {
        long[] table =
                new long[]{1, 2, 3, 11, 22, 101, 111, 121, 202, 212, 1001, 1111, 2002, 10001, 10101, 10201, 11011, 11111, 11211, 20002, 20102, 100001, 101101, 110011, 111111, 200002, 1000001, 1001001, 1002001, 1010101, 1011101, 1012101, 1100011, 1101011, 1102011, 1110111, 1111111, 2000002, 2001002, 10000001, 10011001, 10100101, 10111101, 11000011, 11011011, 11100111, 11111111, 20000002, 100000001, 100010001, 100020001, 100101001, 100111001, 100121001, 101000101, 101010101, 101020101, 101101101, 101111101, 110000011, 110010011, 110020011, 110101011, 110111011, 111000111, 111010111, 111101111, 111111111, 200000002, 200010002};
        int res = 0;
        long left = Long.valueOf(L);
        long right = Long.valueOf(R);
        left = (long) Math.sqrt(left);
        right = (long) Math.sqrt(right);
        for (int i = 0; i < table.length; ++i) {
            if (table[i] >= left && table[i] <= right) res++;
        }
        return res;
    }

    public static boolean isPa(long num) {

        String s = String.valueOf(num);
        for (int i = 0; i < s.length() / 2; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long tmp = 1;

        while (tmp <= 1000000000) {
            if (isPa(tmp) && isPa(tmp * tmp)) System.out.print(tmp + ",");
            tmp++;
        }
    }
}
