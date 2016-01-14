package SparseMatrixMultiplication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alan on 12/6/2015.
 */
public class Solution {
//    public int[][] multiply(int[][] A, int[][] B) {
//        int height = A.length;
//        int width = B[0].length;
//        int[][] res = new int[height][width];
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                res[i][j] = helper(A, i, B, j);
//            }
//        }
//        return res;
//    }
//
//    private int helper(int[][] A, int row, int[][] B, int col) {
//        int ret = 0;
//        for (int j = 0; j < A[0].length; j++) {
//            ret += A[row][j] * B[j][col];
//        }
//        return ret;
//    }

    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] multiply(int[][] A, int[][] B) {
        int height = A.length;
        int width = B[0].length;
        int[][] res = new int[height][width];
        List<Node> nodeA = new ArrayList<>();
        List<Node> nodeB = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j ++) {
                if (A[i][j]!=0) {
                    nodeA.add(new Node(i, j));
                }
            }
        }
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j ++) {
                if (B[i][j]!=0) {
                    nodeB.add(new Node(i, j));
                }
            }
        }

        for (Node nodea : nodeA) {
            for (Node nodeb : nodeB) {
                if(nodea.y == nodeb.x){
                    res[nodea.x][nodeb.y] +=A[nodea.x][nodea.y]*B[nodeb.x][nodeb.y];
                }
            }
        }
        return res;
    }


}
