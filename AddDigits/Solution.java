package AddDigits;

/**
 * Created by Alan on 8/22/15.
 */
public class Solution {
    public int addDigits(int num) {

        return num == 0 ? 0 : (num % 9 == 0 ? 9 : num % 9);
    }
}
