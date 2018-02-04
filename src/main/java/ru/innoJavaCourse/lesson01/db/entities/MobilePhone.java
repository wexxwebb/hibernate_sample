package ru.innoJavaCourse.lesson01.db.entities;

import javax.persistence.*;

@Entity
@Table(name="mobile")
public class MobilePhone {

    private Long id;
    private String model;
    private int cost;
    private String developer;
    private String recense;
    private Certificate certificate;
    private Manufacturer manufacturer;

    public MobilePhone(){

    }

    public MobilePhone(long id, String model, int cost, String recense) {
        this.id = id;
        this.model = model;
        this.cost = cost;
        this.recense = recense;
    }

    public MobilePhone(String model, int cost, String recense) {
        this.model = model;
        this.cost = cost;
        this.recense = recense;
    }

    @Id
    @SequenceGenerator(name = "hibernateSeq", sequenceName = "HIBERNATE_SEQUENCE", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "hibernateSeq")
    @Column(name = "mobile_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getRecense() {
        return recense;
    }

    public void setRecense(String recense) {
        this.recense = recense;
    }

    @OneToOne (optional = false, cascade = CascadeType.ALL)
    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    @ManyToOne (optional = false, cascade = CascadeType.ALL)
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "model='" + model + '\'' +
                ", cost=" + cost +
                ", recense='" + recense + '\'' +
                '}';
    }
}
