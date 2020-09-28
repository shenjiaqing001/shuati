package WeeklyContest208;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/27
 */
public class lc5524 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if (boardingCost * 4 <= runningCost) return -1;
        int maxProfit = 0;
        int nowProfit = 0;
        int maxRound = -1;
        int remain = 0;
        for (int i = 0; i < customers.length; ++i) {
            remain += customers[i];
            int take = 0;
            if (remain <= 4) {
                take = remain;
                remain = 0;
            } else {
                remain -= 4;
                take = 4;
            }
            nowProfit += boardingCost * take - runningCost;
            if (nowProfit >= 0) {
                if (nowProfit > maxProfit) {
                    maxProfit = nowProfit;
                    maxRound = i;
                }
            }
        }
        int nowRound = customers.length + 1;
        if (remain > 0) {
            int rounds = remain / 4;
            nowProfit += boardingCost * rounds * 4 - runningCost;
            nowRound += rounds;
            maxRound = nowRound;

            int last = remain % 4;
            if (last * boardingCost > runningCost)
                maxRound++;
        }


        return maxRound;
    }
}
