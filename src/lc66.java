import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/21/20
 */
public class lc66 {
    public int[] plusOne(int[] digits) {
        int back = digits.length - 1;
        boolean added = false;
        while (back >= 0) {
            if (digits[back] == 9) {
                digits[back] = 0;
                back--;
            } else {
                digits[back] += 1;
                added = true;
                break;
            }
        }
        if (added == true)
            return digits;
        else {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }
    }
}
