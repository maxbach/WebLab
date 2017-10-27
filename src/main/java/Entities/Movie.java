package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "movie_id")
    private long id;
    @OneToOne
    @JoinColumn(name = "movie_ru")
    private MovieLanguage rus;
    @OneToOne
    @JoinColumn(name = "movie_en")
    private MovieLanguage eng;
    @OneToOne
    @JoinColumn(name = "movie_fr")
    private MovieLanguage fra;
    @ManyToOne
    @JoinColumn(name = "genre")
    private Genre genre;

    public Movie() {
    }

    public long getId() {
        return id;
    }

    public MovieLanguage getMovieLanguage(String locale) {
        switch (locale) {
            case "ru":
                return rus;
            case "fr":
                return fra;
            default:
                return eng;
        }
    }

    public String getGenre(String locale) {
        return genre.getRightName(locale);
    }

}
