/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;

  class Actor {
    String actorName; // Oyuncu adı
    int uniqueActorID; // Benzersiz Oyuncu ID
    LinkedList<Film> filmsParticipatedIn; // Yer aldığı filmler

    public Actor(String actorName, int uniqueActorID) {
        this.actorName = actorName;
        this.uniqueActorID = uniqueActorID;
        this.filmsParticipatedIn = new LinkedList<>();
    }

    // Filme ekleme
    public void addFilm(Film film) {
        if (!filmsParticipatedIn.contains(film)) {
            filmsParticipatedIn.add(film);
        }
    }

    // Filmden çıkarma
    public void removeFilm(Film film) {
        if (filmsParticipatedIn.contains(film)) {
            filmsParticipatedIn.remove(film);
        }
    }

    // Oyuncu bilgilerini güncelleme
    public void updateActor(String newName) {
        if (newName != null && !newName.isEmpty()) this.actorName = newName;
    }

    // Filmografiyi yazdırma
    public void displayFilmography() {
        System.out.print(actorName + "'s Filmography: ");
        filmsParticipatedIn.display();
    }
    

    @Override
    public String toString() {
        return "Actor: " + actorName + " (ID: " + uniqueActorID + ")";
    }
}



    
