/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/27/22
 */
public class lc1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long mod = 1_000_000_007;
        int res = 0;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum >= 0 && k >= 2) {
            res = (int) ((long) sum * (k - 2) % mod);
            k = 2;
        }
        k = Math.max(2, k);


        sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length * k; ++i) {
            int num = arr[i % arr.length];
            sum = Math.max(sum, sum + num);
            max = Math.max(max, sum);
        }
        return (int) ((res + max) % mod);
    }
}
