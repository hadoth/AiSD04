package util.queue;

import interfaces.QueueInterface;

/**
 * Created by Karol Pokomeda on 2017-03-29.
 * Class provides Last-In-First-Out queue functionality with internal implementation based on linked-list-like Element
 * @implements QueueInterface<T>
 */
public class LifoQueue<T> implements QueueInterface<T> {
    private Element<T> head;
    private int size;

    public LifoQueue(){
        this.clear();
    }

    @Override
    public void push(T t) {
        Element<T> newElement = new Element<>(t);
        newElement.setNext(this.head);
        this.head = newElement;
        this.size++;
    }

    @Override
    public T pop() {
        Element<T> result = this.head;
        this.head = result.getNext();
        this.size--;
        return result.current;
    }

    @Override
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }


    private final class Element<T> {
        private T current;
        private Element<T> next;

        Element(T t){
            this.current = t;
            this.next = null;
        }

        Element<T> getNext() {
            return next;
        }

        void setNext(Element<T> next) {
            this.next = next;
        }
    }
}
