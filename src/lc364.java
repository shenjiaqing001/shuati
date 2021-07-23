import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/8
 */
public class lc364 {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // Constructor initializes an empty nested list.
        //public NestedInteger();

        // Constructor initializes a single integer.
        //public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }


    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = depth(nestedList);
        return sum(nestedList, maxDepth);
    }


    public int depth(List<NestedInteger> nestedList) {
        int max = 0;
        for (NestedInteger nestedInteger : nestedList) {
            if (!nestedInteger.isInteger()) {
                max = Math.max(max, depth(nestedInteger.getList()));
            }
        }
        return max + 1;
    }

    public int sum(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                res += depth * nestedInteger.getInteger();
            } else {
                res += sum(nestedInteger.getList(), depth - 1);
            }
        }

        return res;
    }
}
