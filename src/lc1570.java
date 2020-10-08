/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/8
 */
public class lc1570 {
    class SparseVector {
        int[] nums;

        SparseVector(int[] nums) {
            this.nums = nums;
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int res = 0;
            for (int i = 0; i < nums.length; ++i) {
                res += nums[i] * vec.nums[i];
            }
            return res;
        }
    }
}
