import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/12
 */
public class lc316 {
    public String removeDuplicateLetters(String s) {
        int[] res = new int[26];
        boolean[] visited = new boolean[26];
        for (char c : s.toCharArray()) res[c - 'a']++;
        Stack<Character> stack = new Stack<>();
        int index;
        for (char c : s.toCharArray()) {
            index = c - 'a';
            res[index]--;
            if (visited[index])
                continue;
            while (!stack.isEmpty() && c < stack.peek() && res[stack.peek() - 'a'] != 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

}
