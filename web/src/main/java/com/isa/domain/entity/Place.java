package com.isa.domain.entity;

import javax.persistence.*;
import java.util.List;

@NamedQueries(
        @NamedQuery(name = "Place.findAll", query = "SELECT p FROM Place p")
)

@Entity
@Table (name = "place")
public class Place {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column (name = "api_id")
    private int apiId;

    @Column (name = "subname")
    private String subName;

    @Column (name = "name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "address_id", unique = true)
    private Address address;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "place")
    private List<Event> event;

    public Place() {
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public int getId() {
        return id;
    }

    public String getSubName() {
        return subName;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<Event> getEvent() {
        return event;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }
}
