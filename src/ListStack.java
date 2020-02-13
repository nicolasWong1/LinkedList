/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicolaswong
 */
import java.util.EmptyStackException;

public class ListStack extends LinkedList {

    public ListStack() {
        super();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    public Object pop() throws EmptyListException {
        if (super.isEmpty()) {
            throw new EmptyStackException();
        } else {
            return removeFromHead();
        }
    }

    public Object top() throws EmptyStackException {
        if (super.isEmpty()) {
            throw new EmptyStackException();
        } else {
            return super.get(1);
        }
    }

    public void push(Object o) {
        this.addToHead(o);
    }

    public String toString() {
        return super.toString();
    }

    public int search(Object o) {
        if (super.isEmpty()) {
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i < length; i++) {
            if (o.equals(cur.getData())) {
                return -1;
            }
            cur = cur.getNext();
        }
        return -1;
    }
}
