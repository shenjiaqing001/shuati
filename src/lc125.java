/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/4/20
 */
public class lc125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int front = 0;
        int back = s.length() - 1;

        boolean flag = true;
        while (front <= back) {
            if (!Character.isLetterOrDigit(s.charAt(front)))
                front++;
            else if (!Character.isLetterOrDigit(s.charAt(back)))
                back--;
            else {
                if (s.charAt(front) == s.charAt(back)) {
                    front++;
                    back--;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        lc125 t = new lc125();

        System.out.println(t.isPalindrome("race a car"));
    }
}
