package edu.diegod.datastructures;

/**
 * Created by diego-d on 8/5/15.
 */
public class ArrayStack implements Stack {

    public static final int CAPACITY = 1000;
    private int capacity;
    private Object S[];
    private int top = -1;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        S = new Object[capacity];
    }

    @Override
    public int size() {
        return (top + 1);
    }

    @Override
    public boolean isEmpty() {
        return (top < 0);
    }

    @Override
    public Object top() throws StackEmptyException {
        if(isEmpty())
            throw new StackEmptyException("La pila esta vacia.");
        return S[top];
    }

    @Override
    public void push(Object element) throws StackFullException {
        if (size() == capacity)
            throw new StackFullException("Desbordamiento de la pila.");
        S[++top] = element;
    }


    @Override
    public Object pop() throws StackEmptyException {
        Object element;
        if(isEmpty())
            throw new StackEmptyException("La pila esta vacia.");
        element = S[top];
        S[top--] = null;
        return element;
    }

}
