package BiWeeklyContest34;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/5/20
 */
public class lc3 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < arr.length - 1 && arr[left] <= arr[left + 1])
            left++;
        if (left == arr.length - 1) return 0;
        while (right >= left && arr[right] >= arr[right - 1]) right--;
        if (right == 0) return arr.length - 1;

        int res = Math.min(arr.length - 1 - left, right);

        int i = 0;
        int j = right;
        while (i <= left && j < arr.length) {
            if (arr[j] >= arr[i]) {
                res = Math.min(res, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return res;
    }
}
