package edu.sabanciuniv;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingMall {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "shoppingMall")
    //@JoinColumn(name = "shoppingMall_id")
    private List<Store> storeList = new ArrayList<>();

    public ShoppingMall(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public ShoppingMall() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    @Override
    public String toString() {
        return "ShoppingMall{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
