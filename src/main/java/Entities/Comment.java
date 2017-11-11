package Entities;

import javax.persistence.*;

@Entity
@Table(name = "user_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "comment_id", unique = true, nullable = false)
    private long id;

    @Column(name = "user_login")
    private String userLogin;

    @Column(name = "text", columnDefinition="TEXT")
    private String text;

    @Column(name = "comment_date")
    private String date;

    public Comment(String userLogin, String text, String date) {
        this.userLogin = userLogin;
        this.text = text;
        this.date = date;
    }

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }
}
