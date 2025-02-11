/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;

import java.util.ArrayList;
import java.util.List;


class Film {
    String filmName; // Film adı
    int uniqueFilmID; // Benzersiz Film ID
    LinkedList<Actor> actorList; // Oyuncuların listesi
    String genre; // Tür
    int releaseYear; // Çıkış yılı
    double totalRevenue; // Toplam gelir
     List<ViewerFeedback> feedbackList = new ArrayList<>();

    public Film(String filmName, int uniqueFilmID, String genre, int releaseYear) {
        this.filmName = filmName;
        this.uniqueFilmID = uniqueFilmID;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.totalRevenue = 0.0;
        this.actorList = new LinkedList<>();
        this.feedbackList = new ArrayList<>();

    }
    // Getter for filmName
    public String getFilmName() {
        return this.filmName;
    }
    
    // Geri bildirim ekleme
    public void addFeedback(int rating, String review) {
        ViewerFeedback feedback = new ViewerFeedback(rating, review);
        feedbackList.add(feedback);
        if (feedbackList == null) {
    feedbackList = new ArrayList<>();
}
        updatePopularity(); // Geri bildirim sonrası popülerlik güncelleniyor
    }

    // Popülerlik sıralamasını güncelleme
    public void updatePopularity() {
        double totalRating = 0.0;
        for (ViewerFeedback feedback : feedbackList) {
            totalRating += feedback.getRating();
        }
        double averageRating = totalRating / feedbackList.size();
        System.out.println("Average Rating for " + filmName + ": " + averageRating);
    }
    // Filmin popülerlik puanını hesaplama
    public double getPopularityScore() {
        return totalRevenue;
    }

    // Oyuncu ekleme
    public void addActor(Actor actor) {
        if (!actorList.contains(actor)) {
            actorList.add(actor);
            actor.addFilm(this); // Çift yönlü ilişki kur
        }
    }

    // Oyuncu silme
    public void removeActor(Actor actor) {
        if (actorList.contains(actor)) {
            actorList.remove(actor);
            actor.removeFilm(this); // Oyuncudan da sil
        }
    }

    // Gelir güncelleme
    public void updateRevenue(double revenue) {
        this.totalRevenue += revenue;
    }

    // Film güncelleme
    public void updateFilm(String newName, String newGenre, int newYear) {
        if (newName != null && !newName.isEmpty()) this.filmName = newName;
        if (newGenre != null && !newGenre.isEmpty()) this.genre = newGenre;
        if (newYear > 0) this.releaseYear = newYear;
    }
    
    

    @Override
    public String toString() {
        return "Film: " + filmName + " (ID: " + uniqueFilmID + "), Genre: " + genre + ", Year: " + releaseYear + ", Revenue: " + totalRevenue;
    }

}
