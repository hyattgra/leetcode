public class NestedIterator implements Iterator<Integer> {

    Stack<Iterator<NestedInteger>> stack;
    NestedInteger next;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new Stack<Iterator<NestedInteger>>();
        this.stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        moveToNext();
        if(next !=null){
            Integer ret = next.getInteger();
            this.next = null;
            return ret;
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean hasNext() {
        moveToNext();
        return next != null;
    }

    private void moveToNext(){
        if(next == null && !stack.isEmpty()){
            if(stack.peek().hasNext()){
                NestedInteger next = stack.peek().next();
                if(!next.isInteger()){
                    stack.push(next.getList().iterator());
                    moveToNext();
                }else if(next.isInteger()){
                    this.next = next;
                }
            }else{
                stack.pop();
                moveToNext();
            }
        }
    }

    interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}
