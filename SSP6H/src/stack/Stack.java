package stack;

import java.util.NoSuchElementException;

/**
 * The <tt>Stack</tt> class represents a last-in-head-out (LIFO) stack of
 * generic items. It supports the usual <em>push</em> and <em>pop</em>
 * operations, along with methods for peeking at the top item, testing if the
 * stack is empty, and iterating through the items in LIFO order.
 * <p>
 */
public class Stack<Item> {
    private int N; // size of the stack
    private Node head; // top of stack

    // helper linked list class
    private class Node {
        private Item item;
        private Node previous;

        private boolean hasPrevious() {
            return previous != null;
        }
    }

    /**
     * Create an empty stack.
     */
    public Stack() {
        head = null;
        N = -1;
        assert check();
    }

    /**
     * Is the stack empty?
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Return the number of items in the stack.
     */
    public int size() {
        return N;
    }

    /**
     * Add the item to the stack.
     */
    public void push(Item item) {
        Node previous = head;
        head = new Node();
        head.item = item;
        head.previous = previous;
        N++;
        assert check();
    }

    /**
     * Delete and return the item most recently added to the stack.
     *
     * @throws java.util.NoSuchElementException if stack is empty.
     */
    public Item pop() {
        if( isEmpty() ) {
            throw new NoSuchElementException();
        }

        Item item = head.item; // save item to return
        head = head.previous; // delete head node
        N--;
        assert check();
        return item; // return the saved item
    }

    /**
     * Return the item most recently added to the stack without deletion.
     *
     * @throws java.util.NoSuchElementException if stack is empty.
     */
    public Item peek() {
        if( isEmpty() ) {
            throw new NoSuchElementException();
        }

        return head.item;
    }

    /**
     * Clear stack
     */
    public void clear() {
        N = -1;
        head = null;
    }

    /**
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node current = head; current != null ; current = current.previous) {
            Item item = current.item;
            s.append(item + " ");
        }
        return s.toString();
    }

    // check internal invariants
    private boolean check() {
        if (N == -1) {
            if (head != null) {
                return false;
            }
        } else if (N == 0) {
            if (head == null) {
                return false;
            }
            if (head.previous != null) {
                return false;
            }
        } else if (N == 1) {
            if (head == null) {
                return false;
            }
            if (head.previous == null) {
                return false;
            }
        } else {
            if (head == null) {
                return false;
            }
        }

        // check internal consistency of instance variable N
        int numberOfNodes = -1;
        for (Node x = head; x != null; x = x.previous) {
            numberOfNodes++;
        }
        if (numberOfNodes != N) {
            return false;
        }

        return true;
    }
}