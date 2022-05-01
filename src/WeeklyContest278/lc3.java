package WeeklyContest278;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/29/22
 */
public class lc3 {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long hashcode = 0;
        long pow = power;
        long mod = modulo;
        long m = 1;
        for (int i = 0; i < k; ++i) {
            m *= pow;
            m %= mod;
        }

        char[] c = s.toCharArray();
        String res = "";
        for (int i = c.length - 1; i >= 0; --i) {
            hashcode *= pow;
            hashcode %= mod;
            hashcode += (c[i] - 'a' + 1);
            hashcode %= mod;
            if (i + k <= c.length - 1) {
                hashcode -= (c[i + k] - 'a' + 1) * m;
                hashcode %= mod;
                hashcode += mod;
                hashcode %= mod;
            }
            if( i + k <= c.length){
                if (hashcode == hashValue) {
                    res = s.substring(i, i + k);
                }
            }
        }
        return res;
    }
}
