package WeeklyContest261;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/2
 */
public class lc2029 {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }
        if (count[1] == 0 || count[2] == 0) return false;
        boolean flag = false;
        if (count[1] == 0 || count[2] == 0) {
            if (Math.max(count[1], count[2]) < 3) return false;
            if (count[0] % 2 == 0) return true;
            else return false;
        }

        // go 1 or go 2
        // go 1
        // 1 (1 2 1 2 1 2) 1 1 1 1 1 1
        int steps = 2 * Math.min(count[1] - 1, count[2]) + count[0];
        if (count[1] - 1 < count[2]) {
            if (steps % 2 == 0) flag = true;
        }
        if (count[1] - 1 > count[2]) {
            if (count[1] - 1 == count[2] + 1) {
            } else {
                if (steps % 2 == 0) {
                } else flag = true;
            }
        }

        steps = 2 * Math.min(count[2] - 1, count[1]) + count[0];
        if (count[2] - 1 < count[1]) {
            if (steps % 2 == 0) flag = true;
        }
        if (count[2] - 1 > count[1]) {
            if (count[2] - 1 == count[1] + 1) {
            } else {
                if (steps % 2 == 0) {
                } else flag = true;
            }
        }
        return flag;
    }
}
