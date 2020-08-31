package WeeklyContest202;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/16/20
 */
public class lc1551 {
    // 1 3 5 7   --> 1 + 3 = 4
    // 1 3 5   --> 2
    // 1 3 --> 1
    // 1 3 5 7 9 --> 2+4 = 6
    // 1 3 5 7 9 11 --> 1+3+5 = 9
    public int minOperations(int n) {


        int first = n - 1;
        int end = n % 2 == 0 ? 1 : 0;
        int counts = (first - end) / 2 + 1;
        return (first + end) * counts / 2;
    }
}
