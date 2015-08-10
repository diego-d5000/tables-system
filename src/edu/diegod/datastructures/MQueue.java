package edu.diegod.datastructures;

/**
 * Created by diego-d on 8/6/15.
 */
public interface MQueue {

    boolean isFull();

    boolean isEmpty();

    Object peek()
            throws QueueEmptyException;

    void enqueue(Object element)
            throws QueueFullException;

    Object dequeue()
            throws QueueEmptyException;

    class QueueEmptyException extends RuntimeException {
        public QueueEmptyException(String err) {
            super(err);
        }
    }

    class QueueFullException extends RuntimeException {
        public QueueFullException(String err) {
            super(err);
        }
    }
}
