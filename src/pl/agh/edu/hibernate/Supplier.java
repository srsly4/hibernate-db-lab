package pl.agh.edu.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sirius on 27.12.17.
 */
@Entity
public class Supplier extends Company {

    private String bankAccountNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    protected Set<Product> products = new HashSet<>();

    public Supplier() {
    }

    public Supplier(String companyName, String street, String city, String zipcode, String bankAccountNumber) {
        super(companyName, street, city, zipcode);
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public void addProduct(Product product) {
        this.products.add(product);
        product.setSupplier(this);
    }


    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "bankAccountNumber='" + bankAccountNumber + '\'' +
                ", dbId=" + dbId +
                ", companyName='" + companyName + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
