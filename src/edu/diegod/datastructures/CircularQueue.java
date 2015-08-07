package edu.diegod.datastructures;

/**
 * Created by diego-d on 8/5/15.
 */
public class CircularQueue implements mQueue {
    private static final int MAXSIZE = 39;
    protected int first;
    protected int last;
    protected Object[] queueList;

    private int next(int r){
        return (r+1) % MAXSIZE;
    }

    public CircularQueue() {
        this.first = 0;
        this.last = MAXSIZE-1;
        this.queueList = new Object[MAXSIZE];
    }

    @Override
    public boolean isFull() {
        return first == next(next(last));
    }

    @Override
    public boolean isEmpty() {
        return first  == next(last);
    }

    @Override
    public Object peek() throws QueueEmptyException {
        if (isEmpty())
            throw new QueueEmptyException("La cola esta vacia");
        return queueList[first];
    }

    @Override
    public void enqueue(Object element) throws QueueFullException {
        if (isFull())
            throw new QueueFullException("La cola esta llena");
        last = next(last);
        queueList[last] = element;
    }

    @Override
    public Object dequeue() throws QueueEmptyException {
        if (isEmpty())
            throw new QueueEmptyException("La cola esta vacia");
        Object firstElement = queueList[first];
        first = next(first);
        return firstElement;
    }
}
