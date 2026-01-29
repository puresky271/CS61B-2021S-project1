package deque;

public class LinkedListDeque<T> {

    //内部类Node
    private class Node {
        public T item;
        public Node next;
        public Node prev;

        public Node(Node p, T i, Node n) {
            this.prev = p;
            this.item = i;
            this.next = n;
        }
    }

    private Node sentinel;//哨兵节点
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node oldFirst = sentinel.next;
        Node p = new Node(null, null, null);

        p.item = item;
        p.prev = sentinel;
        p.next = oldFirst;

        oldFirst.prev = p;

        sentinel.next = p;
        this.size++;
    }

    public void addLast(T item) {
        Node oldLast = sentinel.prev;
        Node p = new Node(null, null, null);

        p.item = item;
        p.prev = oldLast;
        p.next = sentinel;

        oldLast.next = p;

        sentinel.prev = p;
        this.size++;
    }

    public T removeFirst() {
        if (this.size == 0) {
            return null;
        } else {
            Node oldFirst = sentinel.next;
            Node newFirst = oldFirst.next;

            sentinel.next = newFirst;
            newFirst.prev = sentinel;

            this.size--;
            return oldFirst.item;
        }
    }

    public T removeLast() {
        if (this.size == 0) {
            return null;
        } else {
            Node oldLast = sentinel.prev;
            Node newLast = oldLast.prev;

            sentinel.prev = newLast;
            newLast.next = sentinel;
            this.size--;
            return oldLast.item;
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T get(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return null;
        }

        Node p = sentinel.next;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.item;
    }

}
