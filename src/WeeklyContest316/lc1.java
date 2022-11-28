package WeeklyContest316;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/22/22
 */
public class lc1 {
    public boolean haveConflict(String[] event1, String[] event2) {
        String[] start1 = event1[0].split(":");
        String[] end1 = event1[1].split(":");
        String[] start2 = event2[0].split(":");
        String[] end2 = event2[1].split(":");
        int s1 = Integer.parseInt(start1[0]) * 60 + Integer.parseInt(start1[1]);
        int e1 = Integer.parseInt(end1[0]) * 60 + Integer.parseInt(end1[1]);
        int s2 = Integer.parseInt(start2[0]) * 60 + Integer.parseInt(start2[1]);
        int e2 = Integer.parseInt(end2[0]) * 60 + Integer.parseInt(end2[1]);
        if (s1 <= e2 && e1 >= e2) return true;
        if (s2 <= e1 && e2 >= e1) return true;
        return false;
    }
}
