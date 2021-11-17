package WeeklyContest267;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/13
 */
public class lc2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int index = 0;
        while (tickets[k] != 0) {
            if (tickets[index] > 0) {
                tickets[index]--;
                time++;
                index++;
            } else {
                index++;
            }
            if (index == tickets.length) index = 0;
        }
        return time;
    }
}
