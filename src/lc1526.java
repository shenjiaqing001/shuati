

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/16
 */
public class lc1526 {
    public int minNumberOperations(int[] target) {
        int res = 0;
        int last = 0;
        for (int num : target) {
            if (last < num) {
                res += num - last;
            }
            last = num;
        }
        return res;
    }
}
