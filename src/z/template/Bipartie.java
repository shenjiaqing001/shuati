package z.template;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/23/22
 */
public class Bipartie {

    class Hungarian {
        int left, right;
        boolean[][] map;
        int[] p; //right //记录当前右侧元素所对应的左侧元素
        boolean[] vis; // right //记录右侧元素是否已被访问过

        Hungarian(int left, int right) {
            this.left = left;
            this.right = right;
            map = new boolean[left][right];
            p = new int[right];
        }

        void addEdge(int i, int j) {
            map[i][j] = true;
        }

        boolean match(int i) {
            for (int j = 0; j < right; ++j)
                if (map[i][j] && !vis[j]) //有边且未访问
                {
                    vis[j] = true;                 //记录状态为访问过
                    if (p[j] == 0 || match(p[j])) //如果暂无匹配，或者原来匹配的左侧元素可以找到新的匹配
                    {
                        p[j] = i;    //当前左侧元素成为当前右侧元素的新匹配
                        return true; //返回匹配成功
                    }
                }
            return false; //循环结束，仍未找到匹配，返回匹配失败
        }

        int solve() {
            int res = 0;
            for (int i = 0; i < left; ++i) {
                vis = new boolean[right];
                if (match(i))
                    res++;
            }
            return res;
        }
    }


}
