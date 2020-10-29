/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/24
 */
public class lc557 {
    public String reverseWords(String s) {
        if (s.equals("")) return "";
        StringBuffer sb = new StringBuffer();
        String[] str = s.split(" ");
        for (String tmp : str) {
            sb.append(" ").append(new StringBuffer(tmp).reverse());
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }
}
