import z.template.SegmentTree_NodeBase;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/12/22
 */
public class lc1157 {

    class SegmentTree {
        int leftBound;
        int rightBound;
        SegmentTree leftChild;
        SegmentTree rightChild;
        int candidate = 0;
        int count = 0;

        SegmentTree(int[] nums, int leftBound, int rightBound) {
            this.leftBound = leftBound;
            this.rightBound = rightBound;
            if (leftBound == rightBound) {
                this.candidate = nums[leftBound];
                this.count = 1;
            } else {
                int mid = leftBound + (rightBound - leftBound) / 2;
                this.leftChild = new SegmentTree(nums, leftBound, mid);
                this.rightChild = new SegmentTree(nums, mid + 1, rightBound);
                if (this.leftChild.candidate == this.rightChild.candidate) {
                    this.candidate = this.leftChild.candidate;
                    this.count = this.leftChild.count + this.rightChild.count;
                } else {
                    if (this.leftChild.count > this.rightChild.count) {
                        this.candidate = this.leftChild.candidate;
                        this.count = this.leftChild.count - this.rightChild.count;
                    } else {
                        this.candidate = this.rightChild.candidate;
                        this.count = this.rightChild.count - this.leftChild.count;
                    }
                }
            }
        }

        int[] vote(int left, int right) {
            if (left <= leftBound && rightBound <= right) {
                return new int[]{this.candidate, this.count};
            } else if (leftBound > right || rightBound < left) {
                return new int[]{0, 0};
            } else {
                int[] lRes = leftChild.vote(left, right);
                int[] rRes = rightChild.vote(left, right);
                if (lRes[0] == rRes[0]) return new int[]{lRes[0], lRes[1] + rRes[1]};
                else {
                    if (lRes[1] > rRes[1]) return new int[]{lRes[0], lRes[1] - rRes[1]};
                    else return new int[]{rRes[0], rRes[1] - lRes[1]};
                }
            }
        }
    }

    class MajorityChecker {

        SegmentTree root;
        Map<Integer, List<Integer>> map = new HashMap<>();

        public MajorityChecker(int[] arr) {
            root = new SegmentTree(arr, 0, arr.length - 1);
            for (int i = 0; i < arr.length; ++i) {
                map.putIfAbsent(arr[i], new ArrayList<>());
                map.get(arr[i]).add(i);
            }
            // System.out.println(map);

        }

        public int binarySearchLow(List<Integer> list, int number) {
            int lo = 0;
            int hi = list.size() - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (list.get(mid) < number) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }

        // 1 3 5 7,   6->2,  7 8-> 3
        public int binarySearchHigh(List<Integer> list, int number) {
            int lo = 0;
            int hi = list.size() - 1;
            while (lo < hi) {
                int mid = hi - (hi - lo) / 2;
                if (list.get(mid) <= number) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            return lo;
        }

        public int count(int num, int left, int right) {
            if (!map.containsKey(num)) return 0;
            int l = binarySearchLow(map.get(num), left);
            int r = binarySearchHigh(map.get(num), right);
            // System.out.println(num + " " + l + " " + r);

            return r - l + 1;
        }

        public int query(int left, int right, int threshold) {
            int[] res = root.vote(left, right);
            if (res[1] == 0) return -1;
            int candidate = res[0];
            // System.out.println(left + " " + right);
            if (count(candidate, left, right) < threshold) return -1;
            return candidate;
        }
    }

}
