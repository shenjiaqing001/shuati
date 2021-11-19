package OnlineAssessment.Citadel;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/18
 */
public class citadel {
    public static int mergeSort(int[] nums, int left, int right) {
        if (left == right) return 0;
        int mid = left + (right - left) / 2;
        int sumLeft = mergeSort(nums, left, mid);
        int sumRight = mergeSort(nums, mid + 1, right);
        int[] numsLeft = new int[mid - left + 1];
        int[] numsRight = new int[right - mid];
        for (int i = 0; i < mid - left + 1; ++i) {
            numsLeft[i] = nums[left + i];
        }
        for (int i = 0; i < right - mid; ++i) {
            numsRight[i] = nums[mid + 1 + i];
        }

        int index1 = 0;
        int index2 = 0;
        int preSum = 0;
        int itemsCount = 0;
        int total = sumLeft + sumRight;
        int index = 0;
        while (index1 < numsLeft.length && index2 < numsRight.length) {
            if (numsLeft[index1] <= numsRight[index2]) {
                nums[index + left] = numsLeft[index1];
                total += itemsCount * numsLeft[index1];
                index1++;
                index++;
            } else {
                nums[index + left] = numsRight[index2];
                preSum += numsRight[index2];
                itemsCount++;
                total += preSum;
                index2++;
                index++;
            }
        }

        while (index1 < numsLeft.length) {
            nums[index + left] = numsLeft[index1];
            total += itemsCount * numsLeft[index1];
            index1++;
            index++;
        }
        while (index2 < numsRight.length) {
            nums[index + left] = numsRight[index2];
            index2++;
            index++;
        }
        return total;
    }
}
