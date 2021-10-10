package WeeklyContest261;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/2
 */
public class lc2030 {
    public static void main(String[] args) {
        lc2030 test = new lc2030();
        System.out.println(test.smallestSubsequence("aaabbbcccddd", 3, 'b', 2));
    }

    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new ArrayDeque<>();
        int count = 0;
        for (char c : s.toCharArray()) if (c == letter) count++;
        int canPopLetter = count - repetition;
        int canPopTotal = s.length() - k;
        for (char c : s.toCharArray()) {
            while (!deque.isEmpty() && deque.peekLast() > c) {
                if (deque.peekLast() == letter) {
                    if (canPopLetter > 0 && canPopTotal > 0) {
                        canPopTotal--;
                        canPopLetter--;
                        deque.pollLast();
                    } else break;
                } else if (canPopTotal > 0) {
                    canPopTotal--;
                    deque.pollLast();
                } else break;
            }
            deque.addLast(c);
        }
        int notLetter = k - repetition;
        while (!deque.isEmpty() && sb.length() < k) {
            if (deque.peekFirst() != letter) {
                if (notLetter > 0) {
                    sb.append(deque.pollFirst());
                    notLetter--;
                } else {
                    deque.pollFirst();
                }
            } else {
                sb.append(deque.pollFirst());
            }
        }
        return sb.toString();
    }
}
