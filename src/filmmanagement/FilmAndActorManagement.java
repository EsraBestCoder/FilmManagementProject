/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;


    
class FilmAndActorManagement {
    LinkedList<Film> films; // Tüm filmler
    LinkedList<Actor> actors; // Tüm oyuncular

    public FilmAndActorManagement() {
        this.films = new LinkedList<>();
        this.actors = new LinkedList<>();
    }

    // Film ekleme
    public void addFilm(Film film) {
        films.add(film);
    }

    // Oyuncu ekleme
    public void addActor(Actor actor) {
        actors.add(actor);
    }

    // Film silme
    public void removeFilm(Film film) {
        films.remove(film);
    }

    // Oyuncu silme
    public void removeActor(Actor actor) {
        actors.remove(actor);
    }

    // Tüm filmleri listeleme
    public void displayAllFilms() {
        films.display();
    }

    // Tüm oyuncuları listeleme
    public void displayAllActors() {
        actors.display();
    }
}


