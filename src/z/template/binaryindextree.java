package z.template;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/16/22
 */
public class binaryindextree {

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


}
