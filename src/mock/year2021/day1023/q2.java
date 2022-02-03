package mock.year2021.day1023;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/23
 */
public class q2 {
    // 有一批人，分属两个敌对阵营，已知若干个配对(a,b,k)，表示这两个人a和b要么是敌k==1，要么是友k==0。
    // 问通过这些信息，能否将所有人确定是分属于哪个阵营。

    // a b k, k==0 合并， k==1 敌对 n=10^5
    public boolean solve(int[][] conditions, int n) {
        // a和b是0， 链接 a b。
        // a和b是1，链接-a b和a -b。

        return true;
    }

    class UnionFind {
        int[] p;


    }


}
