package edu.diegod.datastructures;

/**
 * Created by diego-d on 8/7/15.
 */
public interface MList {
    void add(Object data);

    boolean remove(int index);

    Object get(int index);

    int size();
}
