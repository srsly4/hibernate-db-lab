package pl.agh.edu.hibernate;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int dbId;
    private String productName;
    private int unitsOnStock;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_FK")
    private Supplier supplier;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_FK")
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="product_transaction",
            joinColumns=@JoinColumn(name="productId"),
            inverseJoinColumns=@JoinColumn(name="salesTransactionId")
    )
    private List<SalesTransaction> salesTransactions = new ArrayList<>();

    public Product() { }

    public Product(String productName, int unitsOnStock) {
        this.productName = productName;
        this.unitsOnStock = unitsOnStock;
    }

    public Product(String productName, int unitsOnStock, Category category) {
        this.productName = productName;
        this.unitsOnStock = unitsOnStock;
        this.category = category;
    }

    public Product(String productName, int unitsOnStock, Supplier supplier, Category category) {
        this.productName = productName;
        this.unitsOnStock = unitsOnStock;
        this.supplier = supplier;
        this.category = category;
    }

    public void addTransaction(SalesTransaction salesTransaction) {
        this.salesTransactions.add(salesTransaction);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUnitsOnStock() {
        return unitsOnStock;
    }

    public void setUnitsOnStock(int unitsOnStock) {
        this.unitsOnStock = unitsOnStock;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getDbId() {
        return dbId;
    }

    public List<SalesTransaction> getSalesTransactions() {
        return salesTransactions;
    }
}