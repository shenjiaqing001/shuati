/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/28/20
 */
public class lc1360 {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysfrom1900(date1) - daysfrom1900(date2));
    }


    public int daysfrom1900(String date) {
        String[] str = date.split("-");
        int year = Integer.valueOf(str[0]);
        int month = Integer.valueOf(str[1]);
        int day = Integer.valueOf(str[2]);

        int res = 0;
        res += 365 * (year - 1900 - 1);
        res += (year - 1900 - 1) / 4;

        if (month >= 1) res += 0;
        if (month >= 2) res += 31;
        if (month >= 3) res += 28;
        if (month >= 4) res += 31;
        if (month >= 5) res += 30;
        if (month >= 6) res += 31;
        if (month >= 7) res += 30;
        if (month >= 8) res += 31;
        if (month >= 9) res += 31;
        if (month >= 10) res += 30;
        if (month >= 11) res += 31;
        if (month >= 12) res += 30;
        res += day;

        if (month > 2) {
            if ((year % 100 != 0 && year % 4 == 0) || (year % 100 == 0 && year % 400 == 0))
                res++;
        }
        return res;
    }
}
