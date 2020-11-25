/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/26
 */
public class lc1015 {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) return -1;
        int num = 1;
        for (int i = 1; i <= K; ++i) {

            if (num % K == 0) return i;
            num = (num * 10 + 1) %  K;
        }

        return -1;
    }
}
