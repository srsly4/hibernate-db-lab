package pl.agh.edu.hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@Entity
@SecondaryTable(name="SUPPLIER_ADDRESS")
public class Supplier {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int dbId;
    private String companyName;

    @Column(table="SUPPLIER_ADDRESS")
    private String zipcode;
    @Column(table="SUPPLIER_ADDRESS")
    private String city;
    @Column(table="SUPPLIER_ADDRESS")
    private String street;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Set<Product> products = new HashSet<>();

    public Supplier() {
    }

    public Supplier(String companyName, String street, String city, String zipcode) {
        this.companyName = companyName;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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