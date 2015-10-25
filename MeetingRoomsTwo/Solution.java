package MeetingRoomsTwo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by gzhou on 9/4/15.
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Comparator comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };
        Arrays.sort(intervals, comparator);

        PriorityQueue<Interval> queue = new PriorityQueue<Interval>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            if(queue.isEmpty()){
                queue.offer(intervals[i]);
            }else {
                Interval tmp = queue.poll();
                if(tmp.end<=intervals[i].start){
                    tmp.end = intervals[i].end;
                }else{
                    queue.offer(intervals[i]);
                }
                queue.offer(tmp);
            }
        }
        return queue.size();
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
