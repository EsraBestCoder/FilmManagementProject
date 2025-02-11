/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;

/**
 *
 * @author macbookair
 */
    public class Node<T> {
        T data; // Holds the data
        Node<T> next; // Reference to the next node

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

