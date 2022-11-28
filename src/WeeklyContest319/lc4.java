package WeeklyContest319;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/12/22
 */
public class lc4 {
    public int maxPalindromes(String s, int k) {
        char[] c = s.toCharArray();
        int n = c.length;
        boolean[][] flag = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) flag[i][j] = true;
                else if (i == j - 1 && c[i] == c[j]) flag[i][j] = true;
                else if (c[i] == c[j] && flag[i + 1][j - 1]) flag[i][j] = true;
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i < n; i++) {
            for (int j = i + k - 1; j < n; j++) {
                if (flag[i][j]) {
                    pq.add(new int[]{i, j});
                    break;
                }
            }
        }
        int res= 0 ;
        int time = -1;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if(now[0] < time + 1){
                continue;
            }
            time = now[1];
            res ++;
        }
        return res;
    }

    public static void main(String[] args) {
        lc4 test = new lc4();


//        System.out.println(test.maxPalindromes("cwwbbbwuhvdb", 5));
        System.out.println(test.maxPalindromes(
                "fojnrcnerybjjghhaykxykixkojokxikyxkyahhgjjbyrencrnjofzyzeftizdmiynofcwlwcfonyimdzitfezyzqywfmxqcqhwbsmtbfberkuiukrebfbtmsbwhqcqxmfwywhoppuqnxqesiqedlpujohqpnvzvljyjlvzvnpqhojupldeqiseqxnquppohwrniimkadiwfkesjhhjsekfwidakmiingbsasadxeqxacdhxqkupyprzrcjaqtqajcrzrpypukqxhdcaxqexdasawuumyhklbhodwcmydtkfezcuesnjjnseuczefktdymcwdohblkhymuuwsdquovgnrckcpubplmueyaernzdmcmdznreayeumlpbupckcrngvouqdpsktcrqynclzrgjtplokkfihhymmgsgmmyhhifkkolptjgrzlcnyqrctksvnchfxupvsyljxzadjhohjdazxjlysvpuxfhcnwatcqotbwunztyzryjmmjyrzytznuwbtoqctawdykmoeebpeqmgbdexfwxcelvwxyrryxwvlecxwfxedbgmqepbeeblxevnmdcnrwfsaqqasfwrncdmnvexlbwaurakgpqtjpymaibpebeqlelqebepbiamypjtqpgkaruawceerqumnqbdwnbtlcootttibpdjpckqfcrmajjamrcfqkcpjdpbitttoocltbnwdbqnmuqreeyvfwueuewqyxyiaquqaiyxyqweueuwfvksskyuswbeqpihumbedwoxhufidbdifuhxowdebmuhipqebwsuykssktegrvozxyiofngmqbkiqfagxsfyllzgumemugzllyfsxgafqikbqmgnfoiyxzosthtycrjroeipdirvtrlzukccpqpcckuzlrtvridpieorjrcythtsdalhtjojbryxaoxppdxpwwbbklywnamrxtjpwtqfxyegmywwvwwymgeyxfqtwpjtxrmanwylkbbwwpxdppxoabymjvqlwqnmfzerregerrezfmnqwlqvjmybgogqdfigragpafjcyfzkqxzladjqufrrfuqjdalzxqkzfycjfapgargifdqgogarlptpazebeudrmymnvimxkssysytgujznjancjrjcnajnzjugtysysskxmivnmymrduebezaptphpmeblrzbxzzvxpwwxhiykxmbdcrwvcketekcvwrcdbmxkyihxwwpxvzzxbzrlbemhvcaswtkxbsdpalkxkddqokerskptsustbcbtsustpksrekoqddkxklapdsbxktwsacvhmjigkwrygxusxbbguwzngqoqbknehaopuvvupoahenkbqoqgnzwugbbxsuxgyrwkgikjureyadreoxreinabllbanierxoerdayerujkmjuxcoydsukgdctdcnrsqxcrzvmxmvzrcxqsrncdtcdgkusdyocxuuznoynsubjvoibuxfddwfogofwddfxubiovjbusnyonzuuubdw",
                24));
    }
}
