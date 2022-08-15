package com.network.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;



@Entity
public class Peripheral {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    private String vendor;

    //@CreatedDate
    @CreationTimestamp
    private Date creationDate;

    @Enumerated(EnumType.STRING)
    private PeripheralStatus status;

    @JsonIgnore
    @JoinColumn(name = "gateway_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Valid
    private Gateway gateway;

    public Gateway getGateway() {
        return gateway;
    }

    public void setGateway(Gateway gateway) {
        this.gateway = gateway;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public PeripheralStatus getStatus() {
        return status;
    }

    public void setStatus(PeripheralStatus status) {
        this.status = status;
    }
}
