package ru.innoJavaCourse.lesson01.db.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table (name = "manufacturer")
public class Manufacturer {
    private Long id;
    private String name;
    private String country;
    private Collection<MobilePhone> phoneCollection;

    public Manufacturer() {
    }

    public Manufacturer(String name, String country) {
        this.name = name;
        this.country = country;
    }

    @Id
    @SequenceGenerator(name = "hibernateSeq", sequenceName = "HIBERNATE_SEQUENCE", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "hibernateSeq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @OneToMany (mappedBy = "manufacturer", fetch = FetchType.EAGER)
    public Collection<MobilePhone> getPhoneCollection() {
        return phoneCollection;
    }

    public void setPhoneCollection(Collection<MobilePhone> phoneCollection) {
        this.phoneCollection = phoneCollection;
    }
}
