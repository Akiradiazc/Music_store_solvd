package Views;

import Model.Artist;

import java.util.List;

public class ViewArtists {
    public void ViewArtist(Artist artist){
        System.out.println("Artist Info: "+ artist);
    }
    public void ViewArtist(List<Artist> ArtistsList){
        for(Artist artist: ArtistsList){
            System.out.println("Artist Info: "+ artist);
        }
    }
}
