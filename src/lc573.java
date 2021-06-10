/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/2/3
 */
public class lc573 {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int max = Integer.MIN_VALUE;
        int res = 0;

        for (int i = 0; i < nuts.length; ++i) {
            res += 2 * (Math.abs(tree[0] - nuts[i][0]) + Math.abs(tree[1] - nuts[i][1]));
            max = Math.max(max, Math.abs(tree[0] - nuts[i][0]) + Math.abs(tree[1] - nuts[i][1]) -
                    Math.abs(squirrel[0] - nuts[i][0]) - Math.abs(squirrel[1] - nuts[i][1]));

        }
        return res - max;
    }
}
