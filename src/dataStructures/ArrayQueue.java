package dataStructures;

public class ArrayQueue<T> {
    private int capacity = 1000;
    private T[] data;
    private int first = 0;
    private int size = 0;

    public ArrayQueue() {
        data = (T[]) new Object[capacity];
    }
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void enqueue(T e) throws IllegalStateException {
        if (size == data.length) throw new IllegalStateException("Queue is full");
        int avail = (first + size) % data.length;
        data[avail] = e;
        size++;
    }

    public T first() {
        if (isEmpty()) return null;
        return data[first];
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T answer = data[first];
        data[first] = null;
        first = (first + 1) % data.length;
        size--;
        return answer;
    }
}
