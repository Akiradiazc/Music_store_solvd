package JAXBHandlers;

import Model.Genre;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.util.HashSet;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
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
