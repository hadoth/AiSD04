package util.queue;

import interfaces.BoundQueueInterface;

/**
 * Created by Karol Pokomeda on 2017-03-29.
 * Class provides Last-In-First-Out sinking queue functionality with internal implementation based table
 * @implements BoundQueueInterface<T>
 */
public class SinkingQueue<T> implements BoundQueueInterface<T> {
    private int head;
    private int tail;
    private T[] internalList;
    private int size;

    public SinkingQueue(int queueSize){
        this.internalList = (T[]) new Object[queueSize];
    }

    @Override
    public void push(T t) {
        this.internalList[this.head] = t;
        this.head++;
        if (this.head >= this.internalList.length) this.head = this.head - this.internalList.length;
        this.size++;
        if (this.size > this.internalList.length) {
            this.size = this.internalList.length;
            this.tail++;
        }
    }

    @Override
    public T pop() {
        if (this.size == 0) throw new IndexOutOfBoundsException("Cannot remove from empty queue;");
        this.head--;
        if (this.head < 0) this.head = this.head + this.internalList.length;
        this.size--;
        return this.internalList[this.head];
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head = this.tail;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean isFull() {
        return this.size == this.internalList.length;
    }
}