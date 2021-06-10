package BiWeeklyContest42;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/1
 */
public class lc1701 {
    public double averageWaitingTime(int[][] customers) {
        double res = 0;

        int now = 0;
        for (int i = 0; i < customers.length; ++i) {
            if (now <= customers[i][0]) now = customers[i][0];
            now += customers[i][1];
            res += now - customers[i][0];
        }

        return res / customers.length;
    }
}
