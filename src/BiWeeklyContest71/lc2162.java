package BiWeeklyContest71;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/1/22
 */
public class lc2162 {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        // how many minutes can we have?
        int res = Integer.MAX_VALUE;
        int minMin = (targetSeconds - 99) >= 0 ? (targetSeconds - 99) / 60 : 0;
        if ((targetSeconds - 99) % 60 > 0) minMin++;
        int maxMin = (targetSeconds / 60) > 99 ? 99 : (targetSeconds / 60);
        for (int i = minMin; i <= maxMin; i++) {
            int[] arr = new int[4];
            int second = targetSeconds - 60 * i;
            arr[0] = i / 10;
            arr[1] = i % 10;
            arr[2] = second / 10;
            arr[3] = second % 10;
            // System.out.println(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]);
            int tmp = count(startAt, moveCost, pushCost, arr);
            // System.out.println(tmp);
            if (tmp < res) {
                res = tmp;
            }
        }
        return res;
    }

    public int count(int startAt, int moveCost, int pushCost, int[] arr) {
        int i = 0;
        int res = 0;
        // Skip all the leading zeros
        while (i < 4 && arr[i] == 0) i++;
        int pre = startAt;
        while (i < 4) {
            res = (pre == arr[i]) ? (res + pushCost) : (res + pushCost + moveCost);
            pre = arr[i];
            i++;
        }
        return res;
    }
}
