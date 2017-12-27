package pl.agh.edu.hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@SecondaryTable(name="COMPANY_ADDRESS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Company {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    protected int dbId;
    protected String companyName;

    @Column(table="COMPANY_ADDRESS")
    protected String zipcode;
    @Column(table="COMPANY_ADDRESS")
    protected String city;
    @Column(table="COMPANY_ADDRESS")
    protected String street;

    public Company() {
    }

    public Company(String companyName, String street, String city, String zipcode) {
        this.companyName = companyName;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
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
}