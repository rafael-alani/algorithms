package dataStructures;

public class ArrayStack<E> {
    private int capacity=1000;
    private E[ ] data;
    private int top = -1; // starts at -1 to keep the same time track of the top element
    public ArrayStack( ) { data = (E[ ]) new Object[capacity];}
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        data = (E[ ]) new Object[capacity];
    }
    public int size( ) { return top + 1; }
    public boolean isEmpty( ) { return size() == 0; }
    public void push(E e) throws IllegalStateException {
        if (size( ) == data.length) throw new IllegalStateException("Stack is full");
        data[++top] = e;
    }
    public E top( ) {
        if (isEmpty( )) return null;
        return data[top];
    }
    public E pop( ) {
        if (isEmpty( )) return null;
        E answer = data[top];
        data[top] = null;
        top--;
        return answer;
    }
}
