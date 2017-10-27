package Entities;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @Column(name = "genre_id", unique = true, nullable = false)
    private Long id;
    @Column(name = "name_ru")
    private String nameRu;
    @Column(name = "name_en")
    private String nameEn;
    @Column(name = "name_fr")
    private String nameFr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameFr() {
        return nameFr;
    }

    public void setNameFr(String nameFr) {
        this.nameFr = nameFr;
    }

    public String getRightName(String locale) {
        switch (locale) {
            case "ru":
                return nameRu;
            case "fr":
                return nameFr;
            default:
                return nameEn;
        }
    }
}
