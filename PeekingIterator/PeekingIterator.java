package PeekingIterator;

import java.util.Iterator;

/**
 * Created by Alan on 12/26/2015.
 */
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer temp;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) {
            temp = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {

        return temp;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ret = temp;
        temp = iterator.hasNext() ? iterator.next() : null;
        return ret;
    }

    @Override
    public boolean hasNext() {
        if (temp == null) {
            return false;
        }
        return true;
    }
}