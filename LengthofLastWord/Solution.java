package LengthofLastWord;

/**
 * Created by Alan on 6/21/15.
 */
public class Solution {

    public static void main(String[] args) {

    }


    public int lengthOfLastWord(String s) {
        // copy and paste from common/shared solution
        if(s == null)
            return 0;
        else if(s.isEmpty())
            return 0;
        else
        {
            int count = 0;
            s = s.trim();
            for(int i = s.length() - 1; i >= 0; i--)
            {
                if(s.charAt(i) != ' ')
                    count++;
                else
                    break;
            }
            return count;
        }
    }
}
