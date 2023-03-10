package Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Genre {
    private int idGenre;
    private String Genre_name;

    public Genre(){}
    public Genre(String Genre_name){
        this.idGenre = idGenre;
        this.Genre_name = Genre_name;
    }
    public Genre(int idGenre, String Genre_name){
        this.idGenre = idGenre;
        this.Genre_name = Genre_name;
    }

    public String getGenre_name() {
        return Genre_name;
    }

    public void setGenre_name(String genre_name) {
        Genre_name = genre_name;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "idGenre=" + idGenre +
                ", Genre_name='" + Genre_name + '\'' +
                '}';
    }
}
