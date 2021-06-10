package BiWeeklyContest49;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/3
 */
public class lc1 {
    public boolean squareIsWhite(String coordinates) {
        int n1 = coordinates.charAt(0) - 'a';
        int n2 = coordinates.charAt(1) - '1';
        return (n1 + n2) % 2 == 0 ? false : true;
    }
}
