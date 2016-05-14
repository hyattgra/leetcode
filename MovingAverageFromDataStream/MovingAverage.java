package MovingAverageFromDataStream;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Alan on 5/14/2016.
 */
public class MovingAverage {

    LinkedList<Integer> quque;
    int size;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.quque = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        quque.add(val);

        if (quque.size() > size) {
            quque.poll();
        }
        double sum = 0;
        for (int i = 0; i < quque.size(); i++) {
            sum += quque.get(i);
        }
        return sum / quque.size();
    }
}
