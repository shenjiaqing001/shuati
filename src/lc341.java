import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/4/20
 */
public class lc341 {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        LinkedList<Integer> list = new LinkedList<>();


        public NestedIterator(List<NestedInteger> nestedList) {
            dfs(nestedList);
        }

        public void dfs(List<NestedInteger> nestedList) {
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    list.add(ni.getInteger());
                } else {
                    dfs(ni.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return list.remove(0);
        }

        @Override
        public boolean hasNext() {
            return list.size() > 0;
        }
    }
}
