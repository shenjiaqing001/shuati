/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/6
 */
public class lc1217 {
    public int minCostToMoveChips(int[] position) {
        int res = 0;
        for (int i = 0; i < position.length; ++i) {
            if (position[i] % 2 == 0) res++;
            else res--;
        }
        return (position.length - Math.abs(res)) / 2;
    }
}
