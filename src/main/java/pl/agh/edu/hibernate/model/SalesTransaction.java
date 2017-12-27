package pl.agh.edu.hibernate.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class SalesTransaction {
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    private int transactionId;

    private int transactionNumber;
    private int quantity;
    private Date timestamp;
    @ColumnDefault(value="TRUE")
    private boolean isDraft = true;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="product_transaction",
            joinColumns=@JoinColumn(name="salesTransactionId"),
            inverseJoinColumns=@JoinColumn(name="productId")
    )
    private List<Product> products = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Customer_FK")
    private Customer customer;

    public SalesTransaction() {
    }

    public SalesTransaction(int transactionNumber, int quantity, Date timestamp, boolean isDraft) {
        this.transactionNumber = transactionNumber;
        this.quantity = quantity;
        this.timestamp = timestamp;
        this.isDraft = isDraft;
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

    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}