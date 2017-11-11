package Entities;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "detail_id")
    private long id;

    @Column(name = "quanity")
    private Integer quanity;

    @ManyToOne
    @JoinColumn(name = "details_order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "details_movie_id")
    private Movie movie;

    public OrderDetail(Integer quanity, Order order, Movie movie) {
        this.quanity = quanity;
        this.order = order;
        this.movie = movie;
    }

    public OrderDetail() {
    }

    public long getId() {
        return id;
    }

    public Integer getQuanity() {
        return quanity;
    }

    public Order getOrder() {
        return order;
    }

    public Movie getMovie() {
        return movie;
    }
}
