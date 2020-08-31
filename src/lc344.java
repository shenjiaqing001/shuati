/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/17/20
 */
public class lc344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
