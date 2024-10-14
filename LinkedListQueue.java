package program4C;
import java.io.Serializable;
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

// Generic LinkedList Queue class
public class LinkedListQueue<T> implements Serializable{
    private Node<T> front;  // Front of the queue (head of linked list)
    private Node<T> rear;   // Rear of the queue (tail of linked list)
    private int size;       // Size of the queue

    public LinkedListQueue() {
        front = rear = null;
        size = 0;
    }

    // Enqueue: add element to the rear of the queue
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear == null) {  // If the queue is empty
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Dequeue: remove element from the front of the queue
    public T dequeue() {
        if (front == null) {  // If the queue is empty
            throw new IllegalStateException("Queue is empty");
        }
        T data = front.data;
        front = front.next;

        if (front == null) {  // If the queue becomes empty after dequeuing
            rear = null;
        }
        size--;
        return data;
    }

    // Peek: get the front element without removing it
    public T peek() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Get the size of the queue
    public int size() {
        return size;
    }

}
