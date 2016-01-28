package Flatten2DVector;

import java.util.Iterator;
import java.util.List;

/**
 * Created by gzhou on 1/28/16.
 */
public class Vector2D {
    private Iterator<List<Integer>> rowIter;
    private Iterator<Integer> colIter;

    public Vector2D(List<List<Integer>> vec2d) {
        this.rowIter = vec2d.iterator();
        if(rowIter.hasNext()){
            colIter = rowIter.next().iterator();
            moveToNextValid();
        }
    }

    public boolean hasNext() {
        return colIter!=null && colIter.hasNext();
    }

    public int next() {
        int ret =  colIter.next();
        moveToNextValid();
        return ret;
    }

    private void moveToNextValid() {
        while(!colIter.hasNext() && rowIter.hasNext()){
            colIter = rowIter.next().iterator();
        }
    }
}
