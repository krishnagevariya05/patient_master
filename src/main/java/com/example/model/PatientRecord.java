package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class patient {
    @Id
    private Long id;

    private Integer age;
    private String name;
    private String address;

    public patient(Long id, Integer age, String name, String address) {
        this.id = id;
        this.age=age;
        this.name = name;
        this.address = address;
    }

    public patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
}
