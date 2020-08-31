import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/23/20
 */
public class lc84 {
    public int largestRectangleArea(int[] heights) {
        List<Integer> stack = new ArrayList<>();
        int[] nHeights = new int[heights.length + 1];
        System.arraycopy(heights, 0, nHeights, 0, heights.length);
        nHeights[nHeights.length - 1] = 0;
        int max = 0;


        for (int i = 0; i < nHeights.length; ++i) {
            if (stack.isEmpty() ||
                    nHeights[i] >= nHeights[stack.get(stack.size() - 1)])
                stack.add(i);
            else {
                while (!stack.isEmpty() &&
                        nHeights[i] < nHeights[stack.get(stack.size() - 1)]) {
                    int index = stack.remove(stack.size() - 1);
                    if (stack.isEmpty())
                        max = Math.max(max, i * nHeights[index]);
                    else
                        max = Math.max(max, (i - stack.get(stack.size()-1)-1) * nHeights[index]);
                }
                stack.add(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        lc84 t = new lc84();
        int[] height = new int[]{2,1,5,6,2,3};
        System.out.println(t.largestRectangleArea(height));

    }
}
