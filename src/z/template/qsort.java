package z.template;

import java.util.Random;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/23
 */
public class qsort {

    Random random = new Random();

    public void quickSort(int[] nums, int left, int right) {
        int r = random.nextInt(right - left + 1) + left;
        int mid = partition(nums, left, right, r);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }

    public int partition(int[] nums, int left, int right, int pivot) {
        swap(nums, pivot, right);
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[i] < nums[right]) ++i;
            while (i < j && nums[j] >= nums[right]) --j;
            swap(nums, i, j);
        }
        swap(nums, i, right);
        return i;
    }

    public void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }
}
