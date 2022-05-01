package WeeklyContest281;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/19/22
 */
public class lc1 {
    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; ++i) {
            int sum = 0;
            int tmp = i;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if (sum % 2 == 0) count++;
        }
        return count;
    }
}
