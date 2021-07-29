package OnlineAssessment.Akuna;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/2
 */
public class DivisibilityOfStrings {

    public static int findSmallestDivisor(String s, String t) {
        // Write your code here
        System.out.println(s);
        System.out.println(t);
        int tLength = s.length();
        int sLength = t.length();
        char[] tChar = s.toCharArray();
        char[] sChar = t.toCharArray();

        if (tLength % sLength != 0) return -1;

        int times = tLength / sLength;
        System.out.println(times);
        for (int i = 1; i <= times; ++i) {
            int startChar = (i - 1) * sLength;
            for (int j = 0; j < sLength; ++j) {
                if (tChar[j + startChar] != sChar[j]) return -1;
            }
        }

        for (int i = 1; i < sLength; ++i) {
            if (sLength % i != 0) continue;
            int subTimes = sLength / i;
            boolean flag = true;
            for (int j = 0; j < i; ++j) {
                char tmp = sChar[j];
                for (int k = 1; k <= subTimes; ++k) {
                    if (sChar[i * (k - 1) + j] != tmp) flag = false;
                }
            }
            if (flag == true) return i;
        }

        return sLength;
    }

}
