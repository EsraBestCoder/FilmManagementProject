package filmmanagement;

class Heap {
    private Film[] heapArray;
    private int size;
    private int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heapArray = new Film[capacity];
    }

    public int getCapacity() {
        return this.capacity;
    }

    // Sol çocuk indeksi
    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    // Sağ çocuk indeksi
    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    // Ebeveyn indeksi
    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    // Eleman takas işlemi
    private void swap(int index1, int index2) {
        Film temp = heapArray[index1];
        heapArray[index1] = heapArray[index2];
        heapArray[index2] = temp;
    }

    // Film ekleme (Insert)
    public void insert(Film film) {
        if (size == capacity) {
            System.out.println("Heap is full! Cannot add more films.");
            return;
        }

        heapArray[size] = film;
        size++;
        heapifyUp(size - 1);
    }

    // Heapify Up: Yeni eklenen elemanı doğru pozisyona taşıma
    private void heapifyUp(int index) {
        while (index > 0 && compare(heapArray[index], heapArray[parentIndex(index)]) > 0) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    // Maksimum elemanı çıkarma (Extract Max)
    public Film extractMax() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return null;
        }

        Film max = heapArray[0];
        heapArray[0] = heapArray[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    // Heapify Down: Kökteki elemanı doğru pozisyona taşıma
    private void heapifyDown(int index) {
        int largest = index;
        int leftChild = leftChildIndex(index);
        int rightChild = rightChildIndex(index);

        if (leftChild < size && compare(heapArray[leftChild], heapArray[largest]) > 0) {
            largest = leftChild;
        }

        if (rightChild < size && compare(heapArray[rightChild], heapArray[largest]) > 0) {
            largest = rightChild;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    // Film karşılaştırması (Gelir > Çıkış yılı)
    private int compare(Film film1, Film film2) {
        if (film1.totalRevenue > film2.totalRevenue) {
            return 1;
        } else if (film1.totalRevenue < film2.totalRevenue) {
            return -1;
        } else {
            // Gelir eşitse çıkış yılına göre sıralama
            return Integer.compare(film2.releaseYear, film1.releaseYear);
        }
    }

    // Tüm filmleri sıralı şekilde görüntüleme
    public void displayHeap() {
        System.out.println("Films ranked by popularity (Revenue and Release Year):");
        for (int i = 0; i < size; i++) {
            System.out.println(heapArray[i].filmName + " - Revenue: $" + heapArray[i].totalRevenue +
                    ", Year: " + heapArray[i].releaseYear);
        }
    }
}
