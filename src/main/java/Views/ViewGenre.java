package Views;

import Model.Genre;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ViewGenre {
    public void ViewGenres(Genre genre){
        System.out.println("Genre Info: "+genre);
    }
    public void ViewGenres(List<Genre> genreList){
        for (Genre genre : genreList){
            System.out.println("Genre Info: "+genre);
        }
    }

    public void ViewGenres(HashSet<Genre> genreSet){
        for (Genre genre: genreSet){
            System.out.println("Genre Info: "+genre);
        }
    }
}