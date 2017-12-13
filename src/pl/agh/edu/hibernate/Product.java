package pl.agh.edu.hibernate;



import javax.persistence.*;


@Entity
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int dbId;
    private String productName;
    private int unitsOnStock;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_FK")
    private Supplier supplier;

    public Product() { }

    public Product(String productName, int unitsOnStock) {
        this.productName = productName;
        this.unitsOnStock = unitsOnStock;
    }

    public Product(String productName, int unitsOnStock, Supplier supplier) {
        this.productName = productName;
        this.unitsOnStock = unitsOnStock;
        this.supplier = supplier;
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
}