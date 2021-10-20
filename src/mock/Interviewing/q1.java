package mock.Interviewing;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/19
 */
public class q1 {
    //Given an integer array nums and two integers left and right,
    // return the number of contiguous non-empty subarrays such that
    // the value of the maximum array element in that subarray is in the range [left, right].
//Example 1:
//
//Input: nums = [2,1,4,3], left = 2, right = 3
//Output: 3
//Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].

    //BF o(n^3)


    public static void main(String[] args) {

    }

    public int solve(int[] nums, int left, int right) {
        int res = 0;
        int l = 0;
        int r = 0;

        for (int i = 0; i < nums.length; ++i) {
            for (; l < nums.length; l++) {
                if (nums[l] <= right && nums[l] >= left) break;
            }
            if (i < l) continue;
            if (nums[i] <= right) {
                res += i - l + 1;
            } else {
                l = r;
            }
        }

        return res;
    }
}
