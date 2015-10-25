package CourseSchedule;

import java.util.*;

/**
 * Created by Alan on 9/13/15.
 */
public class Solution {

    public static void main(String[] args) {
        int numCourse = 1;
        int[][] prerequisites = new int[1][];

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set> map = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            map.add(new HashSet<Integer>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            Set<Integer> set = map.get(i);
            Iterator<Integer> iter = set.iterator();
            while (iter.hasNext()) {
                inDegree[iter.next()]++;
            }
        }

        for (int i = 0; i < numCourses; i++) {
            int j = 0;
            for (; j < numCourses; j++) {
                if (inDegree[j] == 0) {
                    break;
                }
            }

            if (j == numCourses) {
                return false;
            }

            inDegree[j] = -1;

            Set<Integer> set = map.get(j);
            Iterator<Integer> iter = set.iterator();
            while(iter.hasNext()){
                inDegree[iter.next()]--;
            }
        }

        return true;


//        Map<Integer, Set<Integer>> map = new HashMap<>();
//        int[] inDegree = new int[numCourses];
//        for (int i = 0; i < prerequisites.length; i++) {
//            if (!map.containsKey(prerequisites[i][0])) {
//                Set<Integer> set = new HashSet<>();
//                set.add(prerequisites[i][1]);
//                map.put(prerequisites[i][0], set);
//            } else {
//                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
//            }
//            inDegree[prerequisites[i][0]]++;
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < inDegree.length; i++) {
//            if (inDegree[i] == 0) {
//                queue.add(i);
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            int pre = queue.poll();
//            for (Integer i : map.get(pre)) {
//                inDegree[i]--;
//                if (inDegree[i] == 0) {
//                    queue.add(i);
//                }
//            }
//        }
//
//        for (int i = 0; i < inDegree.length; i++) {
//            if (inDegree[i] != 0) {
//                return false;
//            }
//        }
//        return true;
    }
}
