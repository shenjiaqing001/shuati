package WeeklyContest296;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 6/4/22
 */
public class lc4 {

    class TextEditor {
        class node {
            char c;
            node left;
            node right;

            node(char c) {
                this.c = c;
            }
        }

        node now = new node('_');

        public TextEditor() {
            now.left = new node('<');
            now.right = new node('>');
        }

        public void addText(String text) {
            for (char c : text.toCharArray()) {
                node n = new node(c);
                n.left = now.left;
                n.right = now;
                now.left.right = n;
                now.left = n;
            }
        }

        public int deleteText(int k) {
            int count = 0;
            while (true) {
                if (now.left.c == '<') break;
                if (k == 0) break;
                node tmp = now.left.left;
                tmp.right = now;
                now.left = tmp;
                k--;
                count++;
            }
            return count;
        }

        public String cursorLeft(int k) {
            while (k > 0) {
                if (now.left.c == '<') break;
                now.c = now.left.c;
                now.left.c = '_';
                now = now.left;
                k--;
            }
            StringBuilder sb = new StringBuilder();
            int count = 10;
            node tmp = now;
            while (true) {
                if (count == 0) break;
                if (tmp.left.c == '<') break;
                sb.insert(0, tmp.left.c);
                tmp = tmp.left;
                count--;
            }
            return sb.toString();
        }

        public String cursorRight(int k) {
            while (k > 0) {
                if (now.right.c == '>') break;
                now.c = now.right.c;
                now.right.c = '_';
                now = now.right;
                k--;
            }
            StringBuilder sb = new StringBuilder();
            int count = 10;
            node tmp = now;
            while (true) {
                if (count == 0) break;
                if (tmp.left.c == '<') break;
                sb.insert(0, tmp.left.c);
                tmp = tmp.left;
                count--;
            }
            return sb.toString();
        }
    }
}
