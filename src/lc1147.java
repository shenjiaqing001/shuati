/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/22
 */
public class lc1147 {
    public int longestDecomposition(String text) {
        char[] c = text.toCharArray();
        int res = 1;
        int left = 0;
        int right = text.length() - 1;
        long base = 26;
        long pow_base = 1;
        long leftStr = 0;
        long rightStr = 0;
        while (left <= right) {
            leftStr = 26 * leftStr + c[left] - 'a';
            rightStr = rightStr + pow_base * (c[right] - 'a');
            pow_base *= base;
            if (leftStr == rightStr) {
                if (left == right) res += 1;
                else res += 2;
                leftStr = 0;
                rightStr = 0;
                pow_base = 1;
            }
            left++;
            right--;
        }
        if (leftStr != rightStr) res++;
        return res;
    }
}
