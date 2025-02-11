/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;

class BSTNode<T> {
    String key; // Film veya oyuncu adı
    T data;     // İlgili veri (Film veya Oyuncu objesi)
    BSTNode<T> left, right;

    public BSTNode(String key, T data) {
        this.key = key;
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class BST<T> {
    private BSTNode<T> root;

    // BST'ye düğüm ekleme
    public void insert(String key, T data) {
        root = insertRec(root, key, data);
    }

    private BSTNode<T> insertRec(BSTNode<T> root, String key, T data) {
        if (root == null) {
            return new BSTNode<>(key, data);
        }

        if (key.compareTo(root.key) < 0) {
            root.left = insertRec(root.left, key, data);
        } else if (key.compareTo(root.key) > 0) {
            root.right = insertRec(root.right, key, data);
        }
        return root;
    }

    // BST'den anahtar arama
    public T search(String key) {
        return searchRec(root, key);
    }

    private T searchRec(BSTNode<T> root, String key) {
        if (root == null) {
            return null; // Bulunamadı
        }

        if (key.equals(root.key)) {
            return root.data;
        }

        if (key.compareTo(root.key) < 0) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    // Sıralı şekilde düğümleri yazdırma (In-Order Traversal)
    public void displayInOrder() {
        displayInOrderRec(root);
    }

    private void displayInOrderRec(BSTNode<T> root) {
        if (root != null) {
            displayInOrderRec(root.left);
            System.out.println(root.key);
            displayInOrderRec(root.right);
        }
    }
}
