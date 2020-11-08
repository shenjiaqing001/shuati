/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/8
 */
public class lc1486 {
    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; ++i) {
            res = res ^ (start + 2 * i);
        }
        return res;
    }
}
