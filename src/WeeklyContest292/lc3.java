package WeeklyContest292;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/7/22
 */
public class lc3 {
    public int countTexts(String pressedKeys) {
        // 1
        // 2, 1 1
        // 1 1 1, 2 1, 1 2, 3
        // 1 1 1 1, 2 1 1, 1 1 2, 1 2 1, 2 2, 1 3, 3 1, 4
        long[] modRes = new long[10001];
        modRes[0] = 1;
        char[] c = pressedKeys.toCharArray();
        long res = 1;
        long mod = 1_000_000_007;
        int count = 1;
        for (int i = 1; i <= 10000; ++i) {
            modRes[i] = modRes[i - 1] * 2;
            modRes[i] %= mod;
        }
        for (int i = 1; i < c.length; ++i) {
            if (c[i] == c[i - 1]) {
                count++;
            } else {
                res *= (long) modRes[count - 1];
                res %= mod;
                count = 1;
            }
        }
        long tmp = modRes[count - 1] % mod;
        res *= tmp;
        res %= mod;
        return (int) res;
    }

    public int countTexts2(String pressedKeys) {
        long[] mod3 = new long[10001];
        mod3[1] = 1;
        mod3[2] = 2;
        mod3[3] = 4;

        long[] mod4 = new long[10001];
        mod4[1] = 1;
        mod4[2] = 2;
        mod4[3] = 4;
        mod4[4] = 8;


        char[] c = pressedKeys.toCharArray();
        long res = 1;
        long mod = 1_000_000_007;
        int count = 1;
        for (int i = 4; i <= 10000; ++i) {
            mod3[i] = mod3[i - 1] + mod3[i - 2] + mod3[i - 3];
            mod3[i] %= mod;
        }
        for (int i = 5; i <= 10000; ++i) {
            mod4[i] = mod4[i - 1] + mod4[i - 2] + mod4[i - 3] + mod4[i - 4];
            mod4[i] %= mod;
        }
        for (int i = 1; i < c.length; ++i) {
            if (c[i] == c[i - 1]) {
                count++;
            } else {
                if (c[i - 1] == '7' || c[i - 1] == '9') res *= (long) mod4[count];
                else res *= (long) mod3[count];
                res %= mod;
                count = 1;
            }
        }
        if (c[c.length - 1] == '7' || c[c.length - 1] == '9') res *= (long) mod4[count];
        else res *= (long) mod3[count];
        res %= mod;
        return (int) res;
    }
}
