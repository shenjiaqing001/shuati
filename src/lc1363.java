import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/9/20
 */
public class lc1363 {
    public String largestMultipleOfThree(int[] digits) {
        int sum = 0;
        int mod1 = 0;
        int mod2 = 0;
        for (int i : digits) {
            sum += i;
            if (i % 3 == 1) mod1++;
            if (i % 3 == 2) mod2++;
        }
        Arrays.sort(digits);
        int n = digits.length - 1;
        if (digits[n] == 0) return "0";
        if (sum < 3) return "";

        StringBuilder sb = new StringBuilder();
        if (sum % 3 == 1) {
            if (mod1 == 0) {
                int tmp = 0;
                for (int i = 0; i <= n; ++i) {
                    if (tmp < 2 && digits[i] % 3 == 2) {
                        tmp++;
                        continue;
                    }
                    sb.append(digits[i]);
                }
            } else {
                int tmp = 0;
                for (int i = 0; i <= n; ++i) {
                    if (tmp < 1 && digits[i] % 3 == 1) {
                        tmp++;
                        continue;
                    }
                    sb.append(digits[i]);
                }
            }
        } else if (sum % 3 == 2) {
            if (mod2 == 0) {
                int tmp = 0;
                for (int i = 0; i <= n; ++i) {
                    if (tmp < 2 && digits[i] % 3 == 1) {
                        tmp++;
                        continue;
                    }
                    sb.append(digits[i]);
                }
            } else {
                int tmp = 0;
                for (int i = 0; i <= n; ++i) {
                    if (tmp < 1 && digits[i] % 3 == 2) {
                        tmp++;
                        continue;
                    }
                    sb.append(digits[i]);
                }
            }
        } else {
            for (int i = 0; i <= n; ++i) {
                sb.append(digits[i]);
            }
        }
        return sb.reverse().toString();
    }
}
