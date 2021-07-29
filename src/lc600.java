/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/25
 */
public class lc600 {
    public int findIntegers(int num) {
        int[] fb = new int[32];
        fb[0] = 1;
        fb[1] = 2;
        for (int i = 2; i < 32; ++i) fb[i] = fb[i - 1] + fb[i - 2];
        int res = 0;
        int bit = 31;
        boolean flag = false;
        while (bit > 0) {
            System.out.println(((num >> bit) & 1));
            if (  ((num >> bit) & 1) == 1) {
                res += fb[bit];
                if (flag) return res;
                flag = true;
            } else {
                flag = false;
            }
            bit--;
        }

        return res + 1;
    }
}
