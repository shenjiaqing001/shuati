package BiWeeklyContest56;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/10
 */
public class lc1927 {
    public boolean sumGame(String num) {
        int sum = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < num.length(); ++i) {
            if (i < num.length() / 2) {
                if (num.charAt(i) == '?') left++;
                else sum += num.charAt(i) - '0';
            } else {
                if (num.charAt(i) == '?') right++;
                else sum -= num.charAt(i) - '0';
            }
        }

        if ((left + right) % 2 == 1) return true;

        if (sum != (right - left) / 2 * 9) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println((-9) % 9);
    }
}
