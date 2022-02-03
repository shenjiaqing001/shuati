package mock.day0130;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/30/22
 */
public class canku4 {

    /*
    给你残酷群的成员名单，每个成员有两个属性，才华与美貌。如果群里任意两个人A与B，A的才华与美貌都不及B的话，
    那么A就要被淘汰。问最终群里剩哪些人？要求输出的相对顺序与所给成员的顺序一致。
     */

    //我一般会这个顺序，然后面试官有可能给你调整成比如
    //1. clarification
    //2. main idea
    //3. complexity
    //4. code it up
    //5. test case
    //6. improvement / tradeoff

    public int[][] CankuTaotai(int[][] people) {
        // 才华 美貌
        int n = people.length;
        int[][] p = new int[n][];
        for (int i = 0; i < n; ++i) {
            p[i] = new int[]{people[i][0], people[i][1], i};
        }
        Arrays.sort(p, (o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            else return o2[0] - o1[0];
        });
        List<Integer> list = new ArrayList<>();
        int max = 0;
        int tmp = -1;
        int now = -1;
        for (int i = 0; i < n; ++i) {
            if (p[i][0] != now) {
                max = tmp;
                now = p[i][0];
                if (p[i][1] < max) {

                } else {
                    tmp = p[i][1];
                    list.add(p[i][2]);
                }
            } else {
                if (p[i][1] >= max) {
                    list.add(p[i][2]);
                }
            }
        }
        int[][] res = new int[list.size()][];
        list.sort(((o1, o2) -> (o1 - o2)));
        for (int i = 0; i < res.length; ++i) {
            int index = list.get(i);
            res[i] = people[index];
        }
        return res;
    }

    public static void main(String[] args) {
        canku4 test = new canku4();
        test.CankuTaotai(new int[][]{{1, 3}, {1, 3}, {2, 2}, {4, 5}});
    }

}
