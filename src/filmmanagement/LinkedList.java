/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;


 class LinkedList<T> {
    private Node<T> head;

    // Bağlı listenin düğüm yapısı
    public static class Node<T> {
        T data; // Veri
        Node<T> next; // Sonraki düğüme referans

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
        
    }
// Listeyi döndürme (bağlantılı listeyi almak için)
    public Node<T> getHead() {
        return head;
    }
    // Listeye eleman ekleme
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Listeden eleman silme
    public void remove(T data) {
        if (head == null) return;

        // Eğer baştaki eleman silinecekse
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        // Orta veya son elemanı silmek için
        Node<T> temp = head;
        while (temp.next != null && !temp.next.data.equals(data)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Listeyi yazdırma
    public void display() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Eleman içeriyor mu kontrolü
    public boolean contains(T data) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) return true;
            temp = temp.next;
        }
        return false;
    }
 }