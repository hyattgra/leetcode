package ReadNCharactersGivenRead4;

/**
 * Created by gzhou on 9/24/15.
 */
public class Solution {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {

        boolean eof = false;
        int totalChars = 0;
        char[] tmpBuffer = new char[4];

        while (totalChars < n && !eof) {
            int currentRead = read4(tmpBuffer);

            eof = currentRead != 4;
            int length = Math.min(n - totalChars, currentRead);
            for (int i = 0; i < length; i++) {
                //totalChars+i
                buf[totalChars + i] = tmpBuffer[i];
            }
            totalChars += length;
        }
        return totalChars;
    }
}
