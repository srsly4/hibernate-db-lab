package pl.agh.edu.hibernate.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SalesTransaction {
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    private int transactionId;

    private int transactionNumber;
    private int quantity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="product_transaction",
            joinColumns=@JoinColumn(name="salesTransactionId"),
            inverseJoinColumns=@JoinColumn(name="productId")
    )
    private List<Product> products = new ArrayList<>();

    public SalesTransaction() {
    }

    public SalesTransaction(int transactionNumber, int quantity) {
        this.transactionNumber = transactionNumber;
        this.quantity = quantity;
    }

    public void addProduct(Product product) {
        this.products.add(product);
        product.addTransaction(this);
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getTransactionId() {
        return transactionId;
    }
}