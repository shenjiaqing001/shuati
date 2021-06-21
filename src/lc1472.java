import java.util.LinkedList;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/18
 */
public class lc1472 {
    class BrowserHistory {

        LinkedList<String> q = new LinkedList<>();
        int index = 0;

        public BrowserHistory(String homepage) {
            q.add(homepage);
            index = 0;
        }

        public void visit(String url) {
            while (q.size() > index + 1) {
                q.removeLast();
            }
            q.add(url);
            index++;
        }

        public String back(int steps) {
            if (index < steps) {
                index = 0;
                return q.get(0);
            } else {
                index -= steps;
                return q.get(index);
            }
        }

        public String forward(int steps) {
            index += steps;
            index = Math.min(index, q.size() - 1);
            return q.get(index);
        }
    }
}
