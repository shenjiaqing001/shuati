/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/3/9
 */
public class lc246 {
    public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length() - 1;
        while (left < right) {
            char l = num.charAt(left);
            char r = num.charAt(right);
            if (l == r) {
                if (!(l == '0' || l == '1' || l == '8')) return false;
            } else {
                if (!(l == '6' && r == '9' || l == '9' && r == '6')) return false;
            }
            left++;
            right--;
        }
        if (left == right) {
            char c = num.charAt(left);
            if (!(c == '0' || c == '1' || c == '8')) return false;
        }
        return true;
    }
}
