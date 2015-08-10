package edu.diegod.datastructures;

/**
 * Created by diego-d on 8/7/15.
 */
public class MLinkedList implements MList {
    private Node head;
    private int listCount;

    public MLinkedList() {
        head = null;
        listCount = 0;
    }

    @Override
    public void add(Object data) {
        Node addedNode;
        addedNode = new Node(data, listCount);
        addedNode.linkedTo = head;
        head = addedNode;
        listCount++;
    }

    @Override
    public boolean remove(int index) {
        Node current, prev;
        boolean found;

        current = head;
        prev = null;
        found = false;

        while ((current != null) && (!found)) {
            found = (current.index == index);
            if (!found) {
                prev = current;
                current = current.linkedTo;
            }
            if (current != null) {
                if (current == head)
                    head = current.linkedTo;
                else
                    prev.linkedTo = current.linkedTo;
            }
            current = null;
        }
        return found;
    }

    @Override
    public Object get(int index) {
        Node result;
        for (result = head; result != null; result = result.linkedTo)
            if (result.index == index)
                return result.data;
        return null;
    }

    @Override
    public int size() {
        return listCount;
    }

    private class Node {
        Object data;
        Node linkedTo;
        int index;

        public Node(Object data, int index) {
            this.data = data;
            this.linkedTo = null;
            this.index = index;
        }

        public Object getData() {
            return data;
        }

        public Node getLinkedTo() {
            return linkedTo;
        }

        public void setLinkedTo(Node linkedTo) {
            this.linkedTo = linkedTo;
        }
    }
}
