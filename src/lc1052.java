/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/28/20
 */
public class lc1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < customers.length; ++i) {
            if (grumpy[i] == 0)
                sum += customers[i];
        }
        for (int i = 0; i < X; ++i) {
            if (grumpy[i] == 1)
                sum += customers[i];
        }
        max = sum;
        int right = X;
        while (right < customers.length) {
            if (grumpy[right] == 1)
                sum += customers[right];
            if (grumpy[right - X] == 1)
                sum -= customers[right - X];
            max = Math.max(max, sum);
            right++;
        }
        return max;
    }
}
