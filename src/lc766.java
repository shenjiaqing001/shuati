/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/8
 */
public class lc766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int total = m + n - 1;
        for (int i = 0; i < total; ++i) {
            int num = -1;
            boolean flag = true;
            int startPos = n - 1 - i;

            for (int j = 0; j <= i; ++j) {
                int nowPosX = startPos + j;
                int nowPosY = j;
                if (nowPosX < 0 || nowPosY >= m) continue;
                if (num == -1) {
                    num = matrix[nowPosX][nowPosY];
                } else if (num != matrix[nowPosX][nowPosY]) return false;
            }
        }
        return true;
    }
}
