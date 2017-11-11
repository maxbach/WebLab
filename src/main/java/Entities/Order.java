package Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "order_id")
    private long id;

    @Column(name = "order_user")
    private String userLogin;

    @Column(name = "order_date")
    private String date;

    @Column(name = "isPickup")
    private Boolean isPickup;

    @ManyToOne
    @JoinColumn(name = "order_shop_id")
    private Shop shop;

    @Column(name = "order_address_to_deliver", columnDefinition="TEXT")
    private String address;

    @Transient
    private List<OrderDetail> details;

    public Order(String userLogin, String date, Boolean isPickup, Shop shop, String address) {
        this.userLogin = userLogin;
        this.date = date;
        this.isPickup = isPickup;
        this.shop = shop;
        this.address = address;

    }

    public Order() {
    }

    public long getId() {
        return id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getDate() {
        return date;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

    public Boolean getPickup() {
        return isPickup;
    }

    public Shop getShop() {
        return shop;
    }

    public String getAddress() {
        return address;
    }
}
