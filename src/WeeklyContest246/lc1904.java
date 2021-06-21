package WeeklyContest246;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/20
 */
public class lc1904 {
    public int numberOfRounds(String startTime, String finishTime) {
        int startHour = Integer.parseInt(startTime.split(":")[0]);

        int startMin = Integer.valueOf(startTime.split(":")[1]);
        int endHour = Integer.valueOf(finishTime.split(":")[0]);
        int endMin = Integer.valueOf(finishTime.split(":")[1]);

        if (endHour < startHour || endHour == startHour && endMin < startMin) {
            endHour += 24;
        }
        int startCount = (int) Math.ceil(startMin / 15.0);
        int finishCount = (int) Math.floor(endMin / 15.0);
        return Math.max(0, endHour * 4 + finishCount - (startHour * 4 + startCount));
    }
}
