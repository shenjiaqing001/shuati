/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/20
 */
public class lc868 {
    public int binaryGap(int n) {
        int num = -1;
        int max = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (num == -1) {
                    num = 0;
                } else {
                    max = Math.max(max, num);
                    num = 0;
                }
            }
            n /= 2;
            if (num != -1) num++;
        }
        return max;
    }
}
