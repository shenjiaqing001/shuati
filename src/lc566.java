/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/12/20
 */
public class lc566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || nums[0].length == 0) return nums;
        int x = nums.length;
        int y = nums[0].length;
        if (x * y != r * c) return nums;

        int[][] res = new int[r][c];
        int now = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                int orix = now / y;
                int oriy = now % y;
                res[i][j] = nums[orix][oriy];
                now++;
            }
        }

        return res;
    }
}
