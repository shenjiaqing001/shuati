import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/5
 */
public class lc480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeSet<Integer> leftHeap = new TreeSet<>((o1, o2) -> {
            if (nums[o2] == nums[o1]) return o1 - o2;
            return Integer.compare(nums[o1], nums[o2]);
        });
        TreeSet<Integer> rightHeap = new TreeSet<>((o1, o2) -> {
            if (nums[o2] == nums[o1]) return o1 - o2;
            return Integer.compare(nums[o1], nums[o2]);
        });

        for (int i = 0; i < k; ++i) {
            leftHeap.add(i);
        }

        while (leftHeap.size() - rightHeap.size() > 1) rightHeap.add(leftHeap.pollLast());

        double[] res = new double[nums.length - k + 1];
        if (k % 2 == 0) {
            res[0] = (nums[leftHeap.last()] + nums[rightHeap.first()]) / 2.0;
        } else {
            res[0] = nums[leftHeap.last()];
        }


        for (int i = k; i < nums.length; ++i) {
            if (!leftHeap.remove(i - k)) {
                rightHeap.remove(i - k);
            }
            leftHeap.add(i);

            if (leftHeap.size() - rightHeap.size() >= 2) rightHeap.add(leftHeap.pollLast());
            if (!rightHeap.isEmpty() && nums[leftHeap.last()] > nums[rightHeap.first()]) {
                leftHeap.add(rightHeap.pollFirst());
                rightHeap.add(leftHeap.pollLast());
            }

            if (k % 2 == 0) {
                res[i - k + 1] = (nums[leftHeap.last()] + nums[rightHeap.first()]) / 2.0;
            } else {
                res[i - k + 1] = nums[leftHeap.last()];
            }
        }

        return res;
    }


    public static void main(String[] args) {
        lc480 test = new lc480();
        test.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);


    }
}
