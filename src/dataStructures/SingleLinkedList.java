package dataStructures;

public class SingleLinkedList<T> {
    private static class Node<T> {
        private T element;
        private Node<T> next;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
    Node<T> tail = null;
    Node<T> head = null;
    int size;
    public SingleLinkedList(){
        this.size = 0;
    }
    public SingleLinkedList(int size){
        this.head = new Node<>(null, null);
        this.size = size;

        Node<T> iterator = head;
        for(int i = 0; i < size; i++){
            Node<T> temp = new Node<>(null, null);
            iterator.setNext(temp);
        }

        this.tail = iterator;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty() {return size == 0;}
    public Node<T> first() {return isEmpty() ? null : this.head;}
    public Node<T> last() {return isEmpty() ? null : this.tail;}
    public void addFirst(T element) {
        head = new Node<>(element,head);
        if(isEmpty()) tail = head;
        size++;
    }

    public void addLast(T element){
        if(isEmpty()) this.addFirst(element);
        else {
            Node<T> temp = new Node<>(element, null);
            tail.setNext(temp);
            tail = temp;
            size++;
        }
    }

    public T removeFirst() {
        if(isEmpty()) return null;
        T element = head.getElement();
        head = head.getNext(); // this will make the head become null if the list is 1 element long
        size--;
        if(isEmpty()) tail = null;
        return element;
    }

    public T removeLast() {
        if(isEmpty()) return null;
        T element = tail.getElement();

        // compared to the removeFirst() here we handle separately the case when the list is 1 element long
        if(size == 1){
            head = null;
            tail = null;
        }else {
            Node<T> iterator = head;
            while (iterator.getNext().getElement() != null)
                iterator = iterator.getNext();
            tail = iterator;
            tail.setNext(null);
        }
        return element;
    }
}
