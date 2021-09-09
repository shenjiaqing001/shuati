package WeeklyContest256;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/28
 */
public class lc1987 {

    // 0 0 1
    // 0 0  sum = 0
    // 0 0  sum = 0
    // 0 1  sum = 1    has zero , return 2

    // 1 0 1
    // 0 1  sum = 1
    // 1 1  sum = 2
    // 1 3  sum = 4   has zero return 5

    // 1 1
    // 0 1  sum = 1
    // 0 2  sum = 2


    public int numberOfUniqueGoodSubsequences(String binary) {
        int mod = 1_000_000_007;
        long count0 = 0;
        long count1 = 0;
        int flag = 0;
        for (char c : binary.toCharArray()) {
            if (c == '0') {
                count0 = count0 + count1;
                count0 %= mod;
                flag = 1;
            } else {
                count1 = count0 + count1 + 1;
                count1 %= mod;
            }
        }
        return (int) ((count0 + count1 + flag) % mod);
    }
}
