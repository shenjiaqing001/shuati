package BiWeeklyContest50;


/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/17
 */
public class lc4 {
    public int makeStringSorted(String s) {
        char[] c = s.toCharArray();
        long res = 0;
        StringBuilder sb = new StringBuilder(c[c.length - 1]);
        for (int i = c.length - 2; i >= 0; --i) {
            if (c[i] <= sb.charAt(0)) {
                sb.insert(0, c[i]);
            } else {

            }
        }

        return 0;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.insert(0, 'a');
        sb.insert(0, 'b');
        sb.insert(0, 'c');
        System.out.println(sb.toString());

    }


    /*

class Solution:
    @lru_cache(None)
    def f(self,i):
        return 1 if i <= 1 else (self.f(i-1)*i) % (10**9+7)

    @lru_cache(None)
    def inv(self, i):
        N = 10**9 + 7
        return pow(i, N-2, N)

    def makeStringSorted(self, s):
        N, n, out = 10**9 + 7, len(s), 0
        cnt = [0]*26
        for i in range(n-1, -1, -1):
            ind = ord(s[i]) - ord("a")
            cnt[ind] += 1
            ans = sum(cnt[:ind]) * self.f(n-i-1)
            for j in range(26):
                ans = ans * self.inv(self.f(cnt[j])) % N
            out += ans
        return out % N
     */
    /*
    dcba
    dabc + 5
    cdba
    cabd + 5
    bdca
    bacd + 5
    adcb
    abcd + 5
    23

    cbaa
    caab + 2
    bcaa
    baac + 2
    acba
    aabc + 4
    10
    cbaa = cba * 2

    cbba
    cbab
    cabb
    bcba
    babc + 5
    acbb
    abbc + 2


     */
}
