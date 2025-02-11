package filmmanagement;

class PopularityRankings {
    private Heap heap;
    private LinkedList<Film> filmsList;

    public PopularityRankings(int initialCapacity) {
        this.heap = new Heap(initialCapacity); // Başlangıç kapasitesi
        this.filmsList = new LinkedList<>();
    }

    // Yeni film eklemek için
    public void addFilm(Film film) {
        filmsList.add(film); // Filme bağlı listeye ekleniyor
        if (filmsListSize() > heap.getCapacity()) {
            heap = new Heap(filmsListSize()); // Kapasiteyi arttırıyoruz
        }
        heap.insert(film); // Film heap'e ekleniyor
    }

    // Film gelirini güncellemek için
    public void updateFilmRevenue(String filmName, double additionalRevenue) {
        LinkedList.Node<Film> temp = filmsList.getHead();  // getHead() ile head'e erişiyoruz
        while (temp != null) {
            Film film = temp.data;
            if (film.getFilmName().equals(filmName)) {
                film.totalRevenue += additionalRevenue; // Geliri arttırıyoruz
                heapifyHeap(); // Heap'i güncelliyoruz
                return;
            }
            temp = temp.next;
        }
        System.out.println("Film bulunamadı: " + filmName);
    }
 
    // Popülerlik sıralamasını görüntülemek için
    public void displayPopularityRankings() {
        heap.displayHeap();
    }

    // Heap'i baştan oluşturup güncelleme işlemi
    private void heapifyHeap() {
        Heap newHeap = new Heap(filmsListSize());  // Yeni bir heap oluşturuyoruz
        LinkedList.Node<Film> temp = filmsList.getHead();  // getHead() ile head'e erişiyoruz
        while (temp != null) {
            newHeap.insert(temp.data); // Tüm filmleri yeni heap'e ekliyoruz
            temp = temp.next;
        }
        this.heap = newHeap;  // Heap'i yeniliyoruz
    }

    // Filmler listesinin boyutunu döndürmek için
    private int filmsListSize() {
        int size = 0;
        LinkedList.Node<Film> temp = filmsList.getHead();  // getHead() ile head'e erişiyoruz
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }
}
