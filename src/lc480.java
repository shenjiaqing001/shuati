import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/5
 */
public class lc480 {
    public double[] medianSlidingWindow(int[] nums, int k) {

        // leftHeap : 1 2 3
        // rightHeap          4 5 6
        TreeSet<Integer> leftHeap = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (nums[o2] == nums[o1]) return o1 - o2;
                return Integer.compare(nums[o2], nums[o1]);
            }
        });
        TreeSet<Integer> rightHeap = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (nums[o2] == nums[o1]) return o1 - o2;
                return Integer.compare(nums[o1], nums[o2]);
            }
        });

        for (int i = 0; i < k; ++i) {
            leftHeap.add(i);
        }

        while (leftHeap.size() - rightHeap.size() > 1) rightHeap.add(leftHeap.pollFirst());

        System.out.println(leftHeap.size() + " " + rightHeap.size());
        double[] res = new double[nums.length - k + 1];
        if (k % 2 == 0) {
            res[0] = (nums[leftHeap.first()] + nums[rightHeap.first()]) / 2.0;
        } else {
            res[0] = nums[leftHeap.first()];
        }


        for (int i = k; i < nums.length; ++i) {
            if (!leftHeap.remove(i - k)) {
                rightHeap.remove(i - k);
            }

            if (leftHeap.isEmpty()) {
                leftHeap.add(i);
            } else if (nums[i] <= nums[leftHeap.first()]) {
                leftHeap.add(i);
                if (leftHeap.size() - rightHeap.size() > 1) {
                    rightHeap.add(leftHeap.pollFirst());
                }
            } else {
                rightHeap.add(i);
                if (rightHeap.size() > leftHeap.size()) {
                    leftHeap.add(rightHeap.pollFirst());
                }
            }


            if (k % 2 == 0) {
                res[i - k + 1] = (nums[leftHeap.first()] + nums[rightHeap.first()]) / 2.0;
            } else {
                res[i - k + 1] = nums[leftHeap.first()];
            }
        }

        return res;
    }


    public static void main(String[] args) {
        lc480 test = new lc480();
        test.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);


    }
}
