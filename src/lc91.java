/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/24/20
 */
public class lc91 {
    public int numDecodings(String s) {
        if(s.startsWith("0")) return 0;
        int[] dp = new int[s.length() + 1];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 1; i < s.length(); ++i) {
            char a = s.charAt(i - 1);
            char b = s.charAt(i);
            if(a == b && a == '0') return 0;
            if ((a == '1' || (a == '2' && b <= '6')) && b != '0')
                dp[i + 1] = dp[i] + dp[i-1];
            else{
                if(b == '0'){
                    if(a == '1' || a == '2')
                        dp[i+1] = dp[i-1];
                    else
                        return 0;
                }
                else
                    dp[i + 1] = dp[i];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        lc91 t = new lc91();
        System.out.println(t.numDecodings("205"));
    }
}
