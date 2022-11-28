package WeeklyContest306;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/13/22
 */
public class lc4 {
    public int countSpecialNumbers(int n) {
        int[] tmp = new int[]{
                0,//0
                9,//1
                81,//2
                9 * 9 * 8,//3
                9 * 9 * 8 * 7,//4
                9 * 9 * 8 * 7 * 6,//5
                9 * 9 * 8 * 7 * 6 * 5,//6
                9 * 9 * 8 * 7 * 6 * 5 * 4,//7
                9 * 9 * 8 * 7 * 6 * 5 * 4 * 3,//8
                9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2,//9
                9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1//10
        };
        int res = 0;
        int length = Integer.toString(n).length();
        for (int i = 0; i < length; ++i) {
            res += tmp[i];
        }
        String s = Integer.toString(n);
        char[] c = s.toCharArray();
        boolean needflag = true;
        Set<Character> totalDigit = new HashSet<>();
        for (int i = 0; i < s.length() - 1; ++i) {
            if (i == 0) {
                int count = c[i] - '1';
                int start = 10 - (i + 1);
                int times = 1;
                int end = 11 - s.length();
                for (int j = start; j >= end; --j) times *= j;
                res += count * times;
            } else {
                int count = 0;
                Set<Character> set = new HashSet<>();
                for (int d = 0; d < i; ++d) {
                    set.add(c[d]);
                }
                for (int d = '0'; d < c[i]; ++d) {
                    if (!set.contains((char) d)) count++;
                }
                int start = 10 - (i + 1);
                int times = 1;
                int end = 11 - s.length();
                for (int j = start; j >= end; --j) times *= j;
                res += count * times;
            }
            if (totalDigit.contains(c[i])) {
                needflag = false;
                break;
            }
            totalDigit.add(c[i]);
        }
        if (needflag) {
            int num = n / 10 * 10;
            for (int i = Math.max(1, num); i <= n; ++i) {
                boolean flag = true;
                Set<Integer> set = new HashSet<>();
                int nnn = i;
                while (nnn > 0) {
                    int digit = nnn % 10;
                    nnn /= 10;
                    if (set.contains(digit)) {
                        flag = false;
                    }
                    set.add(digit);
                }
                if (flag) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
        test.countSpecialNumbers(187268091);
    }
}
