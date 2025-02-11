/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;

class SearchFunctionality {
    private BST<Film> filmBST;
    private BST<Actor> actorBST;

    public SearchFunctionality() {
        filmBST = new BST<>();
        actorBST = new BST<>();
    }

    // Filme ekleme
    public void addFilm(Film film) {
        filmBST.insert(film.filmName, film);
    }

    // Oyuncuya ekleme
    public void addActor(Actor actor) {
        actorBST.insert(actor.actorName, actor);
    }

    // Film arama
    public void searchFilm(String filmName) {
        Film film = filmBST.search(filmName);
        if (film != null) {
            System.out.println("Film Found: " + film.toString());
        } else {
            System.out.println("Film Not Found: " + filmName);
        }
    }

    // Oyuncu arama
    public void searchActor(String actorName) {
        Actor actor = actorBST.search(actorName);
        if (actor != null) {
            System.out.println("Actor Found: " + actor.toString());
        } else {
            System.out.println("Actor Not Found: " + actorName);
        }
    }

    // Tüm filmleri sıralı şekilde yazdır
    public void displayAllFilms() {
        System.out.println("All Films (Sorted):");
        filmBST.displayInOrder();
    }

    // Tüm oyuncuları sıralı şekilde yazdır
    public void displayAllActors() {
        System.out.println("All Actors (Sorted):");
        actorBST.displayInOrder();
    }
}
