/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;

// Stack veri yapısı
class Stack<T> {
    private Node<T> top; // Yığının en üst elemanı
    private int size;    // Yığının eleman sayısını takip eder

    // Node sınıfı (iç içe sınıf)
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Stack oluşturucu
    public Stack() {
        top = null;
        size = 0;
    }

    // Eleman ekleme (Push)
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Eleman çıkarma (Pop)
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop element.");
            return null; // Eğer stack boşsa null döner
        }

        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    // Yığının en üstündeki elemanı görüntüleme (Peek)
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to peek.");
            return null; // Eğer stack boşsa null döner
        }
        return top.data;
    }

    // Yığının boş olup olmadığını kontrol etme
    public boolean isEmpty() {
        return top == null;
    }

    // Yığının boyutunu döndürme
    public int getSize() {
        return size;
    }
}