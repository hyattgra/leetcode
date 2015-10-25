package CourseScheduleTwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Alan on 10/17/15.
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] inDegreeNode = new int[numCourses];
        List<Integer>[] nextNode = new List[numCourses];

        for (int i = 0; i < numCourses; i++) {
            nextNode[i] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            inDegreeNode[p[0]]++;
            nextNode[p[1]].add(p[0]);
        }
        Queue<Integer> sourceNode = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegreeNode[i] == 0) {
                sourceNode.add(i);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if(sourceNode.isEmpty()){
                return new int[0];
            }
            int n = sourceNode.poll();
            result[i] = n;
            List<Integer> preNodes = nextNode[n];
            for(int next : preNodes){
                inDegreeNode[next] -- ;
                if(inDegreeNode[next] == 0){
                    sourceNode.add(next);
                }
            }

        }
        return result;
    }
}
