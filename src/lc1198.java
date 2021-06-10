/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/3/23
 */
public class lc1198 {
    public int smallestCommonElement(int[][] mat) {
        int[] count = new int[10005];
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                count[mat[i][j]]++;
            }
        }
        for (int i = 1; i < count.length; ++i) {
            if (count[i] == mat.length) return i;
        }
        return -1;
    }
}
