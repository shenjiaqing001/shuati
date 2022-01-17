package z.template;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/18
 */
public class SegmentTree_ArrayBase {
    int[] segmentTree = new int[100000];
    int n = 0;

    void build(int[] nums, int index, int left, int right) {
        if (left == right) {
            segmentTree[index] = nums[left];
            return;
        }
        int mid = (left + right) / 2;

        build(nums, index * 2, left, mid);
        build(nums, index * 2 + 1, mid + 1, right);
        segmentTree[index] = segmentTree[index * 2] + segmentTree[index * 2 + 1];
    }

    void update(int index, int left, int right, int x, int val) {
        if (left == right) {
            segmentTree[index] = val;
            return;
        }

        int mid = (left + right) / 2;
        if (x <= mid) {
            update(index * 2, left, mid, x, val);
        } else {
            update(index * 2 + 1, mid + 1, right, x, val);
        }
        segmentTree[index] = segmentTree[index * 2] + segmentTree[index * 2 + 1];
    }

    int sum(int index, int left, int right, int start, int end) {
        if (left == start && right == end) {
            return segmentTree[index];
        }
        int mid = (left + right) / 2;
        if (end <= mid) {
            return sum(index * 2, left, mid, start, end);
        }
        if (start >= mid + 1) {
            return sum(index * 2 + 1, mid + 1, right, start, end);
        }


        return sum(index * 2, left, mid, start, mid) +
                sum(index * 2 + 1, mid + 1, right, mid + 1, end);
    }

}
