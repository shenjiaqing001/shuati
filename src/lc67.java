/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/21/20
 */
public class lc67 {
    public String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        String longStr = "";
        String shortStr = "";
        if (a.length() > b.length()) {
            longStr = a;
            shortStr = b;
        } else {
            longStr = b;
            shortStr = a;
        }

        char[] longChar = longStr.toCharArray();
        char[] shortChar = shortStr.toCharArray();
        int longLength = longChar.length;
        int shortLength = shortChar.length;

        int i = 1;
        boolean plus = false;
        while (i <= shortChar.length) {
            if (longChar[longLength - i] == '0' &&
                    shortChar[shortLength - i] == longChar[longLength - i]) {
                if (plus == true) {
                    plus = false;
                    longChar[longLength - i] = '1';
                }
            } else if (longChar[longLength - i] != shortChar[shortLength - i]) {
                if (plus == true) {
                    longChar[longLength - i] = '0';
                } else {
                    longChar[longLength - i] = '1';
                }
            } else {
                if (plus == false) {
                    longChar[longLength - i] = '0';
                    plus = true;
                }
            }
            i++;
        }



        if (plus == true) {
            if (longLength > shortLength) {
                while (i <= longLength) {
                    if (longChar[longLength - i] == '0') {
                        longChar[longLength - i] = '1';
                        return new String(longChar);
                    } else
                        longChar[longLength - i] = '0';
                    i++;
                }
                String str = new String(longChar);
                return "1" + str;
            } else{
                String str = new String(longChar);
                return "1" + str;
            }
        } else
            return new String(longChar);
    }

    public static void main(String[] args) {
        lc67 t = new lc67();
        System.out.println(t.addBinary("111","100"));

    }
}
