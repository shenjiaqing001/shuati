/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/14/22
 */
public class lc2031 {

    class BinaryIndexedTree {
        long[] bit;

        BinaryIndexedTree(int n) {
            bit = new long[n + 1];
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

        long getSum(int i) {
            long count = 0;
            while (i >= 1) {
                count += bit[i];
                i -= lowbit(i);
            }
            return count;
        }
    }

    public int subarraysWithMoreZerosThanOnes(int[] nums) {
        long res = 0;
        BinaryIndexedTree bit = new BinaryIndexedTree(200005);
        bit.update(100001);
        // [ - 100000, 100000] + 100001
        // [ 1, 200001]
        int sum = 0;
        for (int num : nums) {
            sum += num == 0 ? -1 : 1;
            res += bit.getSum(sum + 100000);
            bit.update(sum + 100001);
        }
        return (int) (res % 1_000_000_007);
    }
}
