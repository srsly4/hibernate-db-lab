package pl.agh.edu.hibernate;

import javax.persistence.Entity;

/**
 * Created by sirius on 27.12.17.
 */
@Entity
public class Customer extends Company {

    private int discount;

    public Customer() { }

    public Customer(String companyName, String street, String city, String zipcode, int discount) {
        super(companyName, street, city, zipcode);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
