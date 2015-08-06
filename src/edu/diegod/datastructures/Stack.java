package edu.diegod.datastructures;

/**
 * Created by diego-d on 8/5/15.
 */
public interface Stack {

    int size();

    boolean isEmpty();

    Object top()
            throws StackEmptyException;

    void push(Object element)
            throws StackFullException;

    Object pop()
            throws StackEmptyException;

    class StackEmptyException extends RuntimeException {
        public StackEmptyException(String err) {
            super(err);
        }
    }

    class StackFullException extends RuntimeException {
        public StackFullException(String err) {
            super(err);
        }
    }
}
