package VerifyPreorderSerializationOfABinaryTree;

/**
 * Created by Alan on 1/31/2016.
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int outAndInDiff = 1;
        for (String node : nodes) {
            outAndInDiff--;
            if (outAndInDiff < 0) {
                return false;
            }
            if (!node.equals("#")) {
                outAndInDiff += 2;
            }
        }
        return outAndInDiff == 0;
    }
}
