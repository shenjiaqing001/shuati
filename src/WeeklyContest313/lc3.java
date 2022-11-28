package WeeklyContest313;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/1/22
 */
public class lc3 {
    public int minimizeXor(int num1, int num2) {
        char[] c1 = Integer.toBinaryString(num1).toCharArray();
        int count2 = Integer.bitCount(num2);
        int count1 = Integer.bitCount(num1);
        if (count1 == count2) return num1;
        if (count1 < count2) {
            count2 -= count1;
            int i = 0;
            while (count2 > 0) {
                if ((num1 & (1 << i)) == 0) {
                    num1 += (1 << i);
                    count2--;
                }
                i++;
            }
            return num1;
        } else {
            int res = 0;
            int bit = c1.length - 1;
            for (int i = 0; i < c1.length; ++i) {
                if (c1[i] == '1') {
                    count2--;
                    res += (1 << bit);
                }
                bit--;
                if (count2 == 0) break;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        lc3 test = new lc3();
        test.minimizeXor(25, 72);
    }
}
