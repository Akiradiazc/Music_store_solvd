package Views;

import Model.Genre;

import java.util.List;

public class ViewGenre {
    public void ViewGenres(Genre genre){
        System.out.println("Genre Info: "+genre);
    }
    public void ViewGenres(List<Genre> genreList){
        for (Genre genre : genreList){
            System.out.println("Genre Info: "+genre);
        }
    }
}