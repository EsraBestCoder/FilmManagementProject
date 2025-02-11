package filmmanagement;


class MyHashMap<K, V> {
    private static final int SIZE = 16;  // Tablo boyutu (capacity)
    private Entry<K, V>[] table;  // Hash table (dizi)

    // HashMap elemanlarını tutan Entry sınıfı (Anahtar-Değer)
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // Constructor: HashMap'i başlatır
    public MyHashMap() {
        table = new Entry[SIZE];  // Dizi oluşturuluyor
    }

    // Hash kodu ve kapasiteye göre index hesaplama
    private int getIndex(K key) {
        return key.hashCode() % SIZE;
    }

    // Anahtar ve değer ekleme
    public void put(K key, V value) {
        int index = getIndex(key);  // Anahtara göre index hesapla
        Entry<K, V> newEntry = new Entry<>(key, value);  // Yeni bir entry oluştur

        // Eğer bu index'te eleman yoksa, doğrudan ekle
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            // Eğer index'te birden fazla eleman varsa, zincirleme yap
            Entry<K, V> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {  // Eğer anahtar zaten varsa, değeri güncelle
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            // Zincirleme bağlantıya yeni entry ekle
            current.next = newEntry;
        }
    }

    // Anahtar ile değeri arama
    public V get(K key) {
        int index = getIndex(key);  // Anahtara göre index hesapla
        Entry<K, V> current = table[index];

        // Anahtar ile eşleşen entry'yi bul
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;  // Değeri döndür
            }
            current = current.next;  // Sonraki entry'ye geç
        }
        return null;  // Eğer anahtar bulunamazsa, null döndür
    }

    // Anahtar ile öğe silme
    public void remove(K key) {
        int index = getIndex(key);  // Anahtara göre index hesapla
        Entry<K, V> current = table[index];
        Entry<K, V> previous = null;

        // Anahtar ile eşleşen entry'yi bul
        while (current != null) {
            if (current.key.equals(key)) {
                // Eğer baştaki entry ise
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    // Zincirleme bağlantıda ortada veya sonda ise
                    previous.next = current.next;
                }
                return;  // Silme işlemi tamamlandı
            }
            previous = current;  // Önceki entry'yi güncelle
            current = current.next;  // Sonraki entry'ye geç
        }
    }

    // HashMap içeriğini yazdırma (Debugging amacıyla)
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            if (table[i] != null) {
                Entry<K, V> current = table[i];
                System.out.print("Index " + i + ": ");
                while (current != null) {
                    System.out.print("(" + current.key + " => " + current.value + ") -> ");
                    current = current.next;
                }
                System.out.println("null");
            }
        }
    }
}
