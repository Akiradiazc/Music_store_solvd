package JAXBHandlers;

import Model.Genre;

import java.util.HashSet;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "Genres")
public class GenreHandler {
    //private List<Genre> GenreList = null;
    private Set<Genre> GenreList = new HashSet<Genre>();

    public Set<Genre> getGenreList(){
        return GenreList;
    }

    @XmlElement(name="Genre")
    public void setGenreList(Set<Genre> GenreList){
        this.GenreList = GenreList;
    }
}
