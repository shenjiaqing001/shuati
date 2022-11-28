package z.template.Math;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/27/22
 */
public class Euler {

    // φ(x)=x(1-1/p1)(1-1/p2)(1-1/p3)(1-1/p4)…..(1-1/pn)
    public int eulerFunction(int n) {
        int phin = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                phin = phin / i * (i - 1);
                while (n % i == 0) n /= i;
            }
        }
        if (n != 1) {
            phin = phin / n * (n - 1);
        }
        return phin;
    }

    // (a, m) = 1 -> a^(φ(m)) = 1

    // 求 a^-1 mod p, a^-1 = a^p-2
    // 求a关于p的逆元
    public long inverse(long a, long p) {
        long res = 1;
        long base = a;
        long m = p - 2;
        while (m != 0) {
            if ((m & 1) == 1) {
                res = (res * base) % p;
            }
            base = (base * base) % p;
            m = m >> 1;
        }
        return res;
    }

    // 求1-n关于p的逆元
    // inverse[i] = (p-p/i) * inv[p mod i] mod p
    public long[] inverseN(int n, long p) {
        long[] inv = new long[n + 1];
        inv[1] = 1;

        for (int i = 2; i <= n; i++) {
            inv[i] = (p - p / i) * inv[(int) (p % i)] % p;
        }
        return inv;
    }

    // 求a1,a2,...,an的逆元
    // A1 = a1, S2 = a1*a2, Sn = a1*a2*...*an
    // Si = Si-1 * ai ->Si^-1
    // Si-1^-1 = Si^-1 * ai
    // inv[i] = Si^-1 * Si-1
    public long[] inverseArray(int[] nums, long p) {
        int n = nums.length;
        long[] inv = new long[n + 1];
        long[] s = new long[n + 1];
        long[] invs = new long[n + 1];
        s[0] = 1;
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] * nums[i] % p;
        }
        invs[n] = inverse(s[n], p);
        for (int i = n - 1; i >= 1; i--) {
            invs[i] = invs[i + 1] * nums[i + 1] % p;
        }
        inv[1] = invs[1];
        for (int i = 2; i <= n; ++i) {
            inv[i] = invs[i] * s[i - 1];
        }
        return inv;
    }


}
