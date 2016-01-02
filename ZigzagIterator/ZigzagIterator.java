package ZigzagIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 1/2/2016.
 */
public class ZigzagIterator {

    private List<List<Integer>> list;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.list = new ArrayList<>();
        if (v1.size() > 0) list.add(v1);
        if (v2.size() > 0) list.add(v2);

    }

    public int next() {
        if (!hasNext()) return -1;
        List<Integer> l1 = list.remove(0);
        int ret = l1.remove(0);
        if (l1.size() > 0) {
            list.add(l1);
        }
        return ret;
    }

    public boolean hasNext() {
        return list.size() > 0;
    }
}
