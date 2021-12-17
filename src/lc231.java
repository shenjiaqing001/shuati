/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/14/21
 */
public class lc231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return ((n & (n - 1)) == 0);
    }
}
