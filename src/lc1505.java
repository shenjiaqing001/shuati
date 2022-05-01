import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/14/22
 */
public class lc1505 {

    class SegmentTree {
        int leftBound;
        int rightBound;
        SegmentTree leftChild;
        SegmentTree rightChild;
        int sum = 0;

        SegmentTree(int leftBound, int rightBound) {
            this.leftBound = leftBound;
            this.rightBound = rightBound;
            if (leftBound == rightBound) {

            } else {
                int mid = leftBound + (rightBound - leftBound) / 2;
                this.leftChild = new SegmentTree(leftBound, mid);
                this.rightChild = new SegmentTree(mid + 1, rightBound);
            }
        }

        int getSum(int left, int right) {
            if (left <= leftBound && rightBound <= right) {
                return this.sum;
            } else if (leftBound > right || rightBound < left) {
                return 0;
            } else {
                return leftChild.getSum(left, right) + rightChild.getSum(left, right);
            }
        }

        void update(int index) {
            if (leftBound == index && rightBound == index) {
                this.sum = 1;
            } else if (index >= leftBound && index <= rightBound) {
                leftChild.update(index);
                rightChild.update(index);
                this.sum = leftChild.sum + rightChild.sum;
            }
        }
    }


    public String minInteger(String num, int k) {
        int n = num.length();
        char[] numbers = num.toCharArray();
        SegmentTree segmentTree = new SegmentTree(0, n - 1);
        Map<Character, Deque<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.putIfAbsent(numbers[i], new ArrayDeque<>());
            map.get(numbers[i]).add(i);
        }
        StringBuilder sb = new StringBuilder();
        boolean[] flag = new boolean[n];
        for (int i = 0; i < n && k > 0; ++i) {
            for (char c = '0'; c <= '9'; ++c) {
                if (map.containsKey(c)) {
                    int first = map.get(c).peekFirst();
                    int index = first - segmentTree.getSum(0, first);
                    if (index <= k) {
                        k -= index;
                        map.get(c).pollFirst();
                        if (map.get(c).isEmpty()) map.remove(c);
                        segmentTree.update(first);
                        sb.append(c);
                        flag[first] = true;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (!flag[i]) {
                sb.append(numbers[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        lc1505 test = new lc1505();
        test.minInteger("4321", 4);
    }
}
