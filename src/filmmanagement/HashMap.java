/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;

/**
 *
 * @author macbookair
 */
public class HashMap {
     private class Entry {
        String key;
        LinkedList<Integer> value;
        Entry next;

        Entry(String key, LinkedList<Integer> value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Entry[] buckets;
    private static final int DEFAULT_CAPACITY = 16;

    public HashMap() {
        buckets = new Entry[DEFAULT_CAPACITY];
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void put(String key, LinkedList<Integer> value) {
        int index = hash(key);
        Entry newEntry = new Entry(key, value);

        if (buckets[index] == null) {
            buckets[index] = newEntry;
        } else {
            Entry current = buckets[index];
            while (current.next != null && !current.key.equals(key)) {
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = newEntry;
            }
        }
    }
}
