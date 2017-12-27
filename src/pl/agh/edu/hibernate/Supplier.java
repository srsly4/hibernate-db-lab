package pl.agh.edu.hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Supplier {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int dbId;
    private String companyName;
    @Embedded
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Set<Product> products = new HashSet<>();

    public Supplier() {
    }

    public Supplier(String companyName, Address address) {
        this.companyName = companyName;
        this.address = address;
    }

    public void addProduct(Product product) {
        this.products.add(product);
        product.setSupplier(this);
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


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Product> getProducts() {
        return products;
    }
}