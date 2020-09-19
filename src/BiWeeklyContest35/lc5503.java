package BiWeeklyContest35;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/19
 */
public class lc5503 {
    public int sumOddLengthSubarrays(int[] arr) {
        int type = (arr.length + 1) / 2;
        int res = 0;
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 1; j <= type; ++j) {
                int length = j * 2 - 1;
                int left = i - 0;
                int right = arr.length - 1 - i;
                int pos = Math.min(left, right);
                int times = Math.min(pos + 1, length);
                times = Math.min(times, arr.length - length + 1);
                res += arr[i] * times;
            }
        }
        return res;
    }
}
