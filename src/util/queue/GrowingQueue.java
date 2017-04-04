package util.queue;

import interfaces.QueueInterface;

/**
 * Created by Karol Pokomeda on 2017-03-29.
 * Class provides Last-In-First-Out queue functionality with internal implementation based on dynamically size-changing
 * table
 * @implements QueueInterface<T>
 */
public class GrowingQueue<T> implements QueueInterface<T> {
    private int headIndex;
    private T[] internalList;

    public GrowingQueue(){
        this.clear();
    }

    @Override
    public void push(T t) {
        this.internalList[this.headIndex] = t;
        this.headIndex++;
        this.checkIfTooBig();
    }

    @Override
    public T pop() {
        this.headIndex--;
        this.checkIfTooSmall();
        return this.internalList[headIndex];
    }

    @Override
    public void clear() {
        this.headIndex = 0;
        this.internalList = (T[]) new Object[10];
    }

    @Override
    public int size() {
        return this.headIndex;
    }

    @Override
    public boolean isEmpty() {
        return this.headIndex == 0;
    }

    private void checkIfTooBig() {
        if (this.headIndex > this.internalList.length*3/4){
            T[] result = (T[]) new Object[this.internalList.length*2];
            for (int i = 0; i < this.headIndex; i++) result[i] = this.internalList[i];
            this.internalList = result;
        }
    }

    private void checkIfTooSmall() {
        if (this.headIndex < this.internalList.length/4){
            T[] result = (T[]) new Object[(this.internalList.length+1)/2];
            for (int i = 0; i <= this.headIndex; i++) result[i] = this.internalList[i];
            this.internalList = result;
        }
    }
}