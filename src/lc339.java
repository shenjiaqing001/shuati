import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/26
 */
public class lc339 {
    public int depthSum(List<NestedInteger> nestedList) {
        int[] res = dfs(nestedList);
        return res[0];
    }

    public int[] dfs(List<NestedInteger> nestedList) {
        if (nestedList.size() == 0) return new int[]{0, 0};
        int res = 0;
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger();
                res += ni.getInteger();
            } else {
                int[] nextLevel = dfs(ni.getList());
                res += nextLevel[0] + nextLevel[1];
                sum += nextLevel[1];
            }
        }
        return new int[]{res, sum};
    }
}
