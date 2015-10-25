//package BinarySearchTreeIterator;
//
//import java.util.Stack;
//import java.util.TreeSet;
//
//public class BSTIterator {
//
//    private Stack<TreeNode> stack = new Stack<>();
//
//    public BSTIterator(TreeNode root) {
//        this.addNode(root);
//    }
//
//    public void addNode(TreeNode n) {
//        while (n != null) {
//            stack.push(n);
//            n = n.left;
//        }
//    }
//
//    /**
//     * @return whether we have a next smallest number
//     */
//    public boolean hasNext() {
//
//        if (!this.stack.isEmpty()) {
//            return true;
//        }
//
//        return false;
//    }
//
//    /**
//     * @return the next smallest number
//     */
//    public int next() {
//
//        TreeNode tmp = this.stack.pop();
//        while (tmp != null) {
//            this.addNode(tmp.right);
//            return tmp.val;
//        }
//
//        return -1;
//
//    }
//
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }
//}
//
///**
// * Your BSTIterator will be called like this:
// * BSTIterator i = new BSTIterator(root);
// * while (i.hasNext()) v[f()] = i.next();
// */