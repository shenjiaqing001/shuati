/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/4
 */
public class lc1220 {

    private final int mod = 1_000_000_007;

    public int countVowelPermutation(int n) {
        long a = 1;
        long e = 1;
        long i = 1;
        long o = 1;
        long u = 1;

        //ae
        //ea ei
        //ia ie io iu
        //oi ou
        //ua
        for (int step = 2; step <= n; ++step) {
            long aa = (e + i + u) % mod;
            long ee = (a + i) % mod;
            long ii = (e + o) % mod;
            long oo = i % mod;
            long uu = (i + o) % mod;

            a = aa;
            e = ee;
            i = ii;
            o = oo;
            u = uu;
        }

        return (int) (a + e + i + o + u) % mod;
    }
}
