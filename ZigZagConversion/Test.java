package ZigZagConversion;

/**
 * Created by Alan on 9/20/14.
 */
public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        t.test();

    }

    public void test() {

        String ret = convert("PAYPALISHIRING", 3);
        System.out.print(ret);
    }

    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[nRows];
        for (int k = 0; k < nRows; k++) {
            sb[k] = new StringBuilder();
        }

        int i = 0;

        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) {
                sb[idx].append(c[i++]);
            }
            for (int idx = nRows - 2; idx >= 1 && i < len; idx--) {
                sb[idx].append(c[i++]);
            }

        }

        for (int j = 1; j < nRows; j++) {
            sb[0].append(sb[j]);
        }
        return sb[0].toString();


    }

}
