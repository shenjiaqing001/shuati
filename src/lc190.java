/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/19/20
 */
public class lc190 {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            ans <<= 1;
            ans = ans | (n & 1);
            n >>= 1;
        }
        return ans;
    }
}
