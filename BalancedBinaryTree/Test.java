package BalancedBinaryTree;

/**
 * Created by Alan on 9/7/14.
 */
public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(1);
        TreeNode t7 = new TreeNode(1);
        TreeNode t8 = new TreeNode(1);
        TreeNode t9 = new TreeNode(1);
        TreeNode t10 = new TreeNode(1);
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(1);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t3.left = t7;
        t3.right = t8;
        t4.left = t9;
        t4.right = t10;
        t2.left = t5;
//        t2.right = t6;
        t5.left = t11;
        t5.right = t12;

        BBT bbt = new BBT();
        System.out.print(bbt.isBalanced(root));

    }
}
