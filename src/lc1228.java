/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/22
 */
public class lc1228 {
    public int missingNumber(int[] arr) {
        int last = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; ++i) {
            if (last * 2 == arr[i + 1] - arr[i]) {
                return arr[i] + last;
            } else if (last == 2 * (arr[i + 1] - arr[i])) {
                return arr[i - 1] + last / 2;
            }
        }
        return 0;
    }
}
