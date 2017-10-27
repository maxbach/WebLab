package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "movie_one_language")
public class MovieLanguage {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "movie_language_id")
    private long id;
    @Column(name = "movie_name")
    private String name;
    @Column(name = "movie_description")
    private String description;
    @Column(name = "movie_info")
    private String moreInfo;
    @Column(name = "movie_reviews")
    private String reviews;

    public MovieLanguage() {
    }

    public MovieLanguage(String name, String description, String moreInfo, String reviews) {
        this.name = name;
        this.description = description;
        this.moreInfo = moreInfo;
        this.reviews = reviews;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }
}
