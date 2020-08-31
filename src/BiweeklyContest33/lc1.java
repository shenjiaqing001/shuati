package BiweeklyContest33;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/22/20
 */
public class lc1 {
    public String thousandSeparator(int n) {
        if (n < 1000) return String.valueOf(n);
        String res = "";
        while (n > 0) {
            int now = n % 1000;
            n /= 1000;
            res = String.valueOf(now) + "." + res;
            if(n > 0){
                if (now < 10) res = "00" + res;
                else if (now < 100) res = "0" + res;
            }
        }
        return res.substring(0, res.length() - 1);
    }
}
