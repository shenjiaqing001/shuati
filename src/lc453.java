/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/12/20
 */
public class lc453 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i : nums) min = Math.min(min, i);
        int res = 0;
        for (int i : nums) res += i - min;
        return res;
    }
}
