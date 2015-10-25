package MeetingRooms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Alan on 9/9/15.
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Comparator comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };
        Arrays.sort(intervals, comparator);

        for (int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i].end > intervals[i+1].start){
                return false;
            }
        }
        return true;
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
