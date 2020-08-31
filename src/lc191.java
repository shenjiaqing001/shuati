/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/19/20
 */
public class lc191 {
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            if ((n & 1) == 1) res++;
            n >>>= 1;
        }
        return res;
    }
}
