/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/18/20
 */
public class lc186 {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);

        int left = -1;

        for (int i = 0; i < s.length; ++i) {
            if (s[i] != ' ' && left == -1) {
                left = i;
            } else if(s[i] == ' '){
                reverse(s, left, i - 1);
                left = -1;
            }
        }
        if (left != -1)
            reverse(s, left, s.length - 1);
    }

    public void reverse(char[] s, int left, int right) {
        if (left == -1 || right == -1) return;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
