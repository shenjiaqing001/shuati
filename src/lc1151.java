/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/15
 */
public class lc1151 {
    public int minSwaps(int[] data) {
        int sum = 0;
        for (int i : data) {
            sum += i;
        }
        int min = Integer.MAX_VALUE;
        int tmp = 0;
        for (int i = 0; i < sum; ++i) {
            tmp += data[i];
        }
        min = sum - tmp;
        for (int i = sum; i < data.length; ++i) {
            tmp = tmp + data[i] - data[i - sum];
            min = Math.min(min, sum - tmp);
        }
        return min;
    }
}
