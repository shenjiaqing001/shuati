/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/23/20
 */
public class lc81 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0)
            return false;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return true;

            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else if (nums[mid] > nums[left]) {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (nums[mid] == nums[left])
                left++;
            else if (nums[mid] == nums[right])
                right--;
        }
        return false;
    }

}
