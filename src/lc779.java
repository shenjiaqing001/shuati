/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/6/22
 */
public class lc779 {
    // 0 -> 01    1 -> 10

    //1: 0
    //2: 01
    //3: 0110
    //4: 01101001
    //5: 0110100110010110

    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        if (k > (1 << (n - 2))) return 1 - kthGrammar(n - 1, k - (1 << (n - 2)));
        else return kthGrammar(n - 1, k);
    }
}
