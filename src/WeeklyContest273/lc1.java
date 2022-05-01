package WeeklyContest273;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/25/21
 */
public class lc1 {
    public boolean isSameAfterReversals(int num) {
        if (num == 0) return true;

        if (num % 10 == 0) return false;
        return true;
    }


}
