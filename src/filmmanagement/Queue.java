/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;

class Queue<T> {
    private Node<T> front;
    private Node<T> rear;

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        front = null;
        rear = null;
    }

    // Eleman ekleme (Enqueue)
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Eleman çıkarma (Dequeue)
    public T dequeue() {
        if (front == null) return null;

        T data = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return data;
    }

    // Kuyruğun boş olup olmadığını kontrol etme
    public boolean isEmpty() {
        return front == null;
    }

    // Kuyruğun önündeki elemanı görüntüleme
    public T peek() {
        return front != null ? front.data : null;
    }
}
