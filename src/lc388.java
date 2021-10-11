import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/11
 */
public class lc388 {
    public static void main(String[] args) {
        lc388 test = new lc388();
        System.out.println(
                test.lengthLongestPath("dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext"));

    }

    public int lengthLongestPath(String input) {
        String[] strs = input.split("\n");

        Stack<Character> sb = new Stack<>();
        int stack = 0;
        int max = 0;
        for (String str : strs) {
            // System.out.println("1" + str);
            String[] folders = str.split("\t");
            int k = folders.length;
            while (k <= stack) {
                while (sb.pop() != '\\') ;
                stack--;
            }
            stack = folders.length;
            sb.add('\\');
            for (char c : folders[folders.length - 1].toCharArray()) {
                sb.add(c);
            }

            if (folders[folders.length - 1].contains(".")) {
                max = Math.max(max, sb.size() - 1);
            }
        }
        return max;
    }
}
