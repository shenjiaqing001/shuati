/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/7/20
 */
public class lc134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int last = 0;
        int sumTotal = 0;
        int sumTrip = 0;
        for (int i = 0; i < cost.length; ++i) {
            int tmp = gas[i] - cost[i];
            System.out.println(tmp);
            sumTotal += tmp;

            if (sumTrip >= 0 && tmp >= 0) {
                sumTrip += tmp;
            } else {
                if (sumTrip < 0) {
                    if (tmp > 0) {
                        sumTrip = tmp;
                        last = i;
                    } else {

                    }
                } else {
                    if (sumTrip + tmp >= 0) {
                        sumTrip += tmp;
                    } else {
                        sumTrip = -1;
                    }
                }
            }
            System.out.println(tmp + " " + sumTrip + " " + last);
        }
        if (sumTotal < 0)
            return -1;
        else
            return last;
    }
}
