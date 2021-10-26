/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/26
 */
public class lc1524 {
    public int numOfSubarrays(int[] arr) {
        int sum = 0;
        int odd = 0;
        int even = 1;
        int res = 0;
        for (int num : arr) {
            sum += num;
            if (sum % 2 == 0) {
                res += odd;
                even += 1;
            } else {
                res += even;
                odd += 1;
            }
            res %= 1_000_000_007;
        }
        return res;
    }
}
