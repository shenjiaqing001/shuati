/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/18
 */
public class lc461 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
