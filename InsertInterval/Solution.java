package InsertInterval;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alan on 11/8/14.
 */
public class Solution {
    public static void main(String[] args) {

    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> its = intervals;
        its.add(newInterval);
        return merge(its);

    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        List<Interval> ret = new LinkedList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        int start = intervals.get(0).start;
        int end = intervals.get(0).start;
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            }else{
                ret.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        ret.add(new Interval(start, end));

        return ret;
    }

    public static class Interval {
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
