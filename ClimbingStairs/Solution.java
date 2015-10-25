package ClimbingStairs;

/**
 * Created by Alan on 11/8/14.
 */
public class Solution {
    public static void main(String[] args) {

        System.out.println(climbStairs(5));

    }

    public static int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] mem = new int[n+1];
        mem[1] = 0;
        mem[2] = 2;
        for(int i=3;i<n+1;i++){
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n];
    }

}
