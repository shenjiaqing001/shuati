import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        List<NumNode> sortedNum = mergeSort(numbers, 0, n - 1);
        List<Integer> res = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) res.add(0);

        for (NumNode num : sortedNum) {
            res.set(num.index, num.count);
        }
        return res;
    }

    public List<NumNode> mergeSort(NumNode[] nums, int left, int right) {
        if (left == right) {
            List<NumNode> list = new LinkedList<>();
            list.add(nums[left]);
            return list;
        }

        int mid = (left + right) / 2;
        List<NumNode> lList = mergeSort(nums, left, mid);
        List<NumNode> rList = mergeSort(nums, mid + 1, right);

        List<NumNode> res = new LinkedList<>();
        int count = 0;
        while (lList.size() > 0 && rList.size() > 0) {
            if (lList.get(0).num > rList.get(0).num) {
                count++;
                res.add(rList.remove(0));
            } else {
                NumNode tmp = lList.remove(0);
                tmp.count += count;
                res.add(tmp);
            }
        }
        while (rList.size() > 0) {
            res.add(rList.remove(0));
        }

        while (lList.size() > 0) {
            NumNode tmp = lList.remove(0);
            tmp.count += count;
            res.add(tmp);
        }

        return res;
    }
}
