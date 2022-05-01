import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/27
 */
public class lc315 {
    class NumNode {
        int index;
        int num;
        int count;

        public NumNode(int num, int index) {
            this.num = num;
            this.index = index;
            this.count = 0;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        NumNode[] numbers = new NumNode[n];
        for (int i = 0; i < n; ++i) {
            numbers[i] = new NumNode(nums[i], i);
        }
        Queue<NumNode> sortedNum = mergeSort(numbers, 0, n - 1);
        List<Integer> res = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) res.add(0);

        while (!sortedNum.isEmpty()) {
            NumNode num = sortedNum.poll();
            res.set(num.index, num.count);
        }
        return res;
    }

    public Queue<NumNode> mergeSort(NumNode[] nums, int left, int right) {
        if (left == right) {
            Queue<NumNode> list = new ArrayDeque<>();
            list.add(nums[left]);
            return list;
        }

        int mid = (left + right) / 2;
        Queue<NumNode> lList = mergeSort(nums, left, mid);
        Queue<NumNode> rList = mergeSort(nums, mid + 1, right);

        Queue<NumNode> res = new ArrayDeque<>();
        int count = 0;
        while (lList.size() > 0 && rList.size() > 0) {
            if (lList.peek().num > rList.peek().num) {
                count++;
                res.add(rList.poll());
            } else {
                NumNode tmp = lList.poll();
                tmp.count += count;
                res.add(tmp);
            }
        }
        while (rList.size() > 0) {
            res.add(rList.poll());
        }

        while (lList.size() > 0) {
            NumNode tmp = lList.poll();
            tmp.count += count;
            res.add(tmp);
        }

        return res;
    }

    class BinaryIndexedTree {
        int[] bit;

        BinaryIndexedTree(int n) {
            bit = new int[n + 1];
        }

        int lowbit(int i) {
            return i & (-i);
        }

        void update(int i) {
            while (i < bit.length) {
                bit[i] += 1;
                i += lowbit(i);
            }
        }

        int getSum(int i) {
            int count = 0;
            while (i >= 1) {
                count += bit[i];
                i -= lowbit(i);
            }
            return count;
        }
    }

    public List<Integer> countSmaller2(int[] nums) {
        int n = nums.length;
        BinaryIndexedTree bit = new BinaryIndexedTree(20000+10);
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            res.add(bit.getSum(nums[i] + 10001));
            bit.update(nums[i] + 10002);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        lc315 test = new lc315();
        test.countSmaller2(new int[]{5, 2, 6, 1});
    }
}
