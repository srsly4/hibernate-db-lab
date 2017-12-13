package pl.agh.edu.hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;


@Entity
public class Supplier {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int dbId;
    private String companyName;
    private String street;
    private String city;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.PERSIST)
    private Set<Product> products;

    public Supplier() {
    }

    public Supplier(String companyName, String street, String city) {
        this.companyName = companyName;
        this.street = street;
        this.city = city;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public int getDbId() {
        return dbId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Product> getProducts() {
        return products;
    }
}