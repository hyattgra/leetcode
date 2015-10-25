package PermutationsII;

import java.util.*;

/**
 * Created by gzhou on 6/9/15.
 */
public class Solution {

    public static void main(String[] args) {

        int[] test = {-1, -1, 3, -1};
        List<List<Integer>> ret = permuteUnique(test);
        for (List<Integer> list : ret) {
            for (Integer i : list) {
                System.out.print(" " + i + " ");
            }
            System.out.println(" ");
        }

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        per(nums, 0, tmp, ret, visited);
        return ret;
    }

    public static void per(int[] nums, int start, List<Integer> tmp, List<List<Integer>> ret, boolean[] visited) {
        if (tmp.size() == nums.length) {
            ret.add(new ArrayList<Integer>(tmp));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            } else if(i>=1 && nums[i-1] == nums[i] && visited[i-1]){
                continue;
            } else{
                tmp.add(nums[i]);
                visited[i] = true;
                per(nums, start + 1, tmp, ret, visited);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }

}
