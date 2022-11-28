package WeeklyContest313;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/1/22
 */
public class lc4 {
    char[] c;
    int[] memo;
    long[] bit;
    long base = 26;
    String tmp;


    public int maxDelete(int pos) {
        if (memo[pos] != 0) return memo[pos];
        if (pos == c.length - 1) return 1;
        int max = 1;


        int i = pos;
        int j = pos + 1;
        int k = pos + 1;
        long n1 = c[pos] - 'a';
        long n2 = c[pos + 1] - 'a';
        if (n1 == n2) {
            max = Math.max(max, maxDelete(j) + 1);
        }
        while (k + 2 < c.length) {
            i++;
            n1 *= 26;
            n1 += c[i] - 'a';
            n2 -= bit[k - j] * (c[j] - 'a');
            n2 *= 26 * 26;
            n2 += (c[k + 1] - 'a') * 26 + c[k + 2] - 'a';
            j++;
            k += 2;
            if (n1 == n2) {
                max = Math.max(max, maxDelete(j) + 1);
            }
        }
        memo[pos] = max;
        return max;
    }

    public int maxDelete2(int pos) {
        if (memo[pos] != 0) return memo[pos];
        if (pos == c.length - 1) return 1;
        int max = 1;

        int j = pos + 1;
        int k = pos + 2;
        while (k <= c.length) {
            String s1 = tmp.substring(pos, j);
            String s2 = tmp.substring(j, k);
            if (s1.equals(s2)) {
                max = Math.max(max, maxDelete2(j));
            }
            j++;
            k += 2;
        }
        memo[pos] = max;
        return max;
    }


    public int deleteString(String s) {
        tmp = s;
        c = s.toCharArray();
        memo = new int[s.length()];
        bit = new long[s.length()];
        bit[0] = 1;
        for (int i = 1; i < c.length; ++i) {
            bit[i] = bit[i - 1] * base;
        }
        return maxDelete2(0);
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
        test.deleteString("abcabcdabc");
    }
}
