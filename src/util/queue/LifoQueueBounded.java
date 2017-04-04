package util.queue;

import interfaces.BoundQueueInterface;
import interfaces.QueueInterface;

/**
 * Created by Karol Pokomeda on 2017-03-29.
 * Class provides Last-In-First-Out bound queue functionality with internal implementation based table
 * @implements BoundQueueInterface<T>
 */
public class LifoQueueBounded<T> implements BoundQueueInterface<T> {
    private T[] internalList;
    private int headIndex;

    public LifoQueueBounded(int queueSize){
        this.internalList = (T[])new Object[queueSize];
    }

    @Override
    public void push(T t) {
        this.internalList[this.headIndex] = t;
        this.headIndex++;
    }

    @Override
    public T pop() {
        this.headIndex--;
        return this.internalList[this.headIndex];
    }

    @Override
    public void clear() {
        this.headIndex = 0;
    }

    @Override
    public int size() {
        return this.headIndex;
    }

    @Override
    public boolean isEmpty() {
        return this.headIndex == 0;
    }

    @Override
    public boolean isFull() {
        return this.headIndex == this.internalList.length;
    }
}
