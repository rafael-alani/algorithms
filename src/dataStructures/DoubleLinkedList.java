package dataStructures;

public class DoubleLinkedList<T> {

    private static class Node<T> {
        private T element;

        private Node<T> prev;

        private Node<T> next;

        public Node(T e, Node<T> p, Node<T> n) {
            element = e;
            prev = p;
            next = n;
        }
        public T getElement( ) { return element; }
        public Node<T> getPrev( ) { return prev; }
        public Node<T> getNext( ) { return next; }
        public void setPrev(Node<T> p) { prev = p; }
        public void setNext(Node<T> n) { next = n; }
    }
    private Node<T> header;
    private Node<T> trailer;
    private int size = 0;
    public DoubleLinkedList( ) {
        header = new Node<>(null, null, null);

        trailer = new Node<>(null, header, null);

        header.setNext(trailer);

    }
    public int size( ) { return size; }
    public boolean isEmpty( ) { return size == 0; }

   public T first( ) {
        if (isEmpty( )) return null;
        return header.getNext( ).getElement( );
    }

    public T last( ) {
        if (isEmpty( )) return null;
        return trailer.getPrev( ).getElement( );
    }
    //uses add between to generalize for both additions
    public void addFirst(T e) {
        addBetween(e, header, header.getNext( ));
    }
    public void addLast(T e) {
        addBetween(e, trailer.getPrev( ), trailer);
    }
    
    //uses remove to generalize for both removals
    public T removeFirst( ) {
        if (isEmpty( )) return null;
        return remove(header.getNext( ));
    }
    public T removeLast( ) {
        if (isEmpty( )) return null;
        return remove(trailer.getPrev( ));
    }

    private void addBetween(T e, Node<T> predecessor, Node<T> successor) {
        Node<T> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    private T remove(Node<T> node) {
        Node<T> predecessor = node.getPrev( );
        Node<T> successor = node.getNext( );
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement( );
    }
}