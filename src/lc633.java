/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/25
 */
public class lc633 {
    public boolean judgeSquareSum(int c) {
        if (c % 4 == 3) return false;
        for (int i = 0; i <= Math.sqrt(c); ++i) {
            int j = (int) Math.sqrt(c - i * i);
            if (c == i * i + j * j) return true;
        }
        return false;
    }

    public boolean judgeSquareSum2(int c) {
        if (c % 4 == 3) return false;
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left < right) {
            int squareSum = left * left + right * right;
            if (squareSum == c) return true;
            else if (squareSum < c) left++;
            else right--;
        }
        return false;
    }
}
