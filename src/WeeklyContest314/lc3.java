package WeeklyContest314;

import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/8/22
 */
public class lc3 {
    public int findMin(int[] count) {
        for (int i = 0; i < 26; ++i) {
            if (count[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    public String robotWithString(String s) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        for (int i = 0; i < c.length; ++i) {
            count[c[i] - 'a']++;
        }
        int i = 0;
        while (findMin(count) != -1) {
            int num = findMin(count);
            int tmp = count[num];
            while (tmp > 0) {
                if (c[i] - 'a' == num) {
                    tmp--;
                    sb.append(c[i]);
                } else {
                    stack.add(c[i]);
                }
                count[c[i] - 'a']--;
                i++;
            }
            num = findMin(count);
            if (num != -1) {
                while (!stack.isEmpty() && stack.peek() - 'a' <= num) {
                    sb.append(stack.pop());
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        lc3 test = new lc3();
        test.robotWithString("zza");
    }
}
