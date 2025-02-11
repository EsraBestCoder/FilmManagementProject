/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;

/**
 *
 * @author macbookair
 */
    class ViewerFeedback {
    private int rating;  // Puan
    private String review;  // Yorum

    public ViewerFeedback(int rating, String review) {
        this.rating = rating;
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    @Override
    public String toString() {
        return "Rating: " + rating + ", Review: " + review;
    }
    
}

