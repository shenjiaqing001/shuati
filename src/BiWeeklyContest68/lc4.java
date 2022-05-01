package BiWeeklyContest68;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/25/21
 */
public class lc4 {

    int count2 = 0;
    int count5 = 0;

    public long divide(int number) {
        while (number != 0 && number % 2 == 0) {
            number /= 2;
            count2++;
        }
        while (number != 0 && number % 5 == 0) {
            number /= 5;
            count5++;
        }

        return number;
    }

    public String abbreviateProduct(int left, int right) {
        long last5 = 1;
        long first10 = 1;
        long number = 1;
        long bar = 1_00000_00000L;
        boolean flag = false;
        for (int i = left; i <= right; ++i) {
            long remain = divide(i);
            if (remain != 0) {
                if (flag) {
                    last5 *= remain;
                    last5 %= 100000;
                    first10 *= remain;
                    while (first10 > bar) first10 /= 10;
                } else {
                    number *= remain;
                    if (number > bar) {
                        flag = true;
                        last5 = number % 100000;
                        first10 = number;
                        while (first10 > bar) first10 /= 10;
                    }
                }
            }
        }
        int zeros = Math.min(count2, count5);
        count2 -= zeros;
        count5 -= zeros;
        while (count2 > 0) {
            if (flag) {
                last5 *= 2;
                last5 %= 100000;
                first10 *= 2;
                while (first10 > bar) first10 /= 10;
            } else {
                number *= 2;
                if (number > bar) {
                    flag = true;
                    last5 = number % 100000;
                    first10 = number;
                    while (first10 > bar) first10 /= 10;
                }
            }
            count2--;
        }
        while (count5 > 0) {
            if (flag) {
                last5 *= 5;
                last5 %= 100000;
                first10 *= 5;
                while (first10 > bar) first10 /= 10;
            } else {
                number *= 5;
                if (number > bar) {
                    flag = true;
                    last5 = number % 100000;
                    first10 = number;
                    while (first10 > bar) first10 /= 10;
                }
            }
            count5--;
        }
        if (!flag) return number + "e" + zeros;
        else {
            while (first10 > 100000L) first10 /= 10;
            StringBuilder sb = new StringBuilder();
            sb.append(first10);
            sb.append("...");
            String s = String.valueOf(last5);
            int need0 = 5 - s.length();
            for (int i = 0; i < need0; ++i) sb.append("0");
            sb.append(last5);
            sb.append("e");
            sb.append(zeros);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
        System.out.println(test.abbreviateProduct(999998, 1000000));
    }
}
