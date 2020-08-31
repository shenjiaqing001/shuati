/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 6/16/20
 */
public class lc59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int index = 1;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bot = n - 1;
        while (true) {
            for (int i = left; i <= right; ++i) {
                result[top][i] = index;
                index++;
            }
            top++;
            if (index > n * n)
                break;
            for (int i = top; i <= bot; ++i) {
                result[i][right] = index;
                index++;
            }
            right--;
            if (index > n * n)
                break;
            for (int i = right; i >= left; --i) {
                result[bot][i] = index;
                index++;
            }
            bot--;
            if (index > n * n)
                break;
            for (int i = bot; i >= top; --i) {
                result[i][left] = index;
                index++;
            }
            left++;
            if (index > n * n)
                break;
        }
        return result;
    }


    public static void main(String[] args) {
        lc59 t = new lc59();
        int[][] res = t.generateMatrix(4);
        for (int i = 0; i < res.length; ++i) {
            for (int j = 0; j < res[i].length; ++j) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

}
