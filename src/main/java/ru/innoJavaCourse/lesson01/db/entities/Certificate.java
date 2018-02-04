package ru.innoJavaCourse.lesson01.db.entities;

import javax.persistence.*;

@Entity
@Table(name="CERTIFICATE")
public class Certificate {
    private Long id;
    private String certNumber;
    private MobilePhone phone;

    public Certificate() {
    }

    public Certificate(String certNumber, MobilePhone phone) {
        this.certNumber = certNumber;
        this.setPhone(phone);
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

    public String getCertNumber() {
        return certNumber;
    }

    public void setCertNumber(String certNumber) {
        this.certNumber = certNumber;
    }

    @OneToOne (optional = false, mappedBy = "certificate")
    public MobilePhone getPhone() {
        return phone;
    }

    public void setPhone(MobilePhone phone) {
        this.phone = phone;
    }
}
