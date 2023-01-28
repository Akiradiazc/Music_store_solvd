package Views;

import Model.Album;
import java.util.List;

public class ViewAlbum {
    public void ViewAlbums(Album album){
        System.out.println("Album Info: "+album);
    }
    public void ViewAlbums(List<Album> AlbumsList){
        for(Album album : AlbumsList){
            System.out.println("Album Info: "+album);
        }
    }
}
