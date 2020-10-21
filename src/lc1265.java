import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/21
 */
public class lc1265 {

    interface ImmutableListNode {
        public void printValue(); // print the value of this node.

        public ImmutableListNode getNext(); // return the next node.
    }

    public void printLinkedListInReverse(ImmutableListNode head) {
        List<ImmutableListNode> list = new LinkedList<>();
        while (head != null) {
            list.add(head);
            head = head.getNext();
        }
        for (int i = list.size() - 1; i >= 0; --i) list.get(i).printValue();
    }
}
